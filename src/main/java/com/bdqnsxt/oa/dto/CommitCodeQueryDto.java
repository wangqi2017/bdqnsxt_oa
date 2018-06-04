package com.bdqnsxt.oa.dto;

import com.bdqnsxt.oa.model.CommitCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class CommitCodeQueryDto {
    private Long stuId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startCommitTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endCommitTime;
    private CommitCode.RepoType repoType;


    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    public Date getStartCommitTime() {
        return startCommitTime;
    }

    public void setStartCommitTime(Date startCommitTime) {
        this.startCommitTime = startCommitTime;
    }

    public Date getEndCommitTime() {
        return endCommitTime;
    }

    public void setEndCommitTime(Date endCommitTime) {
        this.endCommitTime = endCommitTime;
    }

    public CommitCode.RepoType getRepoType() {
        return repoType;
    }

    public void setRepoType(CommitCode.RepoType repoType) {
        this.repoType = repoType;
    }
}
