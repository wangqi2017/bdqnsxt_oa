package com.bdqnsxt.oa.service.impl;

import com.bdqnsxt.oa.dao.DepartmentDao;
import com.bdqnsxt.oa.exception.ClazzExistException;
import com.bdqnsxt.oa.exception.DepartmentExistException;
import com.bdqnsxt.oa.model.Department;
import com.bdqnsxt.oa.model.School;
import com.bdqnsxt.oa.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;

    @Transactional(readOnly = true)
    @Override
    public List<School> getAll() throws Exception {
        return departmentDao.getAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Department> getBySchool(long schoolId) throws Exception {
        return departmentDao.getBySchool(schoolId);
    }

    @Transactional()
    @Override
    public void save(Department department) throws Exception {
        /*
        //暂时允许部门重名
        List<Department> des = departmentDao.getByName(department.getDtname());
        if(des.size()>0){
            throw new DepartmentExistException("添加失败！部门名称： " + department.getDtname() + "   已存在");
        }
        */
        departmentDao.save(department);
    }

    @Transactional()
    @Override
    public void update(Department department) throws Exception {
        departmentDao.update(department);
    }

    @Transactional()
    @Override
    public void delete(Department department) throws Exception {
        departmentDao.delete(department);
    }
}
