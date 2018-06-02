package com.bdqnsxt.oa.model;

import java.io.Serializable;
import java.util.Date;

public class Finance extends AbstractModel implements Serializable{

    private School school;
    private User proposer;
    private double amount;
    private FinanceTypeEnum financeType;
    private String details;
    //申报时间
    private Date   applyTime;
    private String fileLocations;
    //财务审批意见
    private String financeApprovalOpin;

    private Process process;

    public static enum FinanceTypeEnum{
        奖金,工资,备用金,公司垫付,机房建设费,
        教学费,就业费,市场费,行政日常费,固定资产费,耗材费,
        房屋租赁费,物业管理费,班级管理费,学员管理费,其它
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public User getProposer() {
        return proposer;
    }

    public void setProposer(User proposer) {
        this.proposer = proposer;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public FinanceTypeEnum getFinanceType() {
        return financeType;
    }

    public void setFinanceType(FinanceTypeEnum financeType) {
        this.financeType = financeType;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public String getFileLocations() {
        return fileLocations;
    }

    public void setFileLocations(String fileLocations) {
        this.fileLocations = fileLocations;
    }

    public String getFinanceApprovalOpin() {
        return financeApprovalOpin;
    }

    public void setFinanceApprovalOpin(String financeApprovalOpin) {
        this.financeApprovalOpin = financeApprovalOpin;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    @Override
    public String getDisplayClassName() {
        return "财务申请";
    }

    @Override
    public String getDisplayName() {
        return null;
    }
}
