package com.bdqnsxt.oa.model;

import com.bdqnsxt.oa.dto.DocumentCategoryDto;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.beans.BeanUtils;

import java.util.List;

//避免序列化时，陷入死循环
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class DocumentCategory extends AbstractModel{

    private String name;
    @JsonProperty("docCats")
    private List<DocumentCategory> children;
    @JsonIgnore
    private DocumentCategory parent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DocumentCategory> getChildren() {
        return children;
    }

    public void setChildren(List<DocumentCategory> children) {
        this.children = children;
    }

    public DocumentCategory getParent() {
        return parent;
    }

    public void setParent(DocumentCategory parent) {
        this.parent = parent;
    }

    @Override
    public String getDisplayClassName() {
        return "模板分类";
    }

    @Override
    public String getDisplayName() {
        return getName();
    }

    public Long getParentId(){
        if(parent!=null){
            return parent.getId();
        }
        return null;
    }

    public boolean getExpanded(){
        return false;
    }

    public boolean isLeaf(){
        /*
        if(children!=null&&children.size()>0){
            return false;
        }else if(getParentId()==null){
            return false;
        }else{
            return true;
        }
        */
        return false;
    }

    public boolean getChecked(){
        return false;
    }

    public DocumentCategory getDocumentCategoryCopy(DocumentCategoryDto dto){
        BeanUtils.copyProperties(dto,this);
        if(dto.getParentId()>0){
            DocumentCategory parent = new DocumentCategory();
            parent.setId(dto.getParentId());
            this.parent = parent;
        }
        return this;
    }
}
