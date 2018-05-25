package com.bdqnsxt.oa.dao;

import com.bdqnsxt.oa.component.db.BaseQuery;
import com.bdqnsxt.oa.model.StudentConsult;
import com.bdqnsxt.oa.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface StudentConsultDao {
    List<StudentConsult> getListPage(BaseQuery bq) throws Exception;
    void save(StudentConsult studentConsult) throws Exception;
    void update(StudentConsult studentConsult) throws Exception;
    void delete(StudentConsult studentConsult) throws Exception;
    List<StudentConsult> getRemindList(@Param("start") Date start,@Param("end") Date end) throws Exception;
    List<StudentConsult> getByStudent(long stuId) throws Exception;
}
