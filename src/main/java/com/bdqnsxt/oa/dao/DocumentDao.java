package com.bdqnsxt.oa.dao;

import com.bdqnsxt.oa.component.db.BaseQuery;
import com.bdqnsxt.oa.model.Document;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentDao {
    List<Document> getListPage(BaseQuery bq) throws Exception;
    void save(Document document) throws Exception;
    void saveDocCat(Document document) throws Exception;
    void delete(Document document) throws Exception;
    Document getById(Document document) throws Exception;
    void deleteCenter(long docId) throws Exception;
    List<Document> getByCat(long catId) throws Exception;
}
