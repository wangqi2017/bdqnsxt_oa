package com.bdqnsxt.oa.service.impl;

import com.bdqnsxt.oa.component.db.BaseQuery;
import com.bdqnsxt.oa.component.page.PageResult;
import com.bdqnsxt.oa.conf.application.GitServerConfig;
import com.bdqnsxt.oa.dao.StudentDao;
import com.bdqnsxt.oa.dao.UserDao;
import com.bdqnsxt.oa.exception.ServiceException;
import com.bdqnsxt.oa.exception.StudentExistException;
import com.bdqnsxt.oa.model.Clazz;
import com.bdqnsxt.oa.model.Student;
import com.bdqnsxt.oa.model.User;
import com.bdqnsxt.oa.service.StudentService;
import com.bdqnsxt.oa.utils.UserUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    private StudentDao studentDao;
    @Autowired
    private UserUtils userUtils;
    @Autowired
    private UserDao userDao;

    @Autowired
    private GitServerConfig gitServerConfig;

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
        checkAndCreateRepo(student);
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
        checkAndCreateRepo(student);
    }

    @Transactional(rollbackFor = {Throwable.class})
    @Override
    public void delete(Student student) throws Exception {
        studentDao.delete(student);
    }

    @Transactional(rollbackFor = {Throwable.class})
    public synchronized void checkAndCreateRepo(Student student) throws Exception{
        Student student1 = studentDao.getByIds(student.getId());
        if(student1!=null&&student1.getCurrentClazz()!=null&&student1.getCurrentClazz().getId()>0 && Clazz.StatusEnum.开班.equals(student1.getCurrentClazz().getStatus())){
            //基础路径
            String basePath = gitServerConfig.getBasePath();
            File baseDir = new File(basePath);
            if(!baseDir.exists()){
                baseDir.mkdir();
            }
            //班级路径
            long clazzId = student1.getCurrentClazz().getId();
            String clazzPath = basePath + File.separator + clazzId;
            File clazzDir = new File(clazzPath);
            if(!clazzDir.exists()){
                clazzDir.mkdir();
            }
            //学员路径
            String studentPhone = student1.getMobilePhone();
            String stuPath = clazzPath + File.separator + studentPhone;
            File stuDir = new File(stuPath);
            if(!stuDir.exists()){
                stuDir.mkdir();
            }

            String practicePath = stuPath + File.separator + gitServerConfig.getPracticeRepo() + ".git ";
            File praticeDir = new File(practicePath);
            if(!praticeDir.exists()){
                createRepo(stuPath,gitServerConfig.getPracticeRepo());
            }
            String projectPath = stuPath + File.separator + gitServerConfig.getProjectRepo() + ".git ";
            File projectDir = new File(projectPath);
            if(!projectDir.exists()){
                createRepo(stuPath,gitServerConfig.getProjectRepo());
            }

        }
    }

    private void createRepo(String stuPath,String gitDir) throws Exception{
        String cmd = gitServerConfig.getBaseCmd() + " cd " + stuPath
                + "  && git init --bare " + gitDir + ".git";
        cmd = cmd.replace('\\','/');
        BufferedReader br = null;
        Process process = null;
        int exitValue = 0;
        try {
            process = Runtime.getRuntime().exec(cmd);
            br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            exitValue = process.waitFor();
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            logger.debug(sb.toString());
            if(exitValue != 0){
                throw new ServiceException("初始化仓库失败！");
            }
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }finally{
            if (br != null)
            {
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
