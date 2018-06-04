package com.bdqnsxt.oa;

import com.bdqnsxt.oa.component.db.BaseQuery;
import com.bdqnsxt.oa.dao.UserDao;
import com.bdqnsxt.oa.enums.GenderEnum;
import com.bdqnsxt.oa.model.User;
import com.bdqnsxt.oa.service.impl.UserServiceImpl;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DapTests {

    //@Autowired
    //private RepositoryService repositoryService;



    /*
	@Autowired
	private UserDao userDao;

	private Logger log = LoggerFactory.getLogger(DapTests.class);


	@Test
	public void testQuery() throws Exception{
		long start = System.currentTimeMillis();
		BaseQuery bq = new BaseQuery();
		bq.getPage().setStart(0);
		bq.getPage().setLimit(10);
		List<User> users= userDao.getListPage(bq);
		long end = System.currentTimeMillis();
		log.debug(String.valueOf(end-start)+"秒");
	}
	*/
}
