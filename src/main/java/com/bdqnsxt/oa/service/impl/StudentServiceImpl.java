package com.bdqnsxt.oa.service.impl;

import com.bdqnsxt.oa.component.db.BaseQuery;
import com.bdqnsxt.oa.component.page.PageResult;
import com.bdqnsxt.oa.conf.application.GitServerConfig;
import com.bdqnsxt.oa.dao.CommitCodeDao;
import com.bdqnsxt.oa.dao.StudentDao;
import com.bdqnsxt.oa.dao.UserDao;
import com.bdqnsxt.oa.exception.ServiceException;
import com.bdqnsxt.oa.exception.StudentExistException;
import com.bdqnsxt.oa.model.Clazz;
import com.bdqnsxt.oa.model.CommitCode;
import com.bdqnsxt.oa.model.Student;
import com.bdqnsxt.oa.model.User;
import com.bdqnsxt.oa.service.StudentService;
import com.bdqnsxt.oa.utils.DateUtils;
import com.bdqnsxt.oa.utils.UserUtils;
import org.apache.tomcat.jni.OS;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.LogCommand;
import org.eclipse.jgit.diff.*;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.PersonIdent;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.patch.FileHeader;
import org.eclipse.jgit.patch.HunkHeader;
import org.eclipse.jgit.revwalk.FooterLine;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevTree;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.treewalk.AbstractTreeIterator;
import org.eclipse.jgit.treewalk.CanonicalTreeParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
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

            //学员路径
            String studentPhone = student1.getMobilePhone();
            String stuPath = basePath + File.separator + studentPhone;
            File stuDir = new File(stuPath);
            if(!stuDir.exists()){
                stuDir.mkdir();
            }
            //建库
            String practicePath = stuPath + File.separator + gitServerConfig.getPracticeRepo() + ".git ";
            File praticeDir = new File(practicePath);
            String projectPath = stuPath + File.separator + gitServerConfig.getProjectRepo() + ".git ";
            File projectDir = new File(projectPath);
            if(!praticeDir.exists()&&!projectDir.exists()){
                createRepo(stuPath,gitServerConfig.getPracticeRepo());
                createRepo(stuPath,gitServerConfig.getProjectRepo());
                //用户管理
                //createUserAndGrant(studentPhone,new String[]{practicePath,projectPath});
            }
        }
    }

    private void createRepo(String stuPath,String gitDir) throws Exception{
        String path = stuPath + File.separator + gitDir+".git";
        File gitRepo = new File(path);
        Git git = Git.init().setDirectory( gitRepo ).setBare( true ).call();
        if(git == null){
            throw new ServiceException("学员代码库创建失败！");
        }
    }

    private void createUserAndGrant(String username,String[] repoPath) throws Exception{
        String os = System.getProperties().getProperty("os.name").toLowerCase();
        if( os.indexOf("windows")>=0){
            return;
        }else if(os.indexOf("linux")>=0){
            int processValue = 0;
            try {
                ProcessBuilder pb = new ProcessBuilder("sudo useradd -M  username",
                        "sudo passwd " + username,
                        "sudo chown " + username + " " + repoPath[0],"sudo chown " + username + " " + repoPath[1],
                        "sudo usermod -s git-shell " + username);
                pb.redirectErrorStream();
                Process process = pb.start();
                InputStream inputStream = process.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(
                        inputStream));
                String line = null;
                while ((line = reader.readLine()) != null) {
                    logger.debug(line);
                }
                processValue = process.waitFor();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            if(processValue>0){
                throw new ServiceException("用户授权失败！");
            }
        }

    }

    @Transactional(readOnly = true)
    @Override
    public List<Student> getByClazz(long currentClazzId) throws Exception {
        return studentDao.getByClazz(currentClazzId);
    }
}
