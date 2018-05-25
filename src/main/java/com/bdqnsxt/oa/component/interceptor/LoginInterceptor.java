package com.bdqnsxt.oa.component.interceptor;

import com.bdqnsxt.oa.model.User;
import com.bdqnsxt.oa.utils.UserUtils;
import org.apache.catalina.manager.util.SessionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        logger.debug("in login intercetor ,还没执行handler");
        HttpSession se = request.getSession();
        User user = (User) se.getAttribute(UserUtils.LOGIN_KEY);
        String url = request.getRequestURI();
        if(user != null){
            return true;
        }else{
            if(url.contains("login")){
                return true;
            }else{
                response.sendRedirect("/login");
                return false;
            }
        }
    }
}
