package com.bdqnsxt.oa.model;

import com.bdqnsxt.oa.dto.FinanceDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Finance extends AbstractModel implements Serializable{

    private School school;
    private User proposer;
    private BigDecimal amount;
    private FinanceTypeEnum financeType;
    private String details;
    //申报时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date   applyTime;
    private String fileLocations;

    private User   financeApprovaler;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date financeApprovalTime;
    //财务审批意见
    private String financeApprovalOpin;

    private User   centerApprovaler;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date   centerAprrovalTime;
    private String centerApprovalOpin;

    private ApprovalStatus approvalStatus;

    private ProcessStatus  processStatus;


    private String approvalOpin;
    private String isPass;


    public static enum FinanceTypeEnum{
        奖金,工资,备用金,公司垫付,机房建设费,
        教学费,就业费,市场费,行政日常费,固定资产费,耗材费,
        房屋租赁费,物业管理费,班级管理费,学员管理费,其它
    }

    public static enum ApprovalStatus{
        通过,未通过
    }

    public static enum ProcessStatus{
        草稿,财务审批通过,中心审批通过,归档
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
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

    public User getFinanceApprovaler() {
        return financeApprovaler;
    }

    public void setFinanceApprovaler(User financeApprovaler) {
        this.financeApprovaler = financeApprovaler;
    }

    public Date getFinanceApprovalTime() {
        return financeApprovalTime;
    }

    public void setFinanceApprovalTime(Date financeApprovalTime) {
        this.financeApprovalTime = financeApprovalTime;
    }

    public User getCenterApprovaler() {
        return centerApprovaler;
    }

    public void setCenterApprovaler(User centerApprovaler) {
        this.centerApprovaler = centerApprovaler;
    }

    public Date getCenterAprrovalTime() {
        return centerAprrovalTime;
    }

    public void setCenterAprrovalTime(Date centerAprrovalTime) {
        this.centerAprrovalTime = centerAprrovalTime;
    }

    public String getCenterApprovalOpin() {
        return centerApprovalOpin;
    }

    public void setCenterApprovalOpin(String centerApprovalOpin) {
        this.centerApprovalOpin = centerApprovalOpin;
    }

    public ApprovalStatus getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(ApprovalStatus approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public ProcessStatus getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(ProcessStatus processStatus) {
        this.processStatus = processStatus;
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

    @Override
    public String getDisplayClassName() {
        return "财务申请审批";
    }

    @Override
    public String getDisplayName() {
        return null;
    }

     public Finance getCopy(FinanceDto dto){
         this.financeType = dto.getFinanceType();
         this.details = dto.getDetails();
         if(dto.getId() !=null && dto.getId() > 0){
             this.id = dto.getId();
         }
         //BeanUtils.copyProperties(dto,this);
         if(dto.getSchoolId() !=null && dto.getSchoolId()>0){
             School s = new School();
             s.setId(dto.getSchoolId());
             this.setSchool(s);
         }
         if(StringUtils.isNotEmpty(dto.getAmount())){
             String str = dto.getAmount().replace(",","").replace("$","");
             BigDecimal bd = new BigDecimal(str);
             this.setAmount(bd);
         }
         /*
         if(dto.getIsPass()!=null && "通过".equals(dto.getIsPass())){
             this.isPass = true;
         }else{
             this.isPass = false;
         }*/
         return this;
     }

    public  Finance getApprovalCopy(FinanceDto dto){
        this.isPass = dto.getIsPass();
        this.approvalOpin = dto.getApprovalOpin();
        if(dto.getId() !=null && dto.getId() > 0){
            this.id = dto.getId();
        }
        return this;
    }
}
