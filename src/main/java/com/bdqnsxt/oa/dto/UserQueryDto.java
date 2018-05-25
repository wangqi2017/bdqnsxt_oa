package com.bdqnsxt.oa.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class UserQueryDto {
    private String username;
    private String mobilePhone;
    private String hireDateStart;
    private String hireDateEnd;
    private Long roleId;
    private Long schoolId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getHireDateStart() {
        return hireDateStart;
    }

    public void setHireDateStart(String hireDateStart) {
        this.hireDateStart = hireDateStart;
    }

    public String getHireDateEnd() {
        return hireDateEnd;
    }

    public void setHireDateEnd(String hireDateEnd) {
        this.hireDateEnd = hireDateEnd;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }
}
