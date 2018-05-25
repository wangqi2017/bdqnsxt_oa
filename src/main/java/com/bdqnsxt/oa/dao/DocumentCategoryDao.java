package com.bdqnsxt.oa.dao;

import com.bdqnsxt.oa.component.db.BaseQuery;
import com.bdqnsxt.oa.model.Clazz;
import com.bdqnsxt.oa.model.DocumentCategory;
import com.bdqnsxt.oa.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentCategoryDao {
    List<DocumentCategory> getRootCats() throws Exception;
    void save(DocumentCategory documentCategory) throws Exception;
    void update(DocumentCategory documentCategory) throws Exception;
    void delete(DocumentCategory documentCategory) throws Exception;
}
