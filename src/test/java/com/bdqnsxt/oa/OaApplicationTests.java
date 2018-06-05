package com.bdqnsxt.oa;

import com.bdqnsxt.oa.dao.UserDao;
import com.bdqnsxt.oa.enums.GenderEnum;
import com.bdqnsxt.oa.model.School;
import com.bdqnsxt.oa.model.User;
import com.bdqnsxt.oa.service.impl.UserServiceImpl;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class OaApplicationTests {

    @Test
    public void test() throws Exception{
        System.out.println();
    }

	/*
	@Autowired
	private SqlSessionFactory sf;

	@Test
	public void test(){}




	@Test
	public void addUser() throws Exception{
		SqlSession se =sf.openSession();
		UserDao ud = se.getMapper(UserDao.class);
		String username = "ls";
		String fullname = "李";
		String email = "@qq.com";
		for(int i = 105;i<107;i++){
			User u = new User();
			u.setUsername(username + i);
			u.setPassword(BCrypt.hashpw(UserServiceImpl.DEFAULT_PWD, BCrypt.gensalt()));
			u.setFullname(fullname+i);
			u.setGender(GenderEnum.MAIL);
			u.setStatus(User.StatusEnum.ACTIVE);
			u.setEmail(fullname+i+email);
			u.setMobilePhone(getTel());
			u.setHireDate(new Date());
			u.setCreateByUsername("wq");
			u.setUpdateByUsername("wq");
			u.setUpdateOn(new Date());
			u.setCreateOn(new Date());
			ud.save(u);
		}
	}

	private static String[] telFirst="134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153".split(",");

	public static int getNum(int start,int end) {
		return (int)(Math.random()*(end-start+1)+start);
	}

	private static String getTel() {
		int index=getNum(0,telFirst.length-1);
		String first=telFirst[index];
		String second=String.valueOf(getNum(1,888)+10000).substring(1);
		String third=String.valueOf(getNum(1,9100)+10000).substring(1);
		return first+second+third;
	}
	*/

}
