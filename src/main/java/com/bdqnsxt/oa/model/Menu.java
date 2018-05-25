package com.bdqnsxt.oa.model;

import java.util.List;

public class Menu {
    private String id;// 菜单id
    private String text;// 菜单名称
    private boolean checked = false;
    private boolean leaf = true;
    private boolean loaded = true;
    private boolean expanded = true;
    public List<Menu> children;

    public Menu() {}

    public Menu(String id, String text) {
        this.id = id;
        this.text = text;
    }

    public Menu(String id, String text, boolean leaf) {
        this.id = id;
        this.text = text;
        this.leaf = leaf;
    }

    public Menu(String id, String text, boolean leaf, boolean loaded) {
        this.id = id;
        this.text = text;
        this.leaf = leaf;
        this.loaded = loaded;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public boolean isLoaded() {
        return loaded;
    }

    public void setLoaded(boolean loaded) {
        this.loaded = loaded;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }
}
