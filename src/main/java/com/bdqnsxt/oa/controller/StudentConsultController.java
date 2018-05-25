package com.bdqnsxt.oa.controller;

import com.bdqnsxt.oa.component.db.BaseQuery;
import com.bdqnsxt.oa.component.page.PageInfo;
import com.bdqnsxt.oa.component.page.PageResult;
import com.bdqnsxt.oa.dto.ConsultDto;
import com.bdqnsxt.oa.dto.ConsultQueryDto;
import com.bdqnsxt.oa.dto.SchoolDto;
import com.bdqnsxt.oa.exception.SchoolExistException;
import com.bdqnsxt.oa.exception.ServiceException;
import com.bdqnsxt.oa.model.School;
import com.bdqnsxt.oa.model.StudentConsult;
import com.bdqnsxt.oa.model.SystemRole;
import com.bdqnsxt.oa.model.User;
import com.bdqnsxt.oa.service.StudentConsultService;
import com.bdqnsxt.oa.utils.ResponseUtils;
import com.bdqnsxt.oa.utils.UserUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class StudentConsultController {
    private Logger logger = LoggerFactory.getLogger(StudentConsultController.class);
    @Autowired
    private StudentConsultService studentConsultService;

    @Autowired
    private UserUtils userUtils;

    @RequestMapping(value = "/consults", method = RequestMethod.GET)
    public Map<String, Object> getListPage(ConsultQueryDto dto, PageInfo pageInfo) throws Exception {
        BaseQuery bq = new BaseQuery();
        User user = userUtils.getLoggedUser();
        if(dto.getPurpose()!=null){
            bq.putCondition("purpose","=",dto.getPurpose());
        }
        if(dto.getQuizTime()!=null){
            bq.putCondition("quizTime",">",dto.getQuizTime());
        }
        if(StringUtils.isNotEmpty(dto.getStuName())){
            bq.putCondition("s.stuName","like","%"+dto.getStuName() + "%");
        }
        if(StringUtils.isNotEmpty(dto.getStuStatus())){
            bq.putCondition("s.status","=",dto.getStuStatus());
        }
        if(dto.getConsulterId()!=null&&dto.getConsulterId()>0){
            bq.putCondition("sc.userId","=",dto.getConsulterId());
        }
        boolean flag = false;
        for(SystemRole role : user.getRoles()){
            if("咨询主管".equals(role.getRoleName())){
                flag = true;
                break;
            }
        }
        if(user.isAdmin()||user.isLeader()){
            flag = true;
        }
        if(!flag){
            bq.putCondition("sc.userId", "=", user.getId());
        }
        bq.setPage(pageInfo);
        bq.addOrders("sc.purpose","desc");
        bq.addOrders("sc.lastLockTime","desc");
        PageResult rs = studentConsultService.getList(bq);
        return ResponseUtils.extJSProxyResponse(rs.getResult(), rs.getTotal());
    }

    @RequestMapping(value = "/consults/{id}", method = RequestMethod.PUT)
    public Map<String, Object> update(@RequestBody ConsultDto dto) throws Exception {
        studentConsultService.update(new StudentConsult().getStudentConsultCopy(dto));
        return ResponseUtils.successExtJSProxyResponse("跟踪记录成功");
    }

    @RequestMapping(value = "/consults/{id}", method = RequestMethod.DELETE)
    public Map<String, Object> delete(@RequestBody ConsultDto dto) throws Exception {
        studentConsultService.delete(new StudentConsult().getStudentConsultCopy(dto));
        return ResponseUtils.successExtJSProxyResponse("解锁成功");
    }

    @RequestMapping(value = "/consult/{stuId}", method = RequestMethod.POST)
    public Map<String, Object> lock(@PathVariable("stuId") long stuId) throws Exception {
        try {
            studentConsultService.prepareAndSave(stuId);
            return ResponseUtils.successExtJSProxyResponse("学员锁定成功，请到咨询业务界面处理");
        }catch (ServiceException e){
            return ResponseUtils.failureExtJSProxyResponse(e.getMessage());
        }
  }
}
