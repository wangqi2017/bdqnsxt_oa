package com.bdqnsxt.oa.service.impl;

import com.bdqnsxt.oa.conf.application.ExecConfig;
import com.bdqnsxt.oa.exception.ServiceException;
import com.bdqnsxt.oa.service.StudentCodeService;
import com.bdqnsxt.oa.utils.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class StudentCodeServiceImpl implements StudentCodeService{

    private Logger logger = LoggerFactory.getLogger(StudentCodeServiceImpl.class);

    @Autowired
    private ExecConfig execConfig;

    @Override
    public void countCurrentDayCode() throws Exception {
        String cmd = execConfig.getGitLog();
        String date = DateUtils.getDateSimpleFormat(new Date());
        String newCmd = StringUtils.replace(cmd,"==","=="+date,2);
        Process process = Runtime.getRuntime().exec(newCmd);
        int exitValue = 0;
        try {
            exitValue = process.waitFor();
        }catch (InterruptedException e){
            logger.error(e.getMessage(),e);
        }
        if(exitValue != 0){
            throw new ServiceException("初始化仓库失败！");
        }

    }
}
