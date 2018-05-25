package com.bdqnsxt.oa.service.impl;

import com.bdqnsxt.oa.component.db.BaseQuery;
import com.bdqnsxt.oa.component.page.PageResult;
import com.bdqnsxt.oa.dao.StudentConsultDao;
import com.bdqnsxt.oa.dao.StudentDao;
import com.bdqnsxt.oa.exception.ServiceException;
import com.bdqnsxt.oa.model.Student;
import com.bdqnsxt.oa.model.StudentConsult;
import com.bdqnsxt.oa.model.User;
import com.bdqnsxt.oa.service.StudentConsultService;
import com.bdqnsxt.oa.utils.DateUtils;
import com.bdqnsxt.oa.utils.UserUtils;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class StudentConsultServiceImpl implements StudentConsultService{

    @Autowired
    private UserUtils userUtils;

    @Autowired
    private StudentConsultDao studentConsultDao;

    @Autowired
    private StudentDao studentDao;

    @Transactional()
    @Override
    public void save(StudentConsult studentConsult) throws Exception {
        if(studentConsult.getStudent() == null){
            throw new ServiceException("您锁定的学员不存在！");
        }
        synchronized (this){
            List<StudentConsult> studentConsults = studentConsultDao.getByStudent(studentConsult.getStudent().getId());
            if(studentConsults.size()>0){
                User consulter = studentConsults.get(0).getConsulter();
                throw new ServiceException("学员已被锁定，锁定人："+ ((consulter==null)?"":(consulter.getFullname()+ " (" + consulter.getUsername() + ")")));
            }
            studentConsultDao.save(studentConsult);
        }
    }


    @Override
    public void prepareAndSave(long stuId) throws Exception {
        User consulter = userUtils.getLoggedUser();
        Student student = studentDao.getById(stuId);
        StudentConsult studentConsult = new StudentConsult();
        studentConsult.setStudent(student);
        studentConsult.setConsulter(consulter);
        studentConsult.setLastLockTime(new Date());
        //获取代理类
        StudentConsultService studentConsultService = (StudentConsultService) AopContext.currentProxy();
        studentConsultService.save(studentConsult);
    }

    @Transactional(readOnly = true)
    @Override
    public PageResult getList(BaseQuery bq) throws Exception {
        return new PageResult(studentConsultDao.getListPage(bq),bq.getPage().getTotal_count());
    }

    @Transactional(rollbackFor = {Throwable.class})
    @Override
    public void update(StudentConsult studentConsult) throws Exception {
        studentConsult.setLastLockTime(new Date());
        studentConsultDao.update(studentConsult);
    }

    @Transactional(rollbackFor = {Throwable.class})
    @Override
    public void delete(StudentConsult studentConsult) throws Exception {
        studentConsultDao.delete(studentConsult);
    }

    /*
    @Override
    public List<StudentConsult> getRemindList(User consulter) throws Exception {
        return studentConsultDao.getRemindList(consulter, DateUtils.getTodayStartTime(),DateUtils.getTodayEndTime());
    }
    */
}
