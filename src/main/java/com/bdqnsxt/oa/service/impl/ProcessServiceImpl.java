package com.bdqnsxt.oa.service.impl;

import com.bdqnsxt.oa.model.Process;
import com.bdqnsxt.oa.service.ProcessService;
import org.springframework.stereotype.Service;

@Service
public class ProcessServiceImpl implements ProcessService{

    //@Autowired
    //private RuntimeService runtimeService;
    //@Autowired
    //private TaskService taskService;

    @Override
    public void startProcess(Process process) throws Exception {
        //ExecutionEntity executionEntity = (ExecutionEntity)runtimeService
        //        .startProcessInstanceByKey(process.getProcessDefinitionKey());
        //process.setProcessInstanceId(executionEntity.getId());
    }
}
