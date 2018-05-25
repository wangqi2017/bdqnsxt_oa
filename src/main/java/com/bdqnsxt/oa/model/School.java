package com.bdqnsxt.oa.model;

import com.bdqnsxt.oa.dto.SchoolDto;
import com.bdqnsxt.oa.dto.StudentDto;
import com.bdqnsxt.oa.enums.OrganizationEnum;
import com.bdqnsxt.oa.enums.ProvinceEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.BeanUtils;

import java.util.List;

public class School extends AbstractModel {

    private String scname;
    private OrganizationEnum organization;
    private ProvinceEnum province;
    private String address;
    private String leader;
    private String leaderPhone;

    private List<Clazz> currentClazzes;
    private List<Clazz> totalClazzes;
    private List<User>  teachers;

    private List<Department> departments;
    @JsonIgnore
    private List<User>  users;



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

    @Override
    public String getDisplayClassName() {
        return "校区";
    }

    @Override
    public String getDisplayName() {
        return getScname();
    }

    public List<Clazz> getCurrentClazzes() {
        return currentClazzes;
    }

    public void setCurrentClazzes(List<Clazz> currentClazzes) {
        this.currentClazzes = currentClazzes;
    }

    public int getCurrentStudents(){
        return 0;
    }

    public List<Clazz> getTotalClazzes() {
        return totalClazzes;
    }

    public void setTotalClazzes(List<Clazz> totalClazzes) {
        this.totalClazzes = totalClazzes;
    }

    public List<User> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<User> teachers) {
        this.teachers = teachers;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public boolean getExpanded() {
        return true;
    }

    public int getUserCount(){
        if(users!=null&&users.size()>0){
            return users.size();
        }else{
            return 0;
        }

    }

    public int getRoleCount(){
        int count = 0;
        if(departments!=null&&departments.size()>0){
            for(Department d:departments){
                count += d.getRoles().size();
            }
        }
        return count;
    }

    public String getName(){
        return getScname();
    }

    public Long getParentId() {
        return null;
    }

    public School getSchoolCopy(SchoolDto dto){
        BeanUtils.copyProperties(dto,this);
        return this;
    }
}
