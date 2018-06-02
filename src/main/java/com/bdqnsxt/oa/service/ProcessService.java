package com.bdqnsxt.oa.service;


import com.bdqnsxt.oa.model.Process;

public interface ProcessService {
    public static final String FINANCE_APPROVAL_PROCESS_KEY = "financeApprovalProcess";
    void startProcess(Process process) throws Exception;
}
