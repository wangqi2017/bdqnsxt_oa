package com.bdqnsxt.oa.service;

import com.bdqnsxt.oa.component.db.BaseQuery;
import com.bdqnsxt.oa.component.page.PageResult;
import com.bdqnsxt.oa.dto.ClazzDto;
import com.bdqnsxt.oa.model.Clazz;
import com.bdqnsxt.oa.model.School;

import java.util.List;


public interface ClazzService {
    List<Clazz> getAll() throws Exception;
    PageResult getList(BaseQuery bq) throws Exception;
    void save(Clazz clazz) throws Exception;
    void update(Clazz clazz) throws Exception;
    void delete(Clazz clazz) throws Exception;
}
