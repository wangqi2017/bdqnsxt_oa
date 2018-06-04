package com.bdqnsxt.oa.component.aop;


import com.bdqnsxt.oa.component.db.BaseQuery;
import com.bdqnsxt.oa.dao.ActivityDao;
import com.bdqnsxt.oa.model.AbstractModel;
import com.bdqnsxt.oa.model.User;
import com.bdqnsxt.oa.model.activities.*;
import com.bdqnsxt.oa.utils.UserUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Date;


@Aspect
@Component
//值越大，优先级越低
@Order(6)
public class DataAccessAspect {

    @Pointcut("execution(public * com.bdqnsxt.oa.service..*.get*(..)) " +
            "&& !(execution(public * com.bdqnsxt.oa.service.School*.get*(..)))" +
            "&& !(execution(public * com.bdqnsxt.oa.service.Document*.get*(..)))" +
            "&& !(execution(public * com.bdqnsxt.oa.service.Finance*.get*(..)))"
    )
    public void getListPoint(){}

    @Autowired
    private UserUtils userUtils;

    @Before("getListPoint()")
    public void before(JoinPoint pjp) throws Throwable{


        User user = userUtils.getLoggedUser();
        //admin或leader跳过检查
        if((user!=null&&user.isAdmin())){
            return;
        }
        Object[] args = pjp.getArgs();
        if(args!=null&&args.length>0) {
            Object arg = args[0];
            if(arg instanceof BaseQuery){
                BaseQuery bq = (BaseQuery)arg;
                if(user!=null&&user.getSchool()!=null){
                    bq.putCondition("schoolId","=",user.getSchool().getId());
                }
            }
        }
    }

}
