package com.bdqnsxt.oa.controller;

import com.bdqnsxt.oa.component.db.BaseQuery;
import com.bdqnsxt.oa.component.page.PageInfo;
import com.bdqnsxt.oa.component.page.PageResult;
import com.bdqnsxt.oa.conf.application.UploadConfig;
import com.bdqnsxt.oa.dto.DepartmentDto;
import com.bdqnsxt.oa.dto.DocumentDto;
import com.bdqnsxt.oa.exception.DepartmentExistException;
import com.bdqnsxt.oa.exception.ServiceException;
import com.bdqnsxt.oa.model.*;
import com.bdqnsxt.oa.service.DepartmentService;
import com.bdqnsxt.oa.service.DocumentService;
import com.bdqnsxt.oa.service.SystemRoleService;
import com.bdqnsxt.oa.utils.FileUtils;
import com.bdqnsxt.oa.utils.ResponseUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class DocumentController {

    private Logger logger = LoggerFactory.getLogger(DocumentController.class);

    @Autowired
    private SystemRoleService systemRoleService;
    @Autowired
    private DocumentService documentService;

    @RequestMapping(value = "/getAllDocumentCategory", method = RequestMethod.GET)
    public Map<String, Object> getBasicRole() throws Exception {
        List<SystemRole> roles = systemRoleService.getBasicRole();
        return ResponseUtils.successExtJSProxyResponse(roles,"");
    }

    @RequestMapping(value = "/documents/{catId}", method = RequestMethod.GET)
    public Map<String, Object> getList(@PathVariable("catId") long catId,PageInfo pageInfo) throws Exception {
        BaseQuery bq = new BaseQuery();
        if (catId>0) {
            bq.putCondition("catId", "=", catId);
        }
        bq.setPage(pageInfo);
        PageResult rs = documentService.getList(bq);
        return ResponseUtils.extJSProxyResponse(rs.getResult(), rs.getTotal());
    }

    @RequestMapping(value = "/documents", method = RequestMethod.POST)
    public Map<String, Object> save(DocumentDto dto) throws Exception {
        Document doc = new Document(null,dto.getDescription(),null,dto.getCatIds());
        try{
            documentService.upload(doc,dto.getDoc());
            return ResponseUtils.successExtJSProxyResponse(null,"模板保存成功,请到相应分类下查看");
        }catch (ServiceException e){
            return ResponseUtils.failureExtJSProxyResponse(e.getMessage());
        }
    }

    @RequestMapping(value = "/documents/{id}", method = RequestMethod.DELETE)
    public Map<String, Object> delete(@RequestBody  DocumentDto dto) throws Exception {
        try{
            documentService.delete(new Document(dto.getId(),dto.getName()));
            return ResponseUtils.successExtJSProxyResponse(null,"模板删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseUtils.failureExtJSProxyResponse("模板删除失败！");
        }
    }

    @RequestMapping(value = "/document_download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable("id") long id) throws Exception{
        return documentService.download(id);
    }

    @RequestMapping(value = "/document_view/{id}")
    public ResponseEntity<?> view(@PathVariable("id") long id) throws Exception{
        return documentService.view(id);
    }
}
