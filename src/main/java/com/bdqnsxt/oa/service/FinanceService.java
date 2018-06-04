package com.bdqnsxt.oa.service;

import com.bdqnsxt.oa.component.db.BaseQuery;
import com.bdqnsxt.oa.component.page.PageResult;
import com.bdqnsxt.oa.dto.FinanceDto;
import com.bdqnsxt.oa.model.Finance;
import org.springframework.web.multipart.MultipartFile;

public interface FinanceService {
    void save(Finance finance,MultipartFile[] files) throws Exception;
    void update(Finance finance,MultipartFile[] files) throws Exception;
    void updateApproval(Finance finance) throws Exception;
    PageResult getList(BaseQuery bq) throws Exception;
}
