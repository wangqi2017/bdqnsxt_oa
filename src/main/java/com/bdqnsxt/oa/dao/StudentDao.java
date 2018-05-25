package com.bdqnsxt.oa.dao;

import com.bdqnsxt.oa.component.db.BaseQuery;
import com.bdqnsxt.oa.model.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface StudentDao {
    List<Student> getListPage(BaseQuery bq) throws Exception;
    List<Student> getByClazz(long currentClazzId) throws Exception;
    void save(Student student) throws Exception;
    void update(Student student) throws Exception;
    void delete(Student student) throws Exception;
    List<Student> getByMobilePhone(String mobilePhone) throws Exception;
    List<Student> getByMobilePhoneId(@Param("id") long id, @Param("mobilePhone") String mobilePhone) throws Exception;
    void saveStudentClazzs(@Param("id") long id,@Param("stuId") long stuId, @Param("clazzId") long clazzId,@Param("createBy") String createBy,@Param("createOn") Date createOn) throws Exception;
    Student getById(long id) throws Exception;
}
