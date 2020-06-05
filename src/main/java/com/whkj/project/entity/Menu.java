package com.whkj.project.entity;

public class Menu {
    private Integer id;

    /**
    * 权限名称
    */
    private String menuName;

    /**
    * 权限标识
    */
    private String perms;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }
}