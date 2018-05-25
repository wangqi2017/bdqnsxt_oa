package com.bdqnsxt.oa.service;

import com.bdqnsxt.oa.component.db.BaseQuery;
import com.bdqnsxt.oa.component.page.PageResult;
import com.bdqnsxt.oa.model.User;

import java.util.List;


public interface UserService {
    PageResult getList(BaseQuery bq) throws Exception;
    PageResult getTeacherList(BaseQuery bq) throws Exception;
    void save(User user) throws Exception;
    void update(User user) throws Exception;
    void delete(User user) throws Exception;
    List<User> getUsersBySchoolAndRole(long schoolId,String[] roleNames) throws Exception;
    User login(User user) throws Exception;
    void userPass(String oldPassword,String newPassword) throws Exception;
    List<User> getByRoleNames(BaseQuery bq,String[] roleNames) throws Exception;
}
