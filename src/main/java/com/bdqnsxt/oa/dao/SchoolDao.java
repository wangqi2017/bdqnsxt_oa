package com.bdqnsxt.oa.dao;

import com.bdqnsxt.oa.component.db.BaseQuery;
import com.bdqnsxt.oa.model.School;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolDao {
    List<School> getAll() throws Exception;
    List<School> getListPage(BaseQuery bq) throws Exception;
    void save(School school) throws Exception;
    void update(School school) throws Exception;
    void delete(School school) throws Exception;
    List<School> getByScname(String scname) throws Exception;
    List<School> getByScnameId(@Param("id") long id, @Param("scname")String scname) throws Exception;

}
