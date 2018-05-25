package com.bdqnsxt.oa.dto;

import org.springframework.web.multipart.MultipartFile;

public class DocumentDto {
    private long id;
    private String name;
    private String description;
    private String[] catIds;
    private MultipartFile doc;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getCatIds() {
        return catIds;
    }

    public void setCatIds(String[] catIds) {
        this.catIds = catIds;
    }

    public MultipartFile getDoc() {
        return doc;
    }

    public void setDoc(MultipartFile doc) {
        this.doc = doc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
