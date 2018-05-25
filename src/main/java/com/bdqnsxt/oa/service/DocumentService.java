package com.bdqnsxt.oa.service;

import com.bdqnsxt.oa.component.db.BaseQuery;
import com.bdqnsxt.oa.component.page.PageResult;
import com.bdqnsxt.oa.model.Document;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DocumentService {
    PageResult getList(BaseQuery baseQuery) throws Exception;
    void upload(Document doc, MultipartFile file) throws Exception;
    void delete(Document doc) throws Exception;
    ResponseEntity<byte[]> download(long id) throws Exception;
    ResponseEntity<?> view(long id) throws Exception;

}
