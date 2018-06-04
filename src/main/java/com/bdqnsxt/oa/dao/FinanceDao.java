package com.bdqnsxt.oa.dao;

import com.bdqnsxt.oa.component.db.BaseQuery;
import com.bdqnsxt.oa.model.Finance;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinanceDao {
    void apply(Finance finance) throws Exception;
    void update(Finance finance) throws Exception;
    void approval(Finance finance) throws Exception;
    Finance getById(long id) throws Exception;
    List<Finance> getListPage(BaseQuery bq) throws Exception;
}
