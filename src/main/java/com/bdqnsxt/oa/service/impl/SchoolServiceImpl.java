package com.bdqnsxt.oa.service.impl;

import com.bdqnsxt.oa.component.db.BaseQuery;
import com.bdqnsxt.oa.component.page.PageResult;
import com.bdqnsxt.oa.dao.ClazzDao;
import com.bdqnsxt.oa.dao.DepartmentDao;
import com.bdqnsxt.oa.dao.SchoolDao;
import com.bdqnsxt.oa.dao.UserDao;
import com.bdqnsxt.oa.exception.*;
import com.bdqnsxt.oa.model.Clazz;
import com.bdqnsxt.oa.model.Department;
import com.bdqnsxt.oa.model.School;
import com.bdqnsxt.oa.model.User;
import com.bdqnsxt.oa.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {


    @Autowired
    private SchoolDao schoolDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private ClazzDao clazzDao;

    @Transactional(readOnly = true)
    @Override
    public List<School> getAll() throws Exception {
        return schoolDao.getAll();
    }

    @Transactional(readOnly = true)
    @Override
    public PageResult getList(BaseQuery bq) throws Exception {
        return new PageResult(schoolDao.getListPage(bq),bq.getPage().getTotal_count());
    }

    @Transactional(rollbackFor = {Throwable.class})
    @Override
    public void save(School school) throws Exception {
        List<School> ss = schoolDao.getByScname(school.getScname());
        if (ss.size() > 0) {
            throw new SchoolExistException("添加失败！校区名称： " + school.getScname() + "   已存在");
        }
        schoolDao.save(school);
    }

    @Transactional(rollbackFor = {Throwable.class})
    @Override
    public void update(School school) throws Exception {
        List<School> ss = schoolDao.getByScnameId(school.getId(),school.getScname());
        if (ss.size() > 0) {
            throw new SchoolExistException("修改失败！校区名称： " + school.getScname() + "   已存在");
        }

        schoolDao.update(school);
    }

    @Transactional(rollbackFor = {Throwable.class})
    @Override
    public void delete(School school) throws Exception {
        List<User> users = userDao.getBySchool(school.getId());
        if(users.size()>0){
            throw new SchoolSubUserExistException("该校区下还有用户，无法删除");
        }
        List<Department> deps = departmentDao.getBySchool(school.getId());
        if(deps.size()>0){
            throw new SchoolSubDepartmentExistException("该校区下还有部门，无法删除");
        }
        List<Clazz> cls = clazzDao.getBySchool(school.getId());
        if(cls.size()>0){
            throw new SchoolSubClazzExistException("该校区下还有班级，无法删除");
        }
        if(school.getId()==1){
            throw new ServiceException("无法删除总校区");
        }
        schoolDao.delete(school);
    }
}
