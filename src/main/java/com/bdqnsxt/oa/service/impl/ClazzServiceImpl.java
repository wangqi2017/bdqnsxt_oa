package com.bdqnsxt.oa.service.impl;

import com.bdqnsxt.oa.component.db.BaseQuery;
import com.bdqnsxt.oa.component.page.PageResult;
import com.bdqnsxt.oa.dao.ClazzDao;
import com.bdqnsxt.oa.dao.StudentDao;
import com.bdqnsxt.oa.exception.ClazzExistException;
import com.bdqnsxt.oa.exception.ClazzSubStudentExistException;
import com.bdqnsxt.oa.model.Clazz;
import com.bdqnsxt.oa.model.School;
import com.bdqnsxt.oa.model.Student;
import com.bdqnsxt.oa.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {


    @Autowired
    private ClazzDao clazzDao;

    @Autowired
    private StudentDao studentDao;

    @Transactional(readOnly = true)
    @Override
    public List<Clazz> getAll() throws Exception {
        return clazzDao.getAll();
    }

    @Transactional(readOnly = true)
    @Override
    public PageResult getList(BaseQuery bq) throws Exception {
        return new PageResult(clazzDao.getListPage(bq),bq.getPage().getTotal_count());
    }

    @Transactional(rollbackFor = {Throwable.class})
    @Override
    public void save(Clazz clazz) throws Exception {
        List<Clazz> ss = clazzDao.getByClname(clazz.getClname());
        if (ss.size() > 0) {
            throw new ClazzExistException("添加失败！班级名称： " + clazz.getClname() + "   已存在");
        }
        clazzDao.save(clazz);
        if(clazz.getTutors()!=null&&clazz.getTutors().size()>0){
            clazzDao.saveClazzTutors(clazz.getId(),clazz.getTutors());
        }
    }

    @Transactional(rollbackFor = {Throwable.class})
    @Override
    public void update(Clazz clazz) throws Exception {
        List<Clazz> ss = clazzDao.getByClnameId(clazz.getId(),clazz.getClname());
        if (ss.size() > 0) {
            throw new ClazzExistException("修改失败！班级名称： " + clazz.getClname() + "   已存在");
        }

        clazzDao.update(clazz);
        if(clazz.getTutors()!=null&&clazz.getTutors().size()>0){
            clazzDao.deleteClazzTutors(clazz.getId());
            clazzDao.saveClazzTutors(clazz.getId(),clazz.getTutors());
        }
    }

    @Transactional(rollbackFor = {Throwable.class})
    @Override
    public void delete(Clazz clazz) throws Exception {
        List<Student> stus = studentDao.getByClazz(clazz.getId());
        if(stus.size()>0){
            throw new ClazzSubStudentExistException("还有学员，无法删除！");
        }
        clazzDao.delete(clazz);
    }
}
