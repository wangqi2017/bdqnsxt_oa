package com.bdqnsxt.oa.dao;

import com.bdqnsxt.oa.model.activities.AbstractActivity;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityDao {
    void save(AbstractActivity aa) throws Exception;
}
