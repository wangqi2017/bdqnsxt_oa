package com.bdqnsxt.oa.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ConsultDto {

    private long  id;
    @JsonProperty("consulter.id")
    private long  consulterId;
    @JsonProperty("consulter.fullname")
    private String cosulterName;
    @JsonProperty("student.stuName")
    private String stuName;
    @JsonProperty("student.id")
    private long  stuId;
    private int   purpose;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date  quizTime;
    private String firstVisit;
    private String secondVisit;
    private String thirdVisit;
    private String remarks;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCosulterName() {
        return cosulterName;
    }

    public void setCosulterName(String cosulterName) {
        this.cosulterName = cosulterName;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public long getConsulterId() {
        return consulterId;
    }

    public void setConsulterId(long consulterId) {
        this.consulterId = consulterId;
    }

    public long getStuId() {
        return stuId;
    }

    public void setStuId(long stuId) {
        this.stuId = stuId;
    }

    public int getPurpose() {
        return purpose;
    }

    public void setPurpose(int purpose) {
        this.purpose = purpose;
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
}
