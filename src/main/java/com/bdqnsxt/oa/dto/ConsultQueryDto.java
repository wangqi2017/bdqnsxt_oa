package com.bdqnsxt.oa.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ConsultQueryDto {
    private Long id;
    private String stuName;
    private String stuStatus;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date quizTime;
    private Integer purpose;
    private Long consulterId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuStatus() {
        return stuStatus;
    }

    public void setStuStatus(String stuStatus) {
        this.stuStatus = stuStatus;
    }

    public Date getQuizTime() {
        return quizTime;
    }

    public void setQuizTime(Date quizTime) {
        this.quizTime = quizTime;
    }

    public Integer getPurpose() {
        return purpose;
    }

    public void setPurpose(Integer purpose) {
        this.purpose = purpose;
    }

    public Long getConsulterId() {
        return consulterId;
    }

    public void setConsulterId(Long consulterId) {
        this.consulterId = consulterId;
    }
}
