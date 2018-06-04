package com.bdqnsxt.oa.service;

import com.bdqnsxt.oa.component.db.BaseQuery;
import com.bdqnsxt.oa.model.CommitCode;

import java.util.List;

public interface StudentCodeService {
    void countCode() throws Exception;
    List<CommitCode> getList(BaseQuery baseQuery) throws Exception;
}
