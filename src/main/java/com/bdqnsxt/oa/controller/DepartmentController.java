package com.bdqnsxt.oa.controller;

import com.bdqnsxt.oa.component.db.BaseQuery;
import com.bdqnsxt.oa.component.page.PageInfo;
import com.bdqnsxt.oa.component.page.PageResult;
import com.bdqnsxt.oa.dto.ClazzDto;
import com.bdqnsxt.oa.dto.DepartmentDto;
import com.bdqnsxt.oa.dto.SchoolQueryDto;
import com.bdqnsxt.oa.exception.ClazzExistException;
import com.bdqnsxt.oa.exception.DepartmentExistException;
import com.bdqnsxt.oa.exception.SchoolExistException;
import com.bdqnsxt.oa.model.Clazz;
import com.bdqnsxt.oa.model.Department;
import com.bdqnsxt.oa.model.School;
import com.bdqnsxt.oa.service.DepartmentService;
import com.bdqnsxt.oa.service.SchoolService;
import com.bdqnsxt.oa.utils.ResponseUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class DepartmentController {

    private Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/departmentsBySchool", method = RequestMethod.GET)
    public Map<String, Object> getDepartmentBySchool(long schoolId) throws Exception {
        List<Department> depts = departmentService.getBySchool(schoolId);
        return ResponseUtils.successExtJSProxyResponse(depts,"");
    }

    @RequestMapping(value = "/departments", method = RequestMethod.GET)
    public Map<String, Object> getSchoolList() throws Exception {
        List<School> schools = departmentService.getAll();
        return ResponseUtils.successExtJSTreeProxyResponse(schools,"departments");
    }

    @RequestMapping(value = "/departments", method = RequestMethod.POST, consumes="application/json;charset=utf-8")
    public Map<String, Object> save(@RequestBody DepartmentDto dto) throws Exception {
        try {
            departmentService.save(new Department().getDepartmentCopy(dto));
            return ResponseUtils.successExtJSProxyResponse("部门保存成功");
        } catch (DepartmentExistException e) {
            return ResponseUtils.failureExtJSProxyResponse(e.getMessage());
        }
    }

    @RequestMapping(value = "/departments/{id}", method = RequestMethod.PUT, consumes="application/json;charset=utf-8")
    public Map<String, Object> update(@RequestBody DepartmentDto dto) throws Exception {
        try {
            departmentService.update(new Department().getDepartmentCopy(dto));
            return ResponseUtils.successExtJSProxyResponse("部门修改成功");
        } catch (DepartmentExistException e) {
            return ResponseUtils.failureExtJSProxyResponse(e.getMessage());
        }
    }

    @RequestMapping(value = "/departments/{id}", method = RequestMethod.DELETE)
    public Map<String, Object> delete(@RequestBody DepartmentDto dto) throws Exception {
        departmentService.delete(new Department().getDepartmentCopy(dto));
        return ResponseUtils.successExtJSProxyResponse("部门删除成功");

    }
}
