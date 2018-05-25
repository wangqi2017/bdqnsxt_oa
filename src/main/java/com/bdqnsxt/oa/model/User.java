package com.bdqnsxt.oa.model;

import com.bdqnsxt.oa.dto.UserDto;
import com.bdqnsxt.oa.enums.GenderEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.*;

public class User extends AbstractModel{

    private String username;
    @JsonIgnore
    private String password;
    private String fullname;
    private String qq;
    private String email;
    private GenderEnum gender;
    private String mobilePhone;
    private StatusEnum status;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date   hireDate;

    private boolean isAdmin;
    private boolean isLeader;

    private School school;
    private Department department;
    private List<SystemRole> roles;
    private Set<String> menus;
    private Set<Resource> resources;


    public static enum StatusEnum {
        ACTIVE, INACTIVE
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }


    @Override
    public String getDisplayClassName() {
        return "用户";
    }

    @Override
    public String getDisplayName() {
        return getUsername();
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public List<SystemRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SystemRole> roles) {
        this.roles = roles;
    }


    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isLeader() {
        return isLeader;
    }

    public void setLeader(boolean leader) {
        isLeader = leader;
    }

    public Set<String> getMenus() {
        menus = new HashSet<>();
        if(roles!=null&&roles.size()>0){
            for(SystemRole role:roles){
                for(String menu:role.getMenus()){
                    menus.add(menu);
                }
            }
        }
        return menus;
    }

    public void setMenus(Set<String> menus) {
        this.menus = menus;
    }

    public Set<Resource> getResources() {
        resources = new HashSet<>();
        if(roles!=null&&roles.size()>0){
            for(SystemRole role:roles){
                for(Resource resource:role.getResources()){
                    resources.add(resource);
                }
            }
        }
        return resources;
    }

    public void setResources(Set<Resource> resources) {
        this.resources = resources;
    }



    public User getUserCopy(UserDto dto){
        BeanUtils.copyProperties(dto,this);
        if(dto.getSchoolId()>0){
            School s = new School();
            s.setId(dto.getSchoolId());
            this.school = s;
        }
        if(dto.getDepartmentId()>0){
           Department d = new Department();
           d.setId(dto.getDepartmentId());
           this.department = d;
        }
        String[] roleIds = dto.getRoleIds();
        if(roleIds!=null&&roleIds.length>0){
           List<SystemRole> roles = new ArrayList<>();
           for(String roleId:roleIds){
               SystemRole r = new SystemRole();
               r.setId(Long.valueOf(roleId));
               roles.add(r);
           }
           this.roles = roles;
        }
        return this;
    }
}
