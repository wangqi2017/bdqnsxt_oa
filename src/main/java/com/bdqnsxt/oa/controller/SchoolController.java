package com.bdqnsxt.oa.controller;

import com.bdqnsxt.oa.component.db.BaseQuery;
import com.bdqnsxt.oa.component.page.PageInfo;
import com.bdqnsxt.oa.component.page.PageResult;
import com.bdqnsxt.oa.dto.SchoolDto;
import com.bdqnsxt.oa.dto.SchoolQueryDto;
import com.bdqnsxt.oa.exception.SchoolExistException;
import com.bdqnsxt.oa.exception.ServiceException;
import com.bdqnsxt.oa.model.School;
import com.bdqnsxt.oa.service.SchoolService;
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
public class SchoolController {

    private Logger logger = LoggerFactory.getLogger(SchoolController.class);

    @Autowired
    private SchoolService schoolService;

    @RequestMapping(value = "/allschools", method = RequestMethod.GET)
    public Map<String, Object> getAll() throws Exception {
        List<School> schools = schoolService.getAll();
        return ResponseUtils.successExtJSProxyResponse(schools,"");
    }

    @RequestMapping(value = "/schools", method = RequestMethod.GET)
    public Map<String, Object> getListPage(SchoolQueryDto sq, PageInfo pageInfo) throws Exception {
        BaseQuery bq = new BaseQuery();
        if (!StringUtils.isEmpty(sq.getScname())) {
            bq.putCondition("scname", "like", "%" + sq.getScname() + "%");
        }
        if (!StringUtils.isEmpty(sq.getOrganization())) {
            bq.putCondition("organization", "=", sq.getOrganization());
        }
        if (!StringUtils.isEmpty(sq.getProvince())) {
            bq.putCondition("province", "=",  sq.getProvince());
        }
        bq.setPage(pageInfo);
        PageResult rs = schoolService.getList(bq);
        return ResponseUtils.extJSProxyResponse(rs.getResult(), rs.getTotal());
    }

    @RequestMapping(value = "/schools", method = RequestMethod.POST)
    public Map<String, Object> save(@RequestBody SchoolDto dto) throws Exception {
        try {
            schoolService.save(new School().getSchoolCopy(dto));
            return ResponseUtils.successExtJSProxyResponse("校区保存成功");
        } catch (SchoolExistException e) {
            return ResponseUtils.failureExtJSProxyResponse(e.getMessage());
        }
    }

    @RequestMapping(value = "/schools/{id}", method = RequestMethod.PUT)
    public Map<String, Object> update(@RequestBody SchoolDto dto) throws Exception {
        try {
            schoolService.update(new School().getSchoolCopy(dto));
            return ResponseUtils.successExtJSProxyResponse("用户修改成功");
        } catch (SchoolExistException e) {
            return ResponseUtils.failureExtJSProxyResponse(e.getMessage());
        }
    }

    @RequestMapping(value = "/schools/{id}", method = RequestMethod.DELETE)
    public Map<String, Object> delete(@RequestBody SchoolDto dto) throws Exception {
        try {
            schoolService.delete(new School().getSchoolCopy(dto));
            return ResponseUtils.successExtJSProxyResponse("用户删除成功");
        }catch (ServiceException e){
            return ResponseUtils.failureExtJSProxyResponse(e.getMessage());
        }
    }
}
