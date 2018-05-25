package com.bdqnsxt.oa.dto;

import com.bdqnsxt.oa.model.Clazz;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class DepartmentDto {

    private long  id;
    private String description;
    private String name;
    private long parentId;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }
}
