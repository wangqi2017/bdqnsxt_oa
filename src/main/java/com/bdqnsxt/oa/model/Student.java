package com.bdqnsxt.oa.model;

import com.bdqnsxt.oa.dto.ClazzDto;
import com.bdqnsxt.oa.dto.StudentDto;
import com.bdqnsxt.oa.enums.ComputerEnum;
import com.bdqnsxt.oa.enums.ForeignEnum;
import com.bdqnsxt.oa.enums.GenderEnum;
import com.bdqnsxt.oa.enums.RecordEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Date;

public class Student extends AbstractModel{

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
    private Clazz   currentClazz;
    private StatusEnum status;

    private StudentConsult studentConsult;


    public static enum StatusEnum{
        咨询,试听,报名,就读,结业,就业,离校,失联
    }

    @Override
    public String getDisplayClassName() {
        return "学生";
    }

    @Override
    public String getDisplayName() {
        return getStuName();
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

    public Clazz getCurrentClazz() {
        return currentClazz;
    }

    public void setCurrentClazz(Clazz currentClazz) {
        this.currentClazz = currentClazz;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public StudentConsult getStudentConsult() {
        return studentConsult;
    }

    public void setStudentConsult(StudentConsult studentConsult) {
        this.studentConsult = studentConsult;
    }

    public Student getStudentCopy(StudentDto dto){
        BeanUtils.copyProperties(dto,this);
        if(dto.getCurrentClazzId()>0){
            Clazz clazz = new Clazz();
            clazz.setId(dto.getCurrentClazzId());
            this.setCurrentClazz(clazz);
        }
        return this;
    }
}
