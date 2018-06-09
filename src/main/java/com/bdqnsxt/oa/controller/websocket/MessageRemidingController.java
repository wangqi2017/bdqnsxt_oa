package com.bdqnsxt.oa.controller.websocket;

import com.bdqnsxt.oa.dao.StudentConsultDao;
import com.bdqnsxt.oa.model.StudentConsult;
import com.bdqnsxt.oa.model.User;
import com.bdqnsxt.oa.service.StudentConsultService;
import com.bdqnsxt.oa.utils.DateUtils;
import com.bdqnsxt.oa.utils.ResponseUtils;
import com.bdqnsxt.oa.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

@Controller
public class MessageRemidingController {

    @Autowired
    private StudentConsultDao studentConsultDao;

    @Autowired
    private SimpMessagingTemplate template;


    //@Scheduled(fixedRate = 5000)
    //每天早上9点，下午2点6点
    @Scheduled(cron= "0 0 9,14,18 * * ?")
    public void getStudentConsultRemiding() throws Exception{
        List<StudentConsult> studentConsults = studentConsultDao.getRemindList(DateUtils.getTodayStartTime(),
                DateUtils.getTodayEndTime());
        Map<String,Object> result = ResponseUtils.extJSProxyResponse(studentConsults,(long)studentConsults.size());
        template.convertAndSend("/queue/getConsult", result);
    }


}
