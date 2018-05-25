package com.bdqnsxt.oa.utils;

import com.bdqnsxt.oa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Component
public class UserUtils {

    public static final String LOGIN_KEY = "login_user";

    @Autowired
    private HttpSession session;

    public User getLoggedUser() {
        User u = (User)session.getAttribute(LOGIN_KEY);
        return u;
    }
}
