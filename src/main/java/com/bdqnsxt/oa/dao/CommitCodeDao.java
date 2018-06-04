package com.bdqnsxt.oa.dao;

import com.bdqnsxt.oa.component.db.BaseQuery;
import com.bdqnsxt.oa.model.CommitCode;
import com.bdqnsxt.oa.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommitCodeDao {
    void save(CommitCode commitCode) throws Exception;
    List<CommitCode> getList(BaseQuery baseQuery) throws Exception;
}
