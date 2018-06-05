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
    private CommitCodeDao commitCodeDao;

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

    @Transactional()
    @Override
    public void countCode() throws Exception{
        List<Student> stus = studentDao.getActiveStudent();
        for(Student stu:stus){
            if(stu.getMobilePhone()!=null){
                //统计练习库
                /*
                String practicePath = gitServerConfig.getBasePath() +  File.separator + stu.getMobilePhone()
                        + File.separator + gitServerConfig.getPracticeRepo();
               */
                String practicePath = "F:\\IntelliJ_IDEA_space\\oa_bdqnsxt";
                countAndSave(stu,practicePath, CommitCode.RepoType.PRACTICE);

                //统计代码库
                /*
                String projectPath = gitServerConfig.getBasePath() +  File.separator + stu.getMobilePhone()
                        + File.separator + gitServerConfig.getProjectRepo();
                countAndSave(stu,projectPath, CommitCode.RepoType.PROJECT);
                */

            }
        }
    }

    private void countAndSave(Student student,String repoPath,CommitCode.RepoType repoType) throws Exception{
        Git git = Git.open(new File(repoPath));
        if(git!=null) {
            Repository repository = git.getRepository();
            LogCommand logCommand = git.log();
            Iterable<RevCommit> commits1 = logCommand.call();
            //获取前一天提交
            RevCommit preDayCommit = null;
            for (RevCommit commit : commits1) {
                Date date = commit.getAuthorIdent().getWhen();
                if (date.compareTo(DateUtils.getTodayStartTime()) <= 0) {
                    preDayCommit = commit;
                    break;
                }
            }

            //获取今天的提交，按顺序排列
            List<RevCommit> todayCommits = new ArrayList<>();
            Iterable<RevCommit> commits2 = git.log().call();
            for (RevCommit commit : commits2) {
                Date date = commit.getAuthorIdent().getWhen();
                if (date.compareTo(DateUtils.getTodayStartTime()) > 0 && date.compareTo(DateUtils.getTodayEndTime()) < 0) {
                    todayCommits.add(commit);
                }
            }

            //包含昨天最后一次提交和今天的所有提交
            todayCommits.add(preDayCommit);



            for (int i = todayCommits.size() - 1; i > 0; i--) {
                //第一次提交
                if (i < 1) {
                    return;
                } else {
                    AbstractTreeIterator newTree = prepareTreeParser(todayCommits.get(i), repository);
                    AbstractTreeIterator oldTree = prepareTreeParser(todayCommits.get(i - 1), repository);
                    List<DiffEntry> diff = git.diff().setOldTree(oldTree).setNewTree(newTree).setShowNameAndStatusOnly(true).call();
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    DiffFormatter df = new DiffFormatter(out);
                    //设置比较器为忽略空白字符对比（Ignores all whitespace）
                    df.setDiffComparator(RawTextComparator.WS_IGNORE_ALL);
                    df.setRepository(git.getRepository());
                    int addTotal = 0;
                    int subTotal = 0;
                    for (DiffEntry diffEntry : diff) {
                        //打印文件差异具体内容
                        df.format(diffEntry);
                        String diffText = out.toString("UTF-8");
                        System.out.println(diffText);

                        //获取文件差异位置，从而统计差异的行数，如增加行数，减少行数
                        FileHeader fileHeader = df.toFileHeader(diffEntry);
                        List<HunkHeader> hunks = (List<HunkHeader>) fileHeader.getHunks();
                        int addSize = 0;
                        int subSize = 0;
                        for (HunkHeader hunkHeader : hunks) {
                            EditList editList = hunkHeader.toEditList();
                            for (Edit edit : editList) {
                                subSize += edit.getEndA() - edit.getBeginA();
                                addSize += edit.getEndB() - edit.getBeginB();

                            }
                        }
                        //System.out.println("addSize="+addSize);
                        //System.out.println("subSize="+subSize);
                        System.out.println("------------------------------end-----------------------------");
                        out.reset();
                        addTotal += addSize;
                        subTotal += subSize;
                    }
                    System.out.println("addTotal=" + addTotal);
                    System.out.println("subTotal=" + subTotal);

                    Date commitTime = todayCommits.get(i - 1).getAuthorIdent().getWhen();
                    int totalChange = addTotal - subTotal;
                    String commitName = todayCommits.get(i - 1).getName();
                    String commitMesg = todayCommits.get(i - 1).getFullMessage();

                    CommitCode cc = new CommitCode(0, student, commitTime, addTotal, subTotal, totalChange, commitName, commitMesg, repoType);
                    commitCodeDao.save(cc);
                }
            }
        }
    }

    public AbstractTreeIterator prepareTreeParser(RevCommit commit,Repository repository){
        System.out.println(commit.getId());
        try (RevWalk walk = new RevWalk(repository)) {
            System.out.println(commit.getTree().getId());
            RevTree tree = walk.parseTree(commit.getTree().getId());

            CanonicalTreeParser oldTreeParser = new CanonicalTreeParser();
            try (ObjectReader oldReader = repository.newObjectReader()) {
                oldTreeParser.reset(oldReader, tree.getId());
            }

            walk.dispose();

            return oldTreeParser;
        }catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }
}
