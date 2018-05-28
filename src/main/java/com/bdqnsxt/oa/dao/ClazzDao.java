package com.bdqnsxt.oa.dao;

import com.bdqnsxt.oa.component.db.BaseQuery;
import com.bdqnsxt.oa.model.Clazz;
import com.bdqnsxt.oa.model.Department;
import com.bdqnsxt.oa.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClazzDao {
    List<Clazz> getAll() throws Exception;
    List<Clazz> getListPage(BaseQuery bq) throws Exception;
    void save(Clazz clazz) throws Exception;
    void update(Clazz clazz) throws Exception;
    void delete(Clazz clazz) throws Exception;
    List<Clazz> getByClname(String clname) throws Exception;
    List<Clazz> getByClnameId(@Param("id") long id, @Param("clname") String clname) throws Exception;
    void saveClazzTutors(@Param("clazzId") long clazzId,@Param("tutors") List<User> tutors) throws Exception;
    void deleteClazzTutors(@Param("clazzId") long clazzId) throws Exception;
    List<Clazz> getBySchool(long schoolId) throws Exception;
}
