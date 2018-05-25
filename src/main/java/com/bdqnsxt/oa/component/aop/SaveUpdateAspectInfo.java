package com.bdqnsxt.oa.component.aop;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.bdqnsxt.oa.model.AbstractModel;
import com.bdqnsxt.oa.model.User;
import com.bdqnsxt.oa.utils.UserUtils;
import org.apache.catalina.manager.util.SessionUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;




@Component
@Aspect
@Order(5)
public class SaveUpdateAspectInfo {

	public static final String CREATE_USER = "createByUsername";
	public static final String CREATE_DATE = "createOn";
	public static final String CREATE_ID   = "createByUserId";
	public static final String UPDATE_USER = "updateByUsername";
	public static final String UPDATE_DATE = "updateOn";
	public static final String UPDATE_ID   = "updateByUserId";

	@Autowired
	private UserUtils userUtils;

	@Pointcut("execution(public * com.bdqnsxt.oa.service..*.save*(..)) " +
			"|| execution(public * com.bdqnsxt.oa.service..*.update*(..)) " +
			"|| execution(public * com.bdqnsxt.oa.service..*.upload*(..)) ")
	public void saveOrUpdatePointCut(){}

	
	@Before("saveOrUpdatePointCut()")
	public void addInfoForSaveAndUpdate(JoinPoint jp) throws Exception{
		User user = userUtils.getLoggedUser();
		Object[] args = jp.getArgs();
		if(args!=null&&args.length>0){
			Object arg = args[0];
			String optMethodName = jp.getSignature().getName();
			if(optMethodName.startsWith("save")||optMethodName.startsWith("upload")){
				saveOpt(arg,user);
			}else if(optMethodName.startsWith("update")){
				updateOpt(arg,user);
			}
		}
		
	}

	private void saveOpt(Object arg, User creater){
		String username = creater.getUsername();
		long   id  = creater.getId();
		if(arg instanceof Map){
			Map<String,Object> map = (Map<String, Object>) arg;
			map.put(CREATE_DATE, new Date());
			map.put(UPDATE_DATE,new Date());
			if(StringUtils.isNotEmpty(username)){
				map.put(CREATE_USER, username);
				map.put(UPDATE_USER,username);
			}
			if(creater.getId() > 0){
				map.put(CREATE_ID,id);
				map.put(UPDATE_ID,id);
			}
		}else{
			if(arg instanceof AbstractModel){
				AbstractModel am = (AbstractModel) arg;
				am.setCreateOn(new Date());
				am.setUpdateOn(new Date());
				if(StringUtils.isNotEmpty(username)){
					am.setCreateByUsername(username);
					am.setUpdateByUsername(username);
				}
				if(creater.getId() > 0){
					am.setCreateByUserId(id);
					am.setUpdateByUserId(id);
				}
			}
		}
	}

	private void updateOpt(Object arg, User updater){
		String username = updater.getUsername();
		long   id  = updater.getId();
		if(arg instanceof Map){
			Map<String,Object> map = (Map<String, Object>) arg;
			map.put(UPDATE_DATE, new Date());
			if(StringUtils.isNotEmpty(username)){
				map.put(CREATE_USER, username);
			}
			if(id > 0){
				map.put(UPDATE_ID,id);
			}
		}else{
			if(arg instanceof AbstractModel){
				AbstractModel am = (AbstractModel) arg;
				am.setUpdateOn(new Date());
				if(StringUtils.isNotEmpty(username)){
					am.setUpdateByUsername(username);
				}
				if(id > 0){
					am.setUpdateByUserId(id);
				}
			}
		}
	}
}
