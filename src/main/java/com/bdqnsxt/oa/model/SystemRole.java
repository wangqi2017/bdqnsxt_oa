package com.bdqnsxt.oa.model;

import com.bdqnsxt.oa.dto.SchoolDto;
import com.bdqnsxt.oa.dto.SystemRoleDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.BeanUtils;

import java.util.List;

public class SystemRole extends AbstractModel {

    private String roleName;
    private String description;
    private Department department;
    @JsonIgnore
    private List<String> menus;
    @JsonIgnore
    private List<Resource> resources;
    @JsonIgnore
    private List<User> users;


    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<String> getMenus() {
        return menus;
    }

    public void setMenus(List<String> menus) {
        this.menus = menus;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    @Override
    public String getDisplayClassName() {
        return "角色";
    }

    @Override
    public String getDisplayName() {
        return getRoleName();
    }

    public long getUserCount(){
        if(users!=null&&users.size()>0){
            return users.size();
        }
        return 0;
    }

    public SystemRole getSystemRoleCopy(SystemRoleDto dto){
        BeanUtils.copyProperties(dto,this);
        if(dto.getDepartmentId()>0){
            Department d = new Department();
            d.setId(dto.getDepartmentId());
            this.department = d;
        }
        return this;
    }

    public String getName(){
        return getRoleName();
    }

    public boolean getLeaf() {
        return true;
    }
}
