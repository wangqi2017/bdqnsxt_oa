package com.bdqnsxt.oa.controller;

import com.bdqnsxt.oa.model.Process;
import com.bdqnsxt.oa.service.ProcessService;
import com.bdqnsxt.oa.utils.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class FinanceController {

    private Logger logger = LoggerFactory.getLogger(FinanceController.class);

    @Autowired
    private ProcessService processService;

    @RequestMapping(value="/finance/startService",method = RequestMethod.GET)
    public Map<String, Object> getListPage() throws Exception{
        Process p = new Process();
        p.setProcessDefinitionKey(ProcessService.FINANCE_APPROVAL_PROCESS_KEY);
        processService.startProcess(p);
        return  ResponseUtils.successExtJSProxyResponse("start success!");
    }

}
