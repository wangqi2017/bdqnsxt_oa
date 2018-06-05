package com.bdqnsxt.oa.controller;

import com.bdqnsxt.oa.component.db.BaseQuery;
import com.bdqnsxt.oa.component.page.PageInfo;
import com.bdqnsxt.oa.component.page.PageResult;
import com.bdqnsxt.oa.dto.StudentDto;
import com.bdqnsxt.oa.dto.StudentQueryDto;
import com.bdqnsxt.oa.exception.ServiceException;
import com.bdqnsxt.oa.exception.StudentExistException;
import com.bdqnsxt.oa.model.Student;
import com.bdqnsxt.oa.service.StudentService;
import com.bdqnsxt.oa.utils.ResponseUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class StudentController {

    private Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/testCode", method = RequestMethod.GET)
    public String testCode() throws Exception{
        studentService.countCode();
        return "test";
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public Map<String, Object> getListPage(StudentQueryDto dto, PageInfo pageInfo) throws Exception {
        BaseQuery bq = new BaseQuery();
        if (!StringUtils.isEmpty(dto.getStuName())) {
            bq.putCondition("stuName", "like", "%" + dto.getStuName() + "%");
        }
        if (!StringUtils.isEmpty(dto.getMobilePhone())) {
            bq.putCondition("mobilePhone", "like", "%" +dto.getMobilePhone()+ "%");
        }
        if (!StringUtils.isEmpty(dto.getStatus())) {
            bq.putCondition("status", "=", dto.getStatus());
        }
        if(dto.getLockId()!=null){
            if(dto.getLockId()>0){
                bq.putCondition("ct.userId", "=", dto.getLockId());
            }else{
                bq.putCondition("ct.userId", "is", null);
            }
        }
        bq.setPage(pageInfo);
        PageResult rs = studentService.getList(bq);
        return ResponseUtils.extJSProxyResponse(rs.getResult(), rs.getTotal());
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST, consumes="application/json;charset=utf-8")
    public Map<String, Object> save(@RequestBody StudentDto dto) throws Exception {
        try {
            studentService.save(new Student().getStudentCopy(dto));
            return ResponseUtils.successExtJSProxyResponse("学员保存成功");
        } catch (StudentExistException e) {
            return ResponseUtils.failureExtJSProxyResponse(e.getMessage());
        } catch(ServiceException e){
            return ResponseUtils.failureExtJSProxyResponse(e.getMessage());
        }
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.PUT, consumes="application/json;charset=utf-8")
    public Map<String, Object> update(@RequestBody StudentDto dto) throws Exception {
        try {
            studentService.update(new Student().getStudentCopy(dto));
            return ResponseUtils.successExtJSProxyResponse("学员修改成功");
        } catch (StudentExistException e) {
            return ResponseUtils.failureExtJSProxyResponse(e.getMessage());
        } catch(ServiceException e){
            return ResponseUtils.failureExtJSProxyResponse(e.getMessage());
        }
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
    public Map<String, Object> delete(@RequestBody StudentDto dto) throws Exception {
        studentService.delete(new Student().getStudentCopy(dto));
        return ResponseUtils.successExtJSProxyResponse("学员删除成功");

    }
}
