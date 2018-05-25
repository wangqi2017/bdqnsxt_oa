package com.bdqnsxt.oa.service;

import com.bdqnsxt.oa.component.db.BaseQuery;
import com.bdqnsxt.oa.component.page.PageResult;
import com.bdqnsxt.oa.model.StudentConsult;
import com.bdqnsxt.oa.model.User;

import java.util.List;

public interface StudentConsultService {
    PageResult getList(BaseQuery bq) throws Exception;
    void save(StudentConsult studentConsult) throws Exception;
    void update(StudentConsult studentConsult) throws Exception;
    void delete(StudentConsult studentConsult) throws Exception;
    void prepareAndSave(long stuId) throws Exception;
    //List<StudentConsult> getRemindList(User consulter) throws Exception;

}
