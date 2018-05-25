package com.bdqnsxt.oa.dto;

import com.bdqnsxt.oa.enums.ComputerEnum;
import com.bdqnsxt.oa.enums.ForeignEnum;
import com.bdqnsxt.oa.enums.GenderEnum;
import com.bdqnsxt.oa.enums.RecordEnum;
import com.bdqnsxt.oa.model.Clazz;
import com.bdqnsxt.oa.model.Student;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class StudentDto {
    private long   id;
    private String stuName;
    private String idCard;
    private String mobilePhone;
    private GenderEnum gender;
    //入校时间
    private Date   schoolTime;
    //毕业时间
    private Date   gradutionTime;
    //毕业院校
    private String gradutionFrom;
    //学历
    private RecordEnum gradutionRecord;
    //外语等级
    private ForeignEnum foreignLevel;
    //qq
    private String  qq;
    private String  email;
    //紧急联系人
    private String  contactor;
    //紧急联系人电话
    private String  contactorPhone;
    private String  remarks;
    private ComputerEnum computerSkill;
    @JsonProperty("currentClazz.id")
    private long   currentClazzId;
    private Student.StatusEnum status;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public Date getSchoolTime() {
        return schoolTime;
    }

    public void setSchoolTime(Date schoolTime) {
        this.schoolTime = schoolTime;
    }

    public Date getGradutionTime() {
        return gradutionTime;
    }

    public void setGradutionTime(Date gradutionTime) {
        this.gradutionTime = gradutionTime;
    }

    public String getGradutionFrom() {
        return gradutionFrom;
    }

    public void setGradutionFrom(String gradutionFrom) {
        this.gradutionFrom = gradutionFrom;
    }

    public RecordEnum getGradutionRecord() {
        return gradutionRecord;
    }

    public void setGradutionRecord(RecordEnum gradutionRecord) {
        this.gradutionRecord = gradutionRecord;
    }

    public ForeignEnum getForeignLevel() {
        return foreignLevel;
    }

    public void setForeignLevel(ForeignEnum foreignLevel) {
        this.foreignLevel = foreignLevel;
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

    public String getContactor() {
        return contactor;
    }

    public void setContactor(String contactor) {
        this.contactor = contactor;
    }

    public String getContactorPhone() {
        return contactorPhone;
    }

    public void setContactorPhone(String contactorPhone) {
        this.contactorPhone = contactorPhone;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public ComputerEnum getComputerSkill() {
        return computerSkill;
    }

    public void setComputerSkill(ComputerEnum computerSkill) {
        this.computerSkill = computerSkill;
    }

    public long getCurrentClazzId() {
        return currentClazzId;
    }

    public void setCurrentClazzId(long currentClazzId) {
        this.currentClazzId = currentClazzId;
    }

    public Student.StatusEnum getStatus() {
        return status;
    }

    public void setStatus(Student.StatusEnum status) {
        this.status = status;
    }
}
