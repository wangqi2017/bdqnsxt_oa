package com.bdqnsxt.oa.controller;

import com.bdqnsxt.oa.component.db.BaseQuery;
import com.bdqnsxt.oa.component.page.PageInfo;
import com.bdqnsxt.oa.component.page.PageResult;
import com.bdqnsxt.oa.dto.ClazzDto;
import com.bdqnsxt.oa.dto.ClazzQueryDto;
import com.bdqnsxt.oa.exception.ClazzExistException;
import com.bdqnsxt.oa.exception.ClazzSubStudentExistException;
import com.bdqnsxt.oa.model.Clazz;
import com.bdqnsxt.oa.model.School;
import com.bdqnsxt.oa.service.ClazzService;
import com.bdqnsxt.oa.utils.ResponseUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ClazzController {

    private Logger logger = LoggerFactory.getLogger(ClazzController.class);

    @Autowired
    private ClazzService clazzService;

    @RequestMapping(value = "/allclazzs", method = RequestMethod.GET)
    public Map<String, Object> getAll() throws Exception {
        List<Clazz> clazzs = clazzService.getAll();
        return ResponseUtils.successExtJSProxyResponse(clazzs,"");
    }

    @RequestMapping(value = "/clazzss", method = RequestMethod.GET)
    public Map<String, Object> getListPage(ClazzQueryDto dto, PageInfo pageInfo) throws Exception {
        BaseQuery bq = new BaseQuery();
        if (!StringUtils.isEmpty(dto.getClname())) {
            bq.putCondition("clname", "like", "%" + dto.getClname() + "%");
        }
        if (!StringUtils.isEmpty(dto.getOrganization())) {
            bq.putCondition("organization", "=", dto.getOrganization());
        }
        if (dto.getSchoolId()!=null && dto.getSchoolId() > 0) {
            bq.putCondition("schoolId", "=",  dto.getSchoolId());
        }
        if (!StringUtils.isEmpty(dto.getStatus())){
            bq.putCondition("status", "=",  dto.getStatus());
        }
        bq.setPage(pageInfo);
        PageResult rs = clazzService.getList(bq);
        return ResponseUtils.extJSProxyResponse(rs.getResult(), rs.getTotal());
    }

    @RequestMapping(value = "/clazzss", method = RequestMethod.POST, consumes="application/json;charset=utf-8")
    public Map<String, Object> save(@RequestBody ClazzDto dto) throws Exception {
        try {
            clazzService.save(new Clazz().getClassCopy(dto));
            return ResponseUtils.successExtJSProxyResponse("班级保存成功");
        } catch (ClazzExistException e) {
            return ResponseUtils.failureExtJSProxyResponse(e.getMessage());
        }
    }

    @RequestMapping(value = "/clazzss/{id}", method = RequestMethod.PUT, consumes="application/json;charset=utf-8")
    public Map<String, Object> update(@RequestBody ClazzDto dto) throws Exception {
        try {
            clazzService.update(new Clazz().getClassCopy(dto));
            return ResponseUtils.successExtJSProxyResponse("班级修改成功");
        } catch (ClazzExistException e) {
            return ResponseUtils.failureExtJSProxyResponse(e.getMessage());
        }
    }

    @RequestMapping(value = "/clazzss/{id}", method = RequestMethod.DELETE)
    public Map<String, Object> delete(@RequestBody ClazzDto dto) throws Exception {
        try {
            clazzService.delete(new Clazz().getClassCopy(dto));
            return ResponseUtils.successExtJSProxyResponse("班级删除成功");
        }catch (ClazzSubStudentExistException e) {
            return ResponseUtils.failureExtJSProxyResponse(e.getMessage());
        }

    }
}
