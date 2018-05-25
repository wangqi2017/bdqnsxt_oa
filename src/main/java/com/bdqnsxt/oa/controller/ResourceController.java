package com.bdqnsxt.oa.controller;

import com.bdqnsxt.oa.model.Resource;
import com.bdqnsxt.oa.model.User;
import com.bdqnsxt.oa.service.ResourceService;
import com.bdqnsxt.oa.utils.ResponseUtils;
import com.bdqnsxt.oa.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@SessionAttributes(types = {User.class})
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @RequestMapping(value = "/resource/{type}/{itemParentId}", method = RequestMethod.GET)
    public Map<String,Object> getByRole(@PathVariable("type") String type,@PathVariable("itemParentId") String itemParentId,
                                        @ModelAttribute(UserUtils.LOGIN_KEY) User user) throws Exception{
        List<Resource> res = new ArrayList<>();
        Collection<Resource> resources = null;
        if(user.isAdmin()){
            resources = resourceService.getAll();
        }else{
            resources = user.getResources();
        }
        for(Resource reso : resources){
            if("buttons".equals(type)){
                if(type.equals(reso.getType())&&itemParentId.equals(reso.getParentId())){
                    res.add(reso);
                }
            }
            if("button".equals(type)){
                if(type.equals(reso.getType())&&itemParentId.equals(reso.getItemId())){
                    res.add(reso);
                }
            }

        }
        return ResponseUtils.successExtJSProxyResponse(res,"");
    }
}
