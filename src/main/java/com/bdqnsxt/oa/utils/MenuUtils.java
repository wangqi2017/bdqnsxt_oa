package com.bdqnsxt.oa.utils;

import com.bdqnsxt.oa.model.Menu;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class MenuUtils {

    public static final String MENU_PATH = "/main_menu.json";
    private static Logger logger = LoggerFactory.getLogger(MenuUtils.class);

    public static List<Menu> getMenuList(List<String> visibleMenus) throws Exception{
        try {
            InputStream in = MenuUtils.class.getResourceAsStream(MenuUtils.MENU_PATH);
            String items = com.bdqnsxt.oa.utils.FileUtils.readInfoStream(in);
            JsonNode jn = JsonUtils.fromJson2(items);
            List<Menu> menuList = new LinkedList<>();
            for (JsonNode menu : jn) {
                Menu menus = new Menu();
                List<Menu> subMenu;;
                menus.setLeaf(false);
                menus.setText(menu.get("title").asText());
                String id = menu.get("id").asText();
                menus.setId(id);
                menus.setChecked(visibleMenus.contains(id));
                subMenu = processSection(menu, visibleMenus);
                menus.setChildren(subMenu);
                menuList.add(menus);
            }
            return menuList;
        }catch (IOException e) {
            logger.error("getMenuList()", e);
        }
        return null;
    }

    private static List<Menu> processSection(JsonNode parentMenu, List<String> visibleMenus) {
        JsonNode itemNode = parentMenu.get("items");
        List<Menu> sectionMenuList = new LinkedList<>();
        if(itemNode instanceof ArrayNode){
            ArrayNode an = (ArrayNode)itemNode;
            for(int i=0;i<an.size();i++){
                JsonNode storeNode = itemNode.get(i).get("store");
                JsonNode rootNode = storeNode.get("root");
                JsonNode children = rootNode.get("children");
                List<Menu> ms = getSectionMenuList(children, visibleMenus);
                if(ms.size()>1){
                    sectionMenuList = ms;
                }else{
                    Menu menu  = ms.get(0);
                    sectionMenuList.add(menu);
                }

            }
        }else{
            JsonNode storeNode = itemNode.get(0).get("store");
            JsonNode rootNode = storeNode.get("root");
            JsonNode children = rootNode.get("children");
            sectionMenuList = getSectionMenuList(children, visibleMenus);
        }
        return sectionMenuList;
    }

    private static List<Menu> getSectionMenuList(JsonNode children, List<String> visibleMenus){
        List<Menu> sectionMenuList = new LinkedList<>();
        for (JsonNode childrenNode : children) {
            Menu section = new Menu();
            List<Menu> sectionChildrenList = new LinkedList<>();
            String menuId = childrenNode.get("id").asText();
            section.setId(menuId);
            section.setChecked(visibleMenus.contains(menuId));
            section.setText(childrenNode.get("text").asText());
            // 如果有children，那么菜单是不是叶子节点
            if (childrenNode.has("children")) {
                section.setLeaf(false);
                // 继续分解菜单
                JsonNode subNode = childrenNode.get("children");
                for (JsonNode menu : subNode) {
                    sectionChildrenList.add(processChildren(menu, visibleMenus));
                }
            }
            section.setChildren(sectionChildrenList);
            sectionMenuList.add(section);
        }
        return sectionMenuList;
    }

    private static Menu processChildren(JsonNode menu, List<String> visibleMenus) {
        Menu menuItem = new Menu();
        menuItem.setText(menu.get("text").asText());
        String id = menu.get("id").asText();
        menuItem.setId(id);
        menuItem.setChecked(visibleMenus.contains(id));
        if (menu.has("children")) {
            menuItem.setLeaf(false);
            JsonNode childrenNode = menu.get("children");
            List<Menu> menuItemList = new LinkedList<>();
            for (int i = 0; i < childrenNode.size(); i++) {
                menuItemList.add(processChildren(childrenNode.get(i), visibleMenus));
            }
            menuItem.setChildren(menuItemList);
        }
        return menuItem;
    }

    public static void checkAndRemoveMenuNodes(JsonNode node, Set<String> visibleMenus) {
        if(node instanceof ArrayNode){
            List<String> toRemove = new LinkedList<>();
            for(int i=0;i<node.size();i++){
                String id = node.get(i).get("id").asText();
                if(visibleMenus.contains(id)){
                    checkAndRemoveSection(node.get(i),visibleMenus);
                }else{
                    toRemove.add(id);
                }
            }

            ArrayNode an = (ArrayNode) node;
            removeNode(an,toRemove);
        }
    }

    private static void checkAndRemoveSection(JsonNode node, Set<String> visibleMenus) {
        JsonNode itemNode = node.get("items");
        if(itemNode instanceof ArrayNode){
            ArrayNode an = (ArrayNode)itemNode;
            for(int i=0;i<an.size();i++){
                JsonNode storeNode = itemNode.get(i).get("store");
                JsonNode rootNode = storeNode.get("root");
                checkAndRemoveChildren(rootNode, visibleMenus);
            }
        }else{
            JsonNode storeNode = itemNode.get(0).get("store");
            JsonNode rootNode = storeNode.get("root");
            checkAndRemoveChildren(rootNode, visibleMenus);
        }
    }

    private static void checkAndRemoveChildren(JsonNode node, Set<String> visibleMenus) {
        if(node.has("children")){
            JsonNode children = node.get("children");
            List<String> toRemove = new LinkedList<>();
            for(int i=0;i<children.size();i++){
                String id = children.get(i).get("id").asText();
                if(visibleMenus.contains(id)){
                    checkAndRemoveChildren(children.get(i),visibleMenus);
                }else{
                    toRemove.add(id);
                }
            }

            ArrayNode an = (ArrayNode) children;
            removeNode(an,toRemove);
        }
    }

    private static void removeNode(ArrayNode an,List<String> toRemove){
        for(String id:toRemove){
            int toRemoveIndex = -1;
            for(int i=0;i<an.size();i++){
                if(an.get(i).has("id")&&(an.get(i).get("id").asText().equals(id))){
                    an.remove(i);
                    break;
                }
            }
        }
    }


}
