package com.bdqnsxt.oa.dao;

import com.bdqnsxt.oa.component.db.BaseQuery;
import com.bdqnsxt.oa.model.Resource;
import com.bdqnsxt.oa.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceDao {
    List<Resource> getByRole(long roleId) throws Exception;
    List<Resource> getAll() throws Exception;
}
