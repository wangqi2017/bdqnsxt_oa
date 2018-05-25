package com.bdqnsxt.oa.service;

import com.bdqnsxt.oa.component.db.BaseQuery;
import com.bdqnsxt.oa.component.page.PageResult;
import com.bdqnsxt.oa.model.School;

import java.util.List;


public interface SchoolService {
    List<School> getAll() throws Exception;
    PageResult getList(BaseQuery bq) throws Exception;
    void save(School school) throws Exception;
    void update(School school) throws Exception;
    void delete(School school) throws Exception;
}
