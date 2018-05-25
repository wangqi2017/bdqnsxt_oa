package com.bdqnsxt.oa.service;

import com.bdqnsxt.oa.model.Department;
import com.bdqnsxt.oa.model.School;

import java.util.List;


public interface DepartmentService {
    List<School> getAll() throws Exception;
    List<Department> getBySchool(long schoolId) throws Exception;
    void save(Department department) throws Exception;
    void update(Department department) throws Exception;
    void delete(Department department) throws Exception;
}
