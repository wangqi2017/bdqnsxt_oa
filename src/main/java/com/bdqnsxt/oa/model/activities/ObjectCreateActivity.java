package com.bdqnsxt.oa.model.activities;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class ObjectCreateActivity extends AbstractActivity {

    @Override
    public String getAction() {
        return "创建";
    }

    @Override
    public String getAtype() {
        return "ObjectCreate";
    }
}
