package com.bdqnsxt.oa.dto;

import com.bdqnsxt.oa.enums.*;
import com.bdqnsxt.oa.model.Clazz;
import com.bdqnsxt.oa.model.Department;
import com.bdqnsxt.oa.model.Student;
import com.bdqnsxt.oa.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class SchoolDto {
    private long id;
    private String scname;
    private OrganizationEnum organization;
    private ProvinceEnum province;
    private String address;
    private String leader;
    private String leaderPhone;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getScname() {
        return scname;
    }

    public void setScname(String scname) {
        this.scname = scname;
    }

    public OrganizationEnum getOrganization() {
        return organization;
    }

    public void setOrganization(OrganizationEnum organization) {
        this.organization = organization;
    }

    public ProvinceEnum getProvince() {
        return province;
    }

    public void setProvince(ProvinceEnum province) {
        this.province = province;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getLeaderPhone() {
        return leaderPhone;
    }

    public void setLeaderPhone(String leaderPhone) {
        this.leaderPhone = leaderPhone;
    }
}
