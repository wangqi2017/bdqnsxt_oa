package com.bdqnsxt.oa.service;

import com.bdqnsxt.oa.component.db.BaseQuery;
import com.bdqnsxt.oa.component.page.PageResult;
import com.bdqnsxt.oa.model.Student;

import java.util.List;


public interface StudentService {
    PageResult getList(BaseQuery bq) throws Exception;
    void save(Student student) throws Exception;
    void update(Student student) throws Exception;
    void delete(Student student) throws Exception;
    List<Student> getByClazz(long currentClazzId) throws Exception;

}
