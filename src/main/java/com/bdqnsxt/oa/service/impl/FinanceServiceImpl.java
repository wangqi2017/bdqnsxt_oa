package com.bdqnsxt.oa.service.impl;

import com.bdqnsxt.oa.component.db.BaseQuery;
import com.bdqnsxt.oa.component.page.PageResult;
import com.bdqnsxt.oa.dao.FinanceDao;
import com.bdqnsxt.oa.dto.FinanceDto;
import com.bdqnsxt.oa.exception.ServiceException;
import com.bdqnsxt.oa.model.Finance;
import com.bdqnsxt.oa.service.FinanceService;
import com.bdqnsxt.oa.service.SystemRoleService;
import com.bdqnsxt.oa.utils.FileUtils;
import com.bdqnsxt.oa.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@Service
public class FinanceServiceImpl implements FinanceService{

    @Autowired
    private FinanceDao financeDao;

    @Autowired
    private FileUtils fileUtils;
    @Autowired
    private SystemRoleService systemRoleService;
    @Autowired
    private UserUtils userUtils;

    @Override
    public PageResult getList(BaseQuery bq) throws Exception {
        if(systemRoleService.containsRole("财务")||systemRoleService.containsRole("出纳")){
            bq.putCondition("processStatus","=", Finance.ProcessStatus.草稿);
            bq.putCondition("f.schoolId","=",userUtils.getLoggedUser().getSchool().getId());
        }else{
            if(!userUtils.getLoggedUser().isAdmin()&&!userUtils.getLoggedUser().isLeader()&&!systemRoleService.containsRole("中心校长")){
                bq.putCondition("proposerId","=",userUtils.getLoggedUser().getId());
                bq.putCondition("f.schoolId","=",userUtils.getLoggedUser().getSchool().getId());
            }else if(!userUtils.getLoggedUser().isAdmin()){
                bq.putCondition("f.schoolId","=",userUtils.getLoggedUser().getSchool().getId());
            }
        }
        return new PageResult(financeDao.getListPage(bq),bq.getPage().getTotal_count());
    }

    @Transactional
    @Override
    public void save(Finance finance,MultipartFile[] files) throws Exception {
        if(files == null || files.length == 0){
            throw new ServiceException("上传内容不能为空失败！");
        }
        StringBuffer sb = new StringBuffer();
        for(MultipartFile file:files){
            String fileName = file.getOriginalFilename();
            File out = File.createTempFile(fileName.substring(0,fileName.lastIndexOf(".")),fileName.substring(fileName.lastIndexOf(".")),fileUtils.getFinanceDirectory());
            try {
                file.transferTo(out);
                sb.append(out.getName());
                sb.append("_-_");
            }catch(IOException e){
                throw new ServiceException("发票保存过程出错，请和管理员联系");
            }
        }
        sb.delete(sb.lastIndexOf("_-_"),sb.length());
        finance.setFileLocations(sb.toString());
        finance.setProposer(userUtils.getLoggedUser());
        finance.setApplyTime(new Date());
        finance.setProcessStatus(Finance.ProcessStatus.草稿);
        financeDao.apply(finance);
    }
    @Transactional
    @Override
    public void update(Finance finance, MultipartFile[] files) throws Exception {
        if(files == null || files.length == 0){
            throw new ServiceException("上传内容不能为空失败！");
        }
        StringBuffer sb = new StringBuffer();
        for(MultipartFile file:files){
            String fileName = file.getOriginalFilename();
            File out = File.createTempFile(fileName.substring(0,fileName.lastIndexOf(".")),fileName.substring(fileName.lastIndexOf(".")),fileUtils.getFinanceDirectory());
            try {
                file.transferTo(out);
                sb.append(out.getName());
                sb.append("_-_");
            }catch(IOException e){
                throw new ServiceException("发票保存过程出错，请和管理员联系");
            }
        }
        sb.delete(sb.lastIndexOf("_-_"),sb.length());
        finance.setFileLocations(sb.toString());
        financeDao.update(finance);
    }

    @Transactional
    @Override
    public void updateApproval(Finance finance) throws Exception {

        Finance fin = financeDao.getById(finance.getId());

        if(systemRoleService.containsRole("财务")||systemRoleService.containsRole("出纳")){
            if(!Finance.ProcessStatus.草稿.equals(fin.getProcessStatus())){
                throw new ServiceException("财务人员只能审批草稿！");
            }
            finance.setFinanceApprovalOpin(finance.getApprovalOpin());
            finance.setFinanceApprovaler(userUtils.getLoggedUser());
            finance.setFinanceApprovalTime(new Date());
            if("通过".equals(finance.getIsPass())){
                finance.setProcessStatus(Finance.ProcessStatus.财务审批通过);
            }else{
                finance.setProcessStatus(Finance.ProcessStatus.草稿);
            }

        }else if(userUtils.getLoggedUser().isAdmin() || systemRoleService.containsRole("中心校长")){
            if(Finance.ProcessStatus.归档.equals(fin.getProcessStatus())){
                throw new ServiceException("已归档，无法审批！");
            }
            finance.setCenterApprovaler(userUtils.getLoggedUser());
            finance.setCenterAprrovalTime(new Date());
            finance.setCenterApprovalOpin(finance.getApprovalOpin());
            if("通过".equals(finance.getIsPass())){
                finance.setProcessStatus(Finance.ProcessStatus.中心审批通过);
            }else{
                finance.setProcessStatus(Finance.ProcessStatus.草稿);
            }
        }else{
            throw new ServiceException("您没有审批权限");
        }
        financeDao.approval(finance);
    }
}
