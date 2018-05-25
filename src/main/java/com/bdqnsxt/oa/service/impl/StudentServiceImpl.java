package com.bdqnsxt.oa.service.impl;

import com.bdqnsxt.oa.component.db.BaseQuery;
import com.bdqnsxt.oa.component.page.PageResult;
import com.bdqnsxt.oa.dao.StudentDao;
import com.bdqnsxt.oa.dao.UserDao;
import com.bdqnsxt.oa.exception.ServiceException;
import com.bdqnsxt.oa.exception.StudentExistException;
import com.bdqnsxt.oa.model.Student;
import com.bdqnsxt.oa.model.User;
import com.bdqnsxt.oa.service.StudentService;
import com.bdqnsxt.oa.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {


    @Autowired
    private StudentDao studentDao;
    @Autowired
    private UserUtils userUtils;
    @Autowired
    private UserDao userDao;

    @Transactional(readOnly = true)
    @Override
    public PageResult getList(BaseQuery bq) throws Exception {
        return new PageResult(studentDao.getListPage(bq),bq.getPage().getTotal_count());
    }

    @Transactional(rollbackFor = {Throwable.class})
    @Override
    public void save(Student student) throws Exception {
        List<Student> ss = studentDao.getByMobilePhone(student.getMobilePhone());
        if (ss.size() > 0) {
            throw new StudentExistException("添加失败！学员手机号： " + student.getMobilePhone() + "   已存在");
        }
        studentDao.save(student);
        if(student.getCurrentClazz()!=null&&student.getCurrentClazz().getId()>0){
            //记录调班历史
            studentDao.saveStudentClazzs(0,student.getId(),student.getCurrentClazz().getId(), userUtils.getLoggedUser().getUsername(),new Date());
        }
    }

    @Transactional(rollbackFor = {Throwable.class})
    @Override
    public void update(Student student) throws Exception {
        List<Student> ss = studentDao.getByMobilePhoneId(student.getId(),student.getMobilePhone());
        if (ss.size() > 0) {
            throw new StudentExistException("修改失败！学员手机号： " + student.getMobilePhone() + "   已存在");
        }
        studentDao.update(student);
        if(student.getCurrentClazz()!=null&&student.getCurrentClazz().getId()>0){
            //记录调班历史
            studentDao.saveStudentClazzs(0,student.getId(),student.getCurrentClazz().getId(),userUtils.getLoggedUser().getUsername(),new Date());
        }
    }

    @Transactional(rollbackFor = {Throwable.class})
    @Override
    public void delete(Student student) throws Exception {
        studentDao.delete(student);
    }
}
