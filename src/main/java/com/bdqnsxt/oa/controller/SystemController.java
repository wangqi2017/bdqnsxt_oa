package com.bdqnsxt.oa.controller;

import com.bdqnsxt.oa.dto.UserPassDto;
import com.bdqnsxt.oa.exception.PasswordErrorException;
import com.bdqnsxt.oa.exception.ServiceException;
import com.bdqnsxt.oa.model.User;
import com.bdqnsxt.oa.service.UserService;
import com.bdqnsxt.oa.utils.JsonUtils;
import com.bdqnsxt.oa.utils.MenuUtils;
import com.bdqnsxt.oa.utils.ResponseUtils;
import com.bdqnsxt.oa.utils.UserUtils;
import com.fasterxml.jackson.databind.JsonNode;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@SessionAttributes(types = {User.class})
public class SystemController {

    private Logger log = LoggerFactory.getLogger(SystemController.class);

    @Autowired
    private UserService userService;

    //提供treestore的store
    @RequestMapping(value="/westviewstore.json",produces = "application/json;charset=utf-8")
    public String getWestViewStore() throws Exception{
        String filePath = "classpath:main_menu_store.json";
        String str = FileUtils.readFileToString(ResourceUtils.getFile(filePath),"utf-8");
        System.out.print(str);
        return str;
    }

    //提供accordion的view
    @RequestMapping(value="/core/system/view/WestView.js",produces = "application/json;charset=utf-8")
    public ModelAndView getWestView(Model model,@ModelAttribute(UserUtils.LOGIN_KEY) User user) throws Exception{
        //防止打jar后找不到文件
        String filePath = MenuUtils.MENU_PATH;
        InputStream in = this.getClass().getResourceAsStream( MenuUtils.MENU_PATH);
        String items = com.bdqnsxt.oa.utils.FileUtils.readInfoStream(in);
        JsonNode jn = JsonUtils.fromJson2(items);
        //String items = FileUtils.readFileToString(ResourceUtils.getFile(filePath),"utf-8");
        if(!user.isAdmin()&&!user.isLeader()){
            Set<String> visblieMenus = user.getMenus();
            MenuUtils.checkAndRemoveMenuNodes(jn,visblieMenus);
        }
        model.addAttribute("items",jn);
        return new ModelAndView("system/WestView");


    }

    @RequestMapping(value="/")
    public ModelAndView getIndex(Model model) throws Exception{
        return new ModelAndView("system/index");
    }

    @RequestMapping(value="/login",method = RequestMethod.GET)
    public ModelAndView getLogin(Model model) throws Exception{
        model.addAttribute("resp", ResponseUtils.extJSProxyResponse(false,""));
        return new ModelAndView("system/login");
    }

    @RequestMapping(value="/login",method = RequestMethod.POST)
    public ModelAndView handleLogin(Model model, User user, HttpServletRequest req) throws Exception{
        try{
            log.info(String.valueOf(req.getSession().getMaxInactiveInterval()));
            User u = userService.login(user);
            model.addAttribute(UserUtils.LOGIN_KEY,u);
            return new ModelAndView("redirect:/");
        }catch (ServiceException e){
            model.addAttribute("resp", ResponseUtils.extJSProxyResponse(false,e.getMessage()));
            return new ModelAndView("system/login");
        }
    }

    @RequestMapping(value="/logout",method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest req,Model model) throws Exception{
        req.getSession().removeAttribute(UserUtils.LOGIN_KEY);
        return new ModelAndView("redirect:/login");
    }

    @RequestMapping(value="/userPass",method = RequestMethod.POST, consumes="application/json;charset=utf-8")
    public Map<String, Object> userPass(@RequestBody UserPassDto dto) throws Exception {
        try {
            userService.userPass(dto.getOldPassword(), dto.getNewPassword());
            return ResponseUtils.successExtJSProxyResponse("密码修改成功");
        }catch (PasswordErrorException e){
            return ResponseUtils.failureExtJSProxyResponse(e.getMessage());
        }
    }
}
