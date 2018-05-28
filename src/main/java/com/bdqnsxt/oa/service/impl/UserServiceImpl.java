package com.bdqnsxt.oa.service.impl;

import com.bdqnsxt.oa.component.db.BaseQuery;
import com.bdqnsxt.oa.component.page.PageResult;
import com.bdqnsxt.oa.dao.UserDao;
import com.bdqnsxt.oa.exception.PasswordErrorException;
import com.bdqnsxt.oa.exception.UserExistException;
import com.bdqnsxt.oa.exception.UserInactiveException;
import com.bdqnsxt.oa.exception.UsernameNotExistException;
import com.bdqnsxt.oa.model.User;
import com.bdqnsxt.oa.service.UserService;
import com.bdqnsxt.oa.utils.UserUtils;
import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    public static final String DEFAULT_PWD = "123456";

    private Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserUtils userUtils;


    @Transactional(readOnly = true)
    @Override
    public PageResult getList(BaseQuery bq) throws Exception {
        return new PageResult(userDao.getListPage(bq),bq.getPage().getTotal_count());
    }

    @Transactional(readOnly = true)
    @Override
    public PageResult getTeacherList(BaseQuery bq) throws Exception {
        return new PageResult(userDao.getTeacherListPage(bq),bq.getPage().getTotal_count());
    }

    @Override
    public List<User> getUsersBySchoolAndRole(long schoolId,String[] roleNames) throws Exception {
        return userDao.getUsersBySchoolAndRole(schoolId,roleNames);
    }

    @Transactional(rollbackFor = {Throwable.class})
    @Override
    public void save(User user) throws Exception {
        List<User> us = userDao.getByUsername(user.getUsername());
        if (us.size() > 0) {
            throw new UserExistException("添加失败！用户名： " + user.getUsername() + "   已存在");
        }

        List<User> us2 = userDao.getByPhone(user.getMobilePhone());
        if (us2.size() > 0) {
            throw new UserExistException("添加失败！手机号： " + user.getMobilePhone() + "   已存在");
        }

        String pwd = BCrypt.hashpw(DEFAULT_PWD, BCrypt.gensalt());
        user.setPassword(pwd);
        userDao.save(user);
        if(user.getRoles()!=null&&user.getRoles().size()>0){
            userDao.saveUserRoles(user);
        }

    }

    @Transactional(rollbackFor = {Throwable.class})
    @Override
    public void update(User user) throws Exception {
        List<User> us = userDao.getByUsernameId(user.getId(),user.getUsername());
        if (us.size() > 0) {
            throw new UserExistException("修改失败！用户名： " + user.getUsername() + "   已存在");
        }

        List<User> us2 = userDao.getByPhoneId(user.getId(),user.getMobilePhone());
        if (us2.size() > 0) {
            throw new UserExistException("修改失败！手机号： " + user.getMobilePhone() + "   已存在");
        }
        userDao.update(user);
        if(user.getRoles()!=null&&user.getRoles().size()>0) {
            userDao.deleteUserRoles(user);
            userDao.saveUserRoles(user);
        }
    }

    @Transactional(rollbackFor = {Throwable.class})
    @Override
    public void delete(User user) throws Exception {
        userDao.delete(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User login(User user) throws Exception {
        List<User> us1 = userDao.getByUsername(user.getUsername());
        if(us1.size()<1){
            throw new UsernameNotExistException("用户不存在！");
        }
        User u = us1.get(0);
        if(!BCrypt.checkpw(user.getPassword(), u.getPassword())) {
            log.warn("Incorrect password attempt " + user.getUsername());
            throw new PasswordErrorException("密码错误！");
        }
        if(u.getStatus() == User.StatusEnum.INACTIVE){
            throw new UserInactiveException("用户已被禁止，请和管理员联系！");
        }
        return u;
    }

    @Transactional(rollbackFor = {Throwable.class})
    @Override
    public void userPass(String oldPassword, String newPassword) throws Exception {
        User user = userUtils.getLoggedUser();
        List<User> us1 = userDao.getByUsername(user.getUsername());
        User u = us1.get(0);
        if(!BCrypt.checkpw(oldPassword, u.getPassword())) {
            throw new PasswordErrorException("原密码输入错误！");
        }
        userDao.updatePass(u.getId(),BCrypt.hashpw(newPassword, BCrypt.gensalt()));
    }

    @Transactional(rollbackFor = {Throwable.class})
    @Override
    public List<User> getByRoleNames(BaseQuery bq, String[] roleNames) throws Exception {
        return userDao.getByRoleNames(bq,roleNames);
    }
}
