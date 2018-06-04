package com.bdqnsxt.oa.controller;

import com.bdqnsxt.oa.component.db.BaseQuery;
import com.bdqnsxt.oa.component.page.PageResult;
import com.bdqnsxt.oa.dto.CommitCodeQueryDto;
import com.bdqnsxt.oa.model.CommitCode;
import com.bdqnsxt.oa.service.StudentCodeService;
import com.bdqnsxt.oa.utils.ResponseUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class StudentCodeController {
    @Autowired
    private StudentCodeService studentCodeService;

    @RequestMapping(value = "/testCode", method = RequestMethod.GET)
    public String testCode() throws Exception{
        studentCodeService.countCode();
        return "test";
    }

    @RequestMapping(value = "/codes", method = RequestMethod.GET)
    public Map<String, Object> getList(CommitCodeQueryDto commitCodeQueryDto) throws Exception {
        BaseQuery bq = new BaseQuery();
        if (commitCodeQueryDto.getStuId()==null || commitCodeQueryDto.getStuId() <1 ) {
            return ResponseUtils.failureExtJSProxyResponse("至少选择一个学员");
        }else{
            bq.putCondition("stuId", "=", commitCodeQueryDto.getStuId());
            if (commitCodeQueryDto.getStartCommitTime()!=null) {
                bq.putCondition("commitTime", ">=", commitCodeQueryDto.getStartCommitTime());
            }
            if (commitCodeQueryDto.getEndCommitTime()!=null) {
                bq.putCondition("commitTime", "<=", commitCodeQueryDto.getEndCommitTime());
            }
            if (commitCodeQueryDto.getRepoType()!=null) {
                bq.putCondition("repoType", "=", commitCodeQueryDto.getRepoType());
            }
            List<CommitCode> commitCodes = studentCodeService.getList(bq);
            return ResponseUtils.successExtJSProxyResponse(commitCodes, "查询成功！");
        }

    }
}
