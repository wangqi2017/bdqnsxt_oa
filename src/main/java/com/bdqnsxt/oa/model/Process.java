package com.bdqnsxt.oa.model;

import org.apache.ibatis.mapping.FetchType;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public class Process{
        /**
         * 状态
         */
        public static enum StatusEnum {
            草稿, 审批中, 审批完成, 已归档
        }

        /**
         * 流程编号
         */
        private String number;


        private StatusEnum status = StatusEnum.草稿;

        /**
         * Flowable instance id
         */

        private String processInstanceId;

        /**
         * Flowable definition name
         */

        private String processDefinitionName;

        /**
         * Flowable definition key
         */

        private String processDefinitionKey;

        /**
         * Flowable definition id
         */

        private String processDefinitionId;

        /**
         * Flowable definition version
         */

        private int processDefinitionVersion;


        private Set<User> involvedUsers = new HashSet<>();

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getProcessDefinitionName() {
        return processDefinitionName;
    }

    public void setProcessDefinitionName(String processDefinitionName) {
        this.processDefinitionName = processDefinitionName;
    }

    public String getProcessDefinitionKey() {
        return processDefinitionKey;
    }

    public void setProcessDefinitionKey(String processDefinitionKey) {
        this.processDefinitionKey = processDefinitionKey;
    }

    public String getProcessDefinitionId() {
        return processDefinitionId;
    }

    public void setProcessDefinitionId(String processDefinitionId) {
        this.processDefinitionId = processDefinitionId;
    }

    public int getProcessDefinitionVersion() {
        return processDefinitionVersion;
    }

    public void setProcessDefinitionVersion(int processDefinitionVersion) {
        this.processDefinitionVersion = processDefinitionVersion;
    }

    public Set<User> getInvolvedUsers() {
        return involvedUsers;
    }

    public void setInvolvedUsers(Set<User> involvedUsers) {
        this.involvedUsers = involvedUsers;
    }
}
