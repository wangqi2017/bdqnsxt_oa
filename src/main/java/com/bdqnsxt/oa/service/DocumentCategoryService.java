package com.bdqnsxt.oa.service;

import com.bdqnsxt.oa.model.DocumentCategory;

import java.util.List;

public interface DocumentCategoryService {
    List<DocumentCategory> getRootCats() throws Exception;
    void save(DocumentCategory documentCategory) throws Exception;
    void update(DocumentCategory documentCategory) throws Exception;
    void delete(DocumentCategory documentCategory) throws Exception;
}
