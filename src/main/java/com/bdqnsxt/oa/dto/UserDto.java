package com.bdqnsxt.oa.dto;

import com.bdqnsxt.oa.enums.GenderEnum;
import com.bdqnsxt.oa.model.AbstractModel;
import com.bdqnsxt.oa.model.School;
import com.bdqnsxt.oa.model.SystemRole;
import com.bdqnsxt.oa.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class UserDto{
    private long id;
    private String username;
    private String fullname;
    private String qq;
    private String email;
    private GenderEnum gender;
    private String mobilePhone;
    private User.StatusEnum status;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date   hireDate;

    private boolean isAdmin;
    private boolean isLeader;

    @JsonProperty("school.id")
    private long schoolId;
    @JsonProperty("department.id")
    private long departmentId;
    @JsonProperty("roleIds")
    private String[] roleIds;
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public User.StatusEnum getStatus() {
        return status;
    }

    public void setStatus(User.StatusEnum status) {
        this.status = status;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }


    public long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(long schoolId) {
        this.schoolId = schoolId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public String[] getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String[] roleIds) {
        this.roleIds = roleIds;
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
}
