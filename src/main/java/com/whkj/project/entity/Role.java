package com.whkj.project.entity;

public class Role {
    private Integer id;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 角色标识
     */
    private String perms;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }
}