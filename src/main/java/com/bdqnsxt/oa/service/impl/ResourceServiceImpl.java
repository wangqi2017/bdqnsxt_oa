package com.bdqnsxt.oa.service.impl;

import com.bdqnsxt.oa.dao.ResourceDao;
import com.bdqnsxt.oa.model.Resource;
import com.bdqnsxt.oa.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService{
    @Autowired
    private ResourceDao resourceDao;

    @Override
    public List<Resource> getAll() throws Exception {
        return resourceDao.getAll();
    }
}
