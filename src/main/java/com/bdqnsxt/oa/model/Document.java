package com.bdqnsxt.oa.model;

import java.util.LinkedList;
import java.util.List;

public class Document extends AbstractModel{
    private String name;
    private String description;
    private String location;
    private List<DocumentCategory> documentCategories;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<DocumentCategory> getDocumentCategories() {
        return documentCategories;
    }

    public void setDocumentCategories(List<DocumentCategory> documentCategories) {
        this.documentCategories = documentCategories;
    }

    @Override
    public String getDisplayClassName() {
        return "模板";
    }

    @Override
    public String getDisplayName() {
        return getName();
    }

    public Document(){}
    public Document(long id){
        this.id = id;
    }
    public Document(long id,String name){
        this.id = id;
        this.name = name;
    }

    public Document(String name,String description,String location,String[] catIds){
        this.name = name;
        this.description = description;
        this.location = location;
        if(catIds!=null&&catIds.length>0){
            documentCategories = new LinkedList<>();
            for(String catId:catIds){
                DocumentCategory dc = new DocumentCategory();
                dc.setId(Long.valueOf(catId));
                documentCategories.add(dc);
            }
        }
    }
}
