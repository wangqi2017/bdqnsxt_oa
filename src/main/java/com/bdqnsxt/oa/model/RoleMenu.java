package com.bdqnsxt.oa.model;

public class RoleMenu extends AbstractModel{

    private long roleId;
    private long copiedRoleId;
    private String[] menuIds;

    @Override
    public String getDisplayClassName() {
        return "菜单权限";
    }

    @Override
    public String getDisplayName() {
        String mes = "岗位id为"+roleId;
        if(copiedRoleId>0){
            mes += ";被复制的岗位id为"+copiedRoleId;
        }
        return mes;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String[] getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(String[] menuIds) {
        this.menuIds = menuIds;
    }

    public long getCopiedRoleId() {
        return copiedRoleId;
    }

    public void setCopiedRoleId(long copiedRoleId) {
        this.copiedRoleId = copiedRoleId;
    }

    public RoleMenu(){}

    public RoleMenu(long roleId,String[] menuIds){
        this.roleId = roleId;
        this.menuIds = menuIds;
    }

    public RoleMenu(long roleId,long copiedRoleId){
        this.roleId = roleId;
        this.copiedRoleId = copiedRoleId;
    }
}
