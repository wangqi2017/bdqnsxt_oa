package com.bdqnsxt.oa.conf.application;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("exec")
public class ExecConfig {
    private String gitLog;

    public String getGitLog() {
        return gitLog;
    }

    public void setGitLog(String gitLog) {
        this.gitLog = gitLog;
    }
}
