package com.bdqnsxt.oa.controller;

import com.bdqnsxt.oa.component.db.BaseQuery;
import com.bdqnsxt.oa.component.page.PageInfo;
import com.bdqnsxt.oa.component.page.PageResult;
import com.bdqnsxt.oa.dao.FinanceDao;
import com.bdqnsxt.oa.dto.ConsultDto;
import com.bdqnsxt.oa.dto.FinanceDto;
import com.bdqnsxt.oa.dto.FinanceQueryDto;
import com.bdqnsxt.oa.exception.ServiceException;
import com.bdqnsxt.oa.model.Finance;
import com.bdqnsxt.oa.model.Process;
import com.bdqnsxt.oa.model.StudentConsult;
import com.bdqnsxt.oa.service.FinanceService;
import com.bdqnsxt.oa.service.ProcessService;
import com.bdqnsxt.oa.utils.ResponseUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class FinanceController {

    private Logger logger = LoggerFactory.getLogger(FinanceController.class);

    @Autowired
    private FinanceService financeService;

    @RequestMapping(value="/finances",method = RequestMethod.GET)
    public Map<String, Object> getListPage(PageInfo pageInfo, FinanceQueryDto dto) throws Exception{
        BaseQuery bq = new BaseQuery();
        if (dto.getSchoolId()!=null&&dto.getSchoolId()>0) {
            bq.putCondition("f.schoolId", "=", dto.getSchoolId());
        }
        if (StringUtils.isNotEmpty(dto.getProcessStatus())) {
            bq.putCondition("processStatus", "=", dto.getProcessStatus());
        }
        if (dto.getFinanceApprovalerId()!=null&&dto.getFinanceApprovalerId()>0) {
            bq.putCondition("financeApprovalerId", "=", dto.getFinanceApprovalerId());
        }
        if (StringUtils.isNotEmpty(dto.getProposerName())) {
            bq.putCondition("p.fullname", "like","%"+ dto.getProposerName() + "%");
        }
        bq.setPage(pageInfo);
        PageResult rs = financeService.getList(bq);
        return ResponseUtils.extJSProxyResponse(rs.getResult(), rs.getTotal());
    }

    @RequestMapping(value="/finances",method = RequestMethod.POST)
    public Map<String, Object> apply(FinanceDto dto) throws Exception{
        try{
            financeService.save(new Finance().getCopy(dto),dto.getFiles());
            return  ResponseUtils.successExtJSProxyResponse("申请成功！");
        }catch (ServiceException e){
            return  ResponseUtils.failureExtJSProxyResponse(e.getMessage());
        }
    }

    @RequestMapping(value = "/finances/{id}", method = RequestMethod.POST)
    public Map<String, Object> update(FinanceDto dto) throws Exception {
        financeService.update(new Finance().getCopy(dto),dto.getFiles());
        return ResponseUtils.successExtJSProxyResponse("草稿修改成功");
    }

    @RequestMapping(value = "/financesApproval", method = RequestMethod.POST)
    public Map<String, Object> approval(FinanceDto dto) throws Exception {
        try{
            financeService.updateApproval(new Finance().getApprovalCopy(dto));
            return ResponseUtils.successExtJSProxyResponse("审批成功");
        }catch (ServiceException e){
            return  ResponseUtils.failureExtJSProxyResponse(e.getMessage());
        }
    }
}
