package com.bdqnsxt.oa.dto;

import com.bdqnsxt.oa.model.AbstractModel;
import com.bdqnsxt.oa.model.Finance;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

public class FinanceDto{
    //private Finance.ApprovalStatus approvalStatus;
    //private Finance.ProcessStatus  processStatus;
    private Long id;
    private Long  schoolId;
    private String amount;
    private Finance.FinanceTypeEnum financeType;
    private String details;
    private String financeApprovalOpin;
    private String centerApprovalOpin;
    private MultipartFile[] files;
    private String approvalOpin;
    private String isPass;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
/*
    public Finance.ApprovalStatus getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(Finance.ApprovalStatus approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public Finance.ProcessStatus getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(Finance.ProcessStatus processStatus) {
        this.processStatus = processStatus;
    }
    */

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Finance.FinanceTypeEnum getFinanceType() {
        return financeType;
    }

    public void setFinanceType(Finance.FinanceTypeEnum financeType) {
        this.financeType = financeType;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getFinanceApprovalOpin() {
        return financeApprovalOpin;
    }

    public void setFinanceApprovalOpin(String financeApprovalOpin) {
        this.financeApprovalOpin = financeApprovalOpin;
    }

    public String getCenterApprovalOpin() {
        return centerApprovalOpin;
    }

    public void setCenterApprovalOpin(String centerApprovalOpin) {
        this.centerApprovalOpin = centerApprovalOpin;
    }

    public MultipartFile[] getFiles() {
        return files;
    }

    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }

    public String getApprovalOpin() {
        return approvalOpin;
    }

    public void setApprovalOpin(String approvalOpin) {
        this.approvalOpin = approvalOpin;
    }

    public String getIsPass() {
        return isPass;
    }

    public void setIsPass(String isPass) {
        this.isPass = isPass;
    }

}
