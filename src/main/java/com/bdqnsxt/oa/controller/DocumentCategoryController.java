package com.bdqnsxt.oa.controller;

import com.bdqnsxt.oa.component.db.BaseQuery;
import com.bdqnsxt.oa.component.page.PageInfo;
import com.bdqnsxt.oa.component.page.PageResult;
import com.bdqnsxt.oa.dto.ClazzDto;
import com.bdqnsxt.oa.dto.ClazzQueryDto;
import com.bdqnsxt.oa.dto.DocumentCategoryDto;
import com.bdqnsxt.oa.dto.SchoolDto;
import com.bdqnsxt.oa.exception.ClazzExistException;
import com.bdqnsxt.oa.exception.ClazzSubStudentExistException;
import com.bdqnsxt.oa.exception.SchoolExistException;
import com.bdqnsxt.oa.exception.ServiceException;
import com.bdqnsxt.oa.model.Clazz;
import com.bdqnsxt.oa.model.DocumentCategory;
import com.bdqnsxt.oa.model.School;
import com.bdqnsxt.oa.service.ClazzService;
import com.bdqnsxt.oa.service.DocumentCategoryService;
import com.bdqnsxt.oa.utils.ResponseUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class DocumentCategoryController {

    private Logger logger = LoggerFactory.getLogger(DocumentCategoryController.class);

    @Autowired
    private DocumentCategoryService documentCategoryService;

    @RequestMapping(value = "/docCats", method = RequestMethod.GET)
    public Map<String, Object> getRootCategories() throws Exception {
        List<DocumentCategory> dcs = documentCategoryService.getRootCats();
        return ResponseUtils.successExtJSTreeProxyResponse(dcs,"docCats");
    }

    @RequestMapping(value = "/docCats", method = RequestMethod.POST)
    public Map<String, Object> save(@RequestBody DocumentCategoryDto dto) throws Exception {
        try {
            documentCategoryService.save(new DocumentCategory().getDocumentCategoryCopy(dto));
            return ResponseUtils.successExtJSProxyResponse("模板分类保存成功");
        } catch (SchoolExistException e) {
            return ResponseUtils.failureExtJSProxyResponse(e.getMessage());
        }
    }

    @RequestMapping(value = "/docCats/{id}", method = RequestMethod.PUT)
    public Map<String, Object> update(@RequestBody DocumentCategoryDto dto) throws Exception {
        try {
            documentCategoryService.update(new DocumentCategory().getDocumentCategoryCopy(dto));
            return ResponseUtils.successExtJSProxyResponse("模板分类修改成功");
        } catch (ServiceException e) {
            return ResponseUtils.failureExtJSProxyResponse(e.getMessage());
        }
    }

    @RequestMapping(value = "/docCats/{id}", method = RequestMethod.DELETE)
    public Map<String, Object> delete(@RequestBody DocumentCategoryDto dto) throws Exception {
        try {
            documentCategoryService.delete(new DocumentCategory().getDocumentCategoryCopy(dto));
            return ResponseUtils.successExtJSProxyResponse("模板分类删除成功");
        } catch (ServiceException e) {
            return ResponseUtils.failureExtJSProxyResponse(e.getMessage());
        }
    }
}
