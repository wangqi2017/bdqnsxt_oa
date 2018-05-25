package com.bdqnsxt.oa.controller;

import com.bdqnsxt.oa.component.db.BaseQuery;
import com.bdqnsxt.oa.component.page.PageInfo;
import com.bdqnsxt.oa.component.page.PageResult;
import com.bdqnsxt.oa.dto.TeacherQueryDto;
import com.bdqnsxt.oa.dto.UserDto;
import com.bdqnsxt.oa.dto.UserQueryDto;
import com.bdqnsxt.oa.exception.UserExistException;
import com.bdqnsxt.oa.model.User;
import com.bdqnsxt.oa.service.UserService;
import com.bdqnsxt.oa.utils.ResponseUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value="/getUsersBySchoolAndRole",method = RequestMethod.GET)
    public Map<String, Object> getUsersBySchoolAndRole(long schoolId,String[] roleNames) throws Exception{
        List<User> users =userService.getUsersBySchoolAndRole(schoolId,roleNames);
        return ResponseUtils.successExtJSProxyResponse(users,"");
    }

    @RequestMapping(value="/getConsulters",method = RequestMethod.GET)
    public Map<String, Object> getUsersByRoles() throws Exception{
        BaseQuery bq = new BaseQuery();
        String[] roleNames = new String[]{"咨询主管","在线咨询师","咨询师","咨询助理"};
        List<User> users =userService.getByRoleNames(bq,roleNames);
        return ResponseUtils.successExtJSProxyResponse(users,"");
    }

    @RequestMapping(value="/users",method = RequestMethod.GET)
    public Map<String, Object> getListPage(UserQueryDto uq, PageInfo pageInfo) throws Exception{
        BaseQuery bq = new BaseQuery();
        if(!StringUtils.isEmpty(uq.getUsername())){
            bq.putCondition("username","like","%"+uq.getUsername()+"%");
        }
        if(!StringUtils.isEmpty(uq.getMobilePhone())){
            bq.putCondition("mobilePhone","like","%"+uq.getMobilePhone()+"%");
        }
        if(!StringUtils.isEmpty(uq.getHireDateStart())){
            bq.putCondition("hireDate",">",uq.getHireDateStart());
        }
        if(!StringUtils.isEmpty(uq.getHireDateEnd())){
            bq.putCondition("hireDate","<",uq.getHireDateEnd());
        }
        if(uq.getRoleId()!=null&&uq.getRoleId()>0){
            bq.putCondition("roleId","=",uq.getRoleId());
        }
        if(uq.getSchoolId()!=null&&uq.getSchoolId()>0){
            bq.putCondition("schoolId","=",uq.getSchoolId());
        }
        bq.setPage(pageInfo);
        PageResult rs  = userService.getList(bq);
        return  ResponseUtils.extJSProxyResponse(rs.getResult(),rs.getTotal());
    }

    @RequestMapping(value="/teachers",method = RequestMethod.GET)
    public Map<String, Object> getTeacherListPage(TeacherQueryDto tq, PageInfo pageInfo) throws Exception{
        BaseQuery bq = new BaseQuery();
        bq.putCondition("1","=","1");
        if(!StringUtils.isEmpty(tq.getUsername())){
            bq.putCondition("username","like","%"+tq.getUsername()+"%");
        }
        if(tq.getSchoolId()!=null&&tq.getSchoolId()>0){
            bq.putCondition("schoolId","=",tq.getSchoolId());
        }
        bq.setPage(pageInfo);
        PageResult rs  = userService.getTeacherList(bq);
        return  ResponseUtils.extJSProxyResponse(rs.getResult(),rs.getTotal());
    }

    @RequestMapping(value="/users",method = RequestMethod.POST)
    public Map<String, Object> save(@RequestBody UserDto dto) throws Exception{
        try {
            userService.save(new User().getUserCopy(dto));
            return ResponseUtils.successExtJSProxyResponse("用户保存成功");
        }catch (UserExistException e){
            return ResponseUtils.failureExtJSProxyResponse(e.getMessage());
        }
    }

    @RequestMapping(value="/users/{id}",method = RequestMethod.PUT)
    public Map<String, Object> update(@RequestBody UserDto dto) throws Exception{
        try {
            userService.update(new User().getUserCopy(dto));
            return ResponseUtils.successExtJSProxyResponse("用户修改成功");
        }catch (UserExistException e){
            return ResponseUtils.failureExtJSProxyResponse(e.getMessage());
        }
    }

    @RequestMapping(value="/users/{id}",method = RequestMethod.DELETE)
    public Map<String, Object> delete(@RequestBody UserDto dto) throws Exception{

            userService.delete(new User().getUserCopy(dto));
            return ResponseUtils.successExtJSProxyResponse("用户删除成功");

    }
}
