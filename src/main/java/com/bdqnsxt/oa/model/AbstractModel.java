package com.bdqnsxt.oa.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public abstract class AbstractModel {
    protected long id;
    protected String createByUsername;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    protected Date createOn;
    protected String updateByUsername;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    protected Date   updateOn;
    protected long createByUserId;
    protected long updateByUserId;
    /**
     * 中文的对象名称
     *
     * @return
     */
    public abstract String getDisplayClassName();

    /**
     * 中文的对象描述
     *
     * @return
     */
    public abstract String getDisplayName();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCreateByUsername() {
        return createByUsername;
    }

    public void setCreateByUsername(String createByUsername) {
        this.createByUsername = createByUsername;
    }

    public Date getCreateOn() {
        return createOn;
    }

    public void setCreateOn(Date createOn) {
        this.createOn = createOn;
    }

    public String getUpdateByUsername() {
        return updateByUsername;
    }

    public void setUpdateByUsername(String updateByUsername) {
        this.updateByUsername = updateByUsername;
    }

    public Date getUpdateOn() {
        return updateOn;
    }

    public void setUpdateOn(Date updateOn) {
        this.updateOn = updateOn;
    }

    public long getCreateByUserId() {
        return createByUserId;
    }

    public void setCreateByUserId(long createByUserId) {
        this.createByUserId = createByUserId;
    }

    public long getUpdateByUserId() {
        return updateByUserId;
    }

    public void setUpdateByUserId(long updateByUserId) {
        this.updateByUserId = updateByUserId;
    }
}
