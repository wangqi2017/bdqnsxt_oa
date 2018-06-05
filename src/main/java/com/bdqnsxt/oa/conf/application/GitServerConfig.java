package com.bdqnsxt.oa.conf.application;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("gitserver")
public class GitServerConfig {

    private String basePath;
    private String practiceRepo;
    private String projectRepo;

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public String getPracticeRepo() {
        return practiceRepo;
    }

    public void setPracticeRepo(String practiceRepo) {
        this.practiceRepo = practiceRepo;
    }

    public String getProjectRepo() {
        return projectRepo;
    }

    public void setProjectRepo(String projectRepo) {
        this.projectRepo = projectRepo;
    }
}
