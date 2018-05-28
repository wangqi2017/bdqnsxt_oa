package com.bdqnsxt.oa.model;

import com.bdqnsxt.oa.dto.ClazzDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Clazz extends AbstractModel{

    private String clname;
    private OrientationEnum orientation;
    //所属校区
    private School belongSchool;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date   startDate;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date   endDate;
    private StatusEnum status;
    //当前讲师
    private User   lecturer;
    //当前助教
    private List<User> tutors;
    //班主任
    private User   classLeader;
    private List<Student> students;

    public enum OrientationEnum{
        JAVA工程师,UI设计,大数据工程师
    }

    public enum StatusEnum{
        未开班,试听,开班,结束
    }

    public String getClname() {
        return clname;
    }

    public void setClname(String clname) {
        this.clname = clname;
    }

    public OrientationEnum getOrientation() {
        return orientation;
    }

    public void setOrientation(OrientationEnum orientation) {
        this.orientation = orientation;
    }

    public School getBelongSchool() {
        return belongSchool;
    }

    public void setBelongSchool(School belongSchool) {
        this.belongSchool = belongSchool;
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

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public User getLecturer() {
        return lecturer;
    }

    public void setLecturer(User lecturer) {
        this.lecturer = lecturer;
    }

    public List<User> getTutors() {
        return tutors;
    }

    public void setTutors(List<User> tutors) {
        this.tutors = tutors;
    }

    @Override
    public String getDisplayClassName() {
        return "班级";
    }

    @Override
    public String getDisplayName() {
        return getClname();
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public User getClassLeader() {
        return classLeader;
    }

    public void setClassLeader(User classLeader) {
        this.classLeader = classLeader;
    }

    public Clazz(){}

    public Clazz getClassCopy(ClazzDto dto){
        BeanUtils.copyProperties(dto,this);
        if(dto.getSchoolId()>0){
            School s = new School();
            s.setId(dto.getSchoolId());
            this.belongSchool = s;
        }
        if(dto.getLecturerId()>0){
            User u = new User();
            u.setId(dto.getLecturerId());
            this.lecturer = u;
        }
        if(dto.getClassLeaderId()>0){
            User u = new User();
            u.setId(dto.getClassLeaderId());
            this.classLeader = u;
        }
        if(dto.getTutorIds()!=null&&dto.getTutorIds().length>0){
                tutors = new ArrayList<>();
                for(String id:dto.getTutorIds()){
                    User tutor = new User();
                    tutor.setId(Long.valueOf(id));
                    tutors.add(tutor);
                }
        }
        return this;
    }
}
