package com.bdqnsxt.oa.service.impl;

import com.bdqnsxt.oa.component.db.BaseQuery;
import com.bdqnsxt.oa.conf.application.ExecConfig;
import com.bdqnsxt.oa.conf.application.GitServerConfig;
import com.bdqnsxt.oa.dao.CommitCodeDao;
import com.bdqnsxt.oa.dao.StudentDao;
import com.bdqnsxt.oa.exception.ServiceException;
import com.bdqnsxt.oa.model.CommitCode;
import com.bdqnsxt.oa.model.Student;
import com.bdqnsxt.oa.service.StudentCodeService;
import com.bdqnsxt.oa.utils.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.LogCommand;
import org.eclipse.jgit.diff.*;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectLoader;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.patch.FileHeader;
import org.eclipse.jgit.patch.HunkHeader;
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

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StudentCodeServiceImpl implements StudentCodeService{

    private Logger logger = LoggerFactory.getLogger(StudentCodeServiceImpl.class);

    @Autowired
    private GitServerConfig gitServerConfig;

    @Autowired
    private CommitCodeDao commitCodeDao;

    @Autowired
    private StudentDao studentDao;

    @Transactional(readOnly = true)
    @Override
    public List<CommitCode> getList(BaseQuery baseQuery) throws Exception {
        return commitCodeDao.getList(baseQuery);
    }

    @Transactional()
    @Override
    public void countCode() throws Exception{
        List<Student> stus = studentDao.getActiveStudent();
        for(Student stu:stus){
            if(stu.getMobilePhone()!=null){
                //统计练习库
                //String practicePath = gitServerConfig.getBasePath() +  File.separator + stu.getMobilePhone()
                //        + File.separator + gitServerConfig.getPracticeRepo();

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


            //比较lian量
            LogCommand logCommand = git.log();
            Iterable<RevCommit> commits1 = logCommand.call();
            //获取前一天提交
            RevCommit preDayCommit = null;
            RevCommit firstCommit = null;
            for (RevCommit commit : commits1) {
                Date date = commit.getAuthorIdent().getWhen();
                if (date.compareTo(DateUtils.getTodayStartTime()) <= 0) {
                    preDayCommit = commit;
                }
                firstCommit = commit;
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
                    CommitCode cc = getCommitDiff(git,repository,todayCommits.get(i),todayCommits.get(i-1));
                    cc.setStudent(student);
                    cc.setRepoType(repoType);
                    //和第一次提交相比，以获取总量
                    CommitCode totalCommit = getCommitDiff(git,repository,todayCommits.get(i),firstCommit);
                    cc.setTotal(totalCommit.getChangeTotal());
                    commitCodeDao.save(cc);
                }
            }
        }
    }

    public AbstractTreeIterator prepareTreeParser(RevCommit commit, Repository repository){
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

    private CommitCode getCommitDiff(Git git,Repository repository,RevCommit oldCommit,RevCommit newCommit) throws Exception{
        AbstractTreeIterator newTree = prepareTreeParser(oldCommit, repository);
        AbstractTreeIterator oldTree = prepareTreeParser(newCommit, repository);
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

        Date commitTime = newCommit.getAuthorIdent().getWhen();
        int totalChange = addTotal - subTotal;
        String commitName = newCommit.getName();
        String commitMesg = newCommit.getFullMessage();

        CommitCode cc = new CommitCode(0, null, commitTime, addTotal, subTotal, totalChange, commitName, commitMesg, null);
        return cc;
    }
}
