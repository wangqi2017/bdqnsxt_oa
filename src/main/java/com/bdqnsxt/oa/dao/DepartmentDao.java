package com.bdqnsxt.oa.dao;

import com.bdqnsxt.oa.model.Department;
import com.bdqnsxt.oa.model.School;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentDao {
    List<School> getAll() throws Exception;
    List<Department> getBySchool(long schoolId) throws Exception;
    void save(Department department) throws Exception;
    void update(Department department) throws Exception;
    void delete(Department department) throws Exception;
    List<Department> getByName(String dtname) throws Exception;
}
