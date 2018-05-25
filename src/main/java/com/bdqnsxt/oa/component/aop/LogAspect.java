package com.bdqnsxt.oa.component.aop;


import com.bdqnsxt.oa.dao.ActivityDao;
import com.bdqnsxt.oa.model.AbstractModel;
import com.bdqnsxt.oa.model.activities.*;
import com.bdqnsxt.oa.utils.UserUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Date;


@Aspect
@Component
//值越大，优先级越低
@Order(30)
public class LogAspect {
    @Autowired
    private ActivityDao ad;

    @Pointcut("execution(public * com.bdqnsxt.oa.service..*.save*(..)) " +
            "|| execution(public * com.bdqnsxt.oa.service..*.update*(..)) " +
            "||execution(public * com.bdqnsxt.oa.service..*.delete*(..))" +
            "||execution(public * com.bdqnsxt.oa.service..*.copy*(..))" +
            "||execution(public * com.bdqnsxt.oa.service..*.upload*(..))")
    public void logPoint(){}

    @Autowired
    private UserUtils userUtils;

    @Around("logPoint()")
    public Object arround(ProceedingJoinPoint pjp) throws Throwable{
        try {
            Object o =  pjp.proceed();

            AbstractActivity aa = getActivity(pjp);
            AbstractModel am = getModel(pjp);
            if(aa!=null&&am!=null){
                aa.setObject(am);
                aa.setCreateOn(new Date());
                aa.setCreateByUsername("系统自动--日志");
                aa.setUpdateOn(new Date());
                aa.setUpdateByUsername("系统自动--日志");
                aa.generate(userUtils.getLoggedUser());
                ad.save(aa);
            }
            return o;
        } catch (Throwable e) {
            throw e;
        }
    }

    private AbstractActivity getActivity(ProceedingJoinPoint pjp){
        String methodName = pjp.getSignature().getName();
        if(methodName.startsWith("save")){
            return new ObjectCreateActivity();
        }else if(methodName.startsWith("update")){
            return new ObjectUpdateActivity();
        }else if(methodName.startsWith("delete")){
            return new ObjectDeleteActivity();
        }else if(methodName.startsWith("copy")){
            return new ObjectCopyActivity();
        }else if(methodName.startsWith("upload")){
            return new ObjectUploadActivity();
        }
        return null;

    }

    private AbstractModel getModel(ProceedingJoinPoint pjp){
        Object[] args = pjp.getArgs();
        if(args!=null&&args.length>0){
            Object arg = args[0];
            if(arg instanceof AbstractModel){
                AbstractModel am = (AbstractModel) arg;
                return am;
            }
        }
        return null;
    }

}
