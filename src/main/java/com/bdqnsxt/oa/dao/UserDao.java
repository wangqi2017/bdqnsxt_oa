package com.bdqnsxt.oa.dao;

import com.bdqnsxt.oa.component.db.BaseQuery;
import com.bdqnsxt.oa.model.School;
import com.bdqnsxt.oa.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao{
    List<User> getListPage(BaseQuery bq) throws Exception;
    void save(User user) throws Exception;
    void update(User user) throws Exception;
    void delete(User user) throws Exception;
    List<User> getByUsername(String username) throws Exception;
    List<User> getByPhone(String phone) throws Exception;
    List<User> getByUsernameId(@Param("id") long id, @Param("username")String username) throws Exception;
    List<User> getByPhoneId(@Param("id") long id, @Param("mobilePhone")String mobilePhone) throws Exception;
    List<User> getUsersBySchoolAndRole(@Param("schoolId") long schoolId,@Param("roleNames") String[] roleNames) throws Exception;
    List<User> getTeacherListPage(BaseQuery bq) throws Exception;
    List<User> getBySchool(long schoolId) throws Exception;
    void updatePass(@Param("id") long id,@Param("newPassword") String newPassword) throws Exception;
    void saveUserRoles(User user) throws Exception;
    void deleteUserRoles(User user) throws Exception;
    List<User> getByRoleNames(@Param("bq") BaseQuery bq,@Param("roleNames") String[] roleNames) throws Exception;
}
