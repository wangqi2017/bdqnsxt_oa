package com.bdqnsxt.oa.model.activities;

import com.bdqnsxt.oa.model.AbstractModel;
import com.bdqnsxt.oa.model.User;
import com.bdqnsxt.oa.utils.UserUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


public abstract class AbstractActivity extends AbstractModel {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private String atype;
    private String device = "PC"; // 提交方式
    protected AbstractModel m;
    private String objectClass;
    private long objectId;
    private String activityText;
    private String action;


    public abstract String getAtype();

    public void setAtype(String atype) {
        this.atype = atype;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public AbstractModel getM() {
        return m;
    }

    public void setM(AbstractModel m) {
        this.m = m;
    }

    public String getObjectClass() {
        return objectClass;
    }

    public void setObjectClass(String objectClass) {
        this.objectClass = objectClass;
    }

    public long getObjectId() {
        return objectId;
    }

    public void setObjectId(long objectId) {
        this.objectId = objectId;
    }

    public String getActivityText() {
        return activityText;
    }

    public void setActivityText(String activityText) {
        this.activityText = activityText;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String getDisplayClassName() {
        return "日志";
    }

    @Override
    public String getDisplayName() {
        return null;
    }

    public void setObject(AbstractModel m) {
        if (m != null) {
            setObjectClass(m.getClass().getName());
            setObjectId(m.getId());
            this.m = m;
        }
    }

    public void generate(User loginUser) {
        try {
            if (m != null && loginUser!=null) {
                if (m.getDisplayClassName() != null
                        && m.getDisplayName() != null) {
                    setActivityText(loginUser.getUsername() + " " + getAction()
                            + m.getDisplayClassName() + m.getDisplayName());
                } else {
                    setActivityText(loginUser.getUsername() + " " + getAction());
                }
            } else {
                setActivityText(loginUser.getUsername() + " " + getAction());
            }
        } catch (Exception e) {
            logger.error("Activity text generation error");
            setActivityText("日志数据错误");
        }
    }

}
