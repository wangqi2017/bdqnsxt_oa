package com.bdqnsxt.oa.service.impl;

import com.bdqnsxt.oa.dao.DocumentCategoryDao;
import com.bdqnsxt.oa.dao.DocumentDao;
import com.bdqnsxt.oa.exception.ServiceException;
import com.bdqnsxt.oa.model.Document;
import com.bdqnsxt.oa.model.DocumentCategory;
import com.bdqnsxt.oa.model.SystemRole;
import com.bdqnsxt.oa.model.User;
import com.bdqnsxt.oa.service.DocumentCategoryService;
import com.bdqnsxt.oa.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentCategoryServiceImpl implements DocumentCategoryService{

    @Autowired
    private DocumentCategoryDao documentCategoryDao;

    @Autowired
    private DocumentDao documentDao;
    @Autowired
    private UserUtils userUtils;

    @Transactional(readOnly = true)
    @Override
    public List<DocumentCategory> getRootCats() throws Exception {
        List<DocumentCategory> dcs =  documentCategoryDao.getRootCats();
        recursiveLoad(dcs);
        List<DocumentCategory> filted = filterCategoryByRole(dcs,userUtils.getLoggedUser());
        return filted;
    }

    @Transactional()
    @Override
    public void save(DocumentCategory documentCategory) throws Exception {
        documentCategoryDao.save(documentCategory);
    }

    @Transactional()
    @Override
    public void update(DocumentCategory documentCategory) throws Exception {
        documentCategoryDao.update(documentCategory);
    }

    @Transactional()
    @Override
    public void delete(DocumentCategory documentCategory) throws Exception {
        List<Document> docs = documentDao.getByCat(documentCategory.getId());
        if(docs.size()>0){
            throw new ServiceException("分类下还有文件，无法删除");
        }
        documentCategoryDao.delete(documentCategory);
    }

    private void recursiveLoad(List<DocumentCategory> dcs){
        if(dcs!=null){
            for(DocumentCategory dc:dcs){
                if(dc.getChildren()!=null&&dc.getChildren().size()==0){
                    continue;
                }else{
                    recursiveLoad(dc.getChildren());
                }
            }
        }
    }

    private List<DocumentCategory> filterCategoryByRole(List<DocumentCategory> documentCategories,User user) throws Exception{
        if(user.isAdmin()||user.isLeader()){
            return documentCategories;
        }else{
            List<DocumentCategory> filted = new ArrayList<>();
            List<SystemRole> roles = user.getRoles();
            if(roles==null||roles.size()==0||documentCategories==null||documentCategories.size()==0){
                return filted;
            }else{
                for(SystemRole role:roles){
                    for(DocumentCategory documentCategory:documentCategories){
                        if(role.getRoleName().equals(documentCategory.getName())){
                            filted.add(documentCategory);
                            break;
                        }
                    }
                }
                return filted;
            }
        }

    }
}
