package com.bdqnsxt.oa.dto;

import com.bdqnsxt.oa.model.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class ClazzDto{

    private long  id;
    private String clname;
    private Clazz.OrientationEnum orientation;
    @JsonProperty("belongSchool.id")
    private long schoolId;
    private Date   startDate;
    private Date   endDate;
    private Clazz.StatusEnum status;
    @JsonProperty("lecturer.id")
    private long lecturerId;
    @JsonProperty("tutors.ids")
    private String tutorIds;
    @JsonProperty("classLeader.id")
    private long classLeaderId;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClname() {
        return clname;
    }

    public void setClname(String clname) {
        this.clname = clname;
    }



    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Clazz.OrientationEnum getOrientation() {
        return orientation;
    }

    public void setOrientation(Clazz.OrientationEnum orientation) {
        this.orientation = orientation;
    }

    public long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(long schoolId) {
        this.schoolId = schoolId;
    }

    public Clazz.StatusEnum getStatus() {
        return status;
    }

    public void setStatus(Clazz.StatusEnum status) {
        this.status = status;
    }

    public long getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(long lecturerId) {
        this.lecturerId = lecturerId;
    }

    public String getTutorIds() {
        return tutorIds;
    }

    public void setTutorIds(String tutorIds) {
        this.tutorIds = tutorIds;
    }

    public long getClassLeaderId() {
        return classLeaderId;
    }

    public void setClassLeaderId(long classLeaderId) {
        this.classLeaderId = classLeaderId;
    }
}
