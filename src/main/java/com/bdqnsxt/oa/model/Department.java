package com.bdqnsxt.oa.model;

import com.bdqnsxt.oa.dto.DepartmentDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.BeanUtils;

import java.util.List;

public class Department extends AbstractModel{

    private String dtname;
    private String description;
    @JsonIgnore
    private School school;
    @JsonProperty("departments")
    private List<SystemRole> roles;
    @JsonIgnore
    private List<User> users;

    public String getDtname() {
        return dtname;
    }

    public void setDtname(String dtname) {
        this.dtname = dtname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public String getDisplayClassName() {
        return "部门";
    }

    @Override
    public String getDisplayName() {
        return getDtname();
    }

    public List<SystemRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SystemRole> roles) {
        this.roles = roles;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public int getUserCount(){
        if(users!=null){
            return users.size();
        }
        return 0;
    }

    public int getRoleCount(){
        if(roles!=null){
            return roles.size();
        }
        return 0;
    }

    public String getName(){
        return getDtname();
    }

    public long getParentId() {
        if(school!=null){
            return school.getId();
        }
        return 0l;
    }

    public boolean getLeaf() {
        return true;
    }

    public Department getDepartmentCopy(DepartmentDto dto){
        BeanUtils.copyProperties(dto,this);
        this.dtname = dto.getName();
        if(dto.getParentId()>0){
            School s = new School();
            s.setId(dto.getParentId());
            this.school = s;
        }
        return this;
    }
}
