package com.bdqnsxt.oa.dto;

public class FinanceQueryDto {

    private Long schoolId;
    private String proposerName;
    private Long financeApprovalerId;
    private String processStatus;


    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    public String getProposerName() {
        return proposerName;
    }

    public void setProposerName(String proposerName) {
        this.proposerName = proposerName;
    }

    public Long getFinanceApprovalerId() {
        return financeApprovalerId;
    }

    public void setFinanceApprovalerId(Long financeApprovalerId) {
        this.financeApprovalerId = financeApprovalerId;
    }

    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus;
    }
}
