package com.bdqnsxt.oa.model;

import java.util.*;

public class CommitCode {
    private long id;
    private Student student;
    private Date commitTime;
    private int  addTotal;
    private int  subTotal;
    private int  changeTotal;
    private String commitName;
    private String commitMesg;
    private RepoType repoType;

    public static enum RepoType{
        PROJECT, PRACTICE
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Date getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(Date commitTime) {
        this.commitTime = commitTime;
    }

    public int getAddTotal() {
        return addTotal;
    }

    public void setAddTotal(int addTotal) {
        this.addTotal = addTotal;
    }

    public int getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(int subTotal) {
        this.subTotal = subTotal;
    }

    public int getChangeTotal() {
        return changeTotal;
    }

    public void setChangeTotal(int changeTotal) {
        this.changeTotal = changeTotal;
    }

    public String getCommitName() {
        return commitName;
    }

    public void setCommitName(String commitName) {
        this.commitName = commitName;
    }

    public String getCommitMesg() {
        return commitMesg;
    }

    public void setCommitMesg(String commitMesg) {
        this.commitMesg = commitMesg;
    }

    public RepoType getRepoType() {
        return repoType;
    }

    public void setRepoType(RepoType repoType) {
        this.repoType = repoType;
    }

    public CommitCode(long id, Student student, Date commitTime, int addTotal, int subTotal, int changeTotal, String commitName, String commitMesg, RepoType repoType) {
        this.id = id;
        this.student = student;
        this.commitTime = commitTime;
        this.addTotal = addTotal;
        this.subTotal = subTotal;
        this.changeTotal = changeTotal;
        this.commitName = commitName;
        this.commitMesg = commitMesg;
        this.repoType = repoType;
    }

    public CommitCode() {
    }
}
