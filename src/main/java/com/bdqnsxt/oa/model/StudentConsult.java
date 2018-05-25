package com.bdqnsxt.oa.model;

import com.bdqnsxt.oa.dto.ConsultDto;
import com.bdqnsxt.oa.dto.StudentDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.BeanUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentConsult extends AbstractModel{

    private Student student;
    private User consulter;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date lastLockTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date quizTime;
    private String firstVisit;
    private String secondVisit;
    private String thirdVisit;
    private String remarks;
    //意向等级
    private int    purpose;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public User getConsulter() {
        return consulter;
    }

    public void setConsulter(User consulter) {
        this.consulter = consulter;
    }

    public Date getLastLockTime() {
        return lastLockTime;
    }

    public void setLastLockTime(Date lastLockTime) {
        this.lastLockTime = lastLockTime;
    }

    public Date getQuizTime() {
        return quizTime;
    }

    public void setQuizTime(Date quizTime) {
        this.quizTime = quizTime;
    }

    public String getFirstVisit() {
        return firstVisit;
    }

    public void setFirstVisit(String firstVisit) {
        this.firstVisit = firstVisit;
    }

    public String getSecondVisit() {
        return secondVisit;
    }

    public void setSecondVisit(String secondVisit) {
        this.secondVisit = secondVisit;
    }

    public String getThirdVisit() {
        return thirdVisit;
    }

    public void setThirdVisit(String thirdVisit) {
        this.thirdVisit = thirdVisit;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getPurpose() {
        return purpose;
    }

    public void setPurpose(int purpose) {
        this.purpose = purpose;
    }

    @Override
    public String getDisplayClassName() {
        return "学员咨询";
    }

    @JsonIgnore
    @Override
    public String getDisplayName() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if(student!=null&&consulter!=null){
            String str =
            "<" + consulter.getUsername() +"("+ consulter.getFullname() +")> : <" + student.getStuName() + "("+ student.getMobilePhone()+")" +">"
                    + ";一次回访："+firstVisit
                    +";二次回访："+ secondVisit + ";三次回访："+ thirdVisit+ ";备注："+remarks;
            if(lastLockTime!=null){
                str += ";锁定时间：" + df.format(lastLockTime);
            }
            if(quizTime!=null){
                str += ";面试时间："+df.format(quizTime);
            }
            return str;
        }
        return null;
    }

    public StudentConsult getStudentConsultCopy(ConsultDto dto){
        BeanUtils.copyProperties(dto,this);
        if(dto.getConsulterId()>0){
            User consulter = new User();
            consulter.setId(dto.getConsulterId());
            consulter.setUsername(dto.getCosulterName());
            this.consulter = consulter;

        }
        if(dto.getStuId()>0){
            Student student = new Student();
            student.setId(dto.getStuId());
            student.setStuName(dto.getStuName());
            this.student=student;
        }
        return this;
    }
}
