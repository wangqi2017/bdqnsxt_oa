package com.bdqnsxt.oa.controller;




import com.bdqnsxt.oa.dto.SystemRoleDto;
import com.bdqnsxt.oa.exception.ClazzExistException;
import com.bdqnsxt.oa.exception.ServiceException;
import com.bdqnsxt.oa.model.Menu;
import com.bdqnsxt.oa.model.RoleMenu;
import com.bdqnsxt.oa.model.SystemRole;
import com.bdqnsxt.oa.service.SystemRoleService;
import com.bdqnsxt.oa.utils.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SystemRoleController {

    private Logger logger = LoggerFactory.getLogger(SystemRoleController.class);

    @Autowired
    private SystemRoleService systemRoleService;

    @RequestMapping(value = "/allroles", method = RequestMethod.GET)
    public Map<String, Object> getAll() throws Exception {
        List<SystemRole> systemRoles = systemRoleService.getAll();
        return ResponseUtils.successExtJSProxyResponse(systemRoles,"");
    }

    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    public Map<String, Object> getByDepartment(long departmentId) throws Exception {
        List<SystemRole> systemRoles = systemRoleService.getByDepartment(departmentId);
        return ResponseUtils.successExtJSProxyResponse(systemRoles,"");
    }

    @RequestMapping(value = "/roles", method = RequestMethod.POST, consumes="application/json;charset=utf-8")
    public Map<String, Object> save(@RequestBody SystemRoleDto dto) throws Exception {
        try {
            systemRoleService.save(new SystemRole().getSystemRoleCopy(dto));
            return ResponseUtils.successExtJSProxyResponse("岗位保存成功");
        } catch (ClazzExistException e) {
            return ResponseUtils.failureExtJSProxyResponse(e.getMessage());
        }
    }

    @RequestMapping(value = "/roles", method = RequestMethod.PUT, consumes="application/json;charset=utf-8")
    public Map<String, Object> update(@RequestBody SystemRoleDto dto) throws Exception {
        systemRoleService.update(new SystemRole().getSystemRoleCopy(dto));
        return ResponseUtils.successExtJSProxyResponse("岗位修改成功");
    }

    @RequestMapping(value = "/roles", method = RequestMethod.DELETE, consumes="application/json;charset=utf-8")
    public Map<String, Object> delete(@RequestBody SystemRoleDto dto) throws Exception {
        systemRoleService.delete(new SystemRole().getSystemRoleCopy(dto));
        return ResponseUtils.successExtJSProxyResponse("岗位删除成功");
    }

    @RequestMapping(value = "/roles/permission/{roleId}", method = RequestMethod.GET)
    public Map<String, Object> getRolePermission(@PathVariable("roleId") long roleId) throws Exception {
        try {
            Menu menu = systemRoleService.getTreeMenu(roleId);
            Map<String, Object> menuMap = new HashMap<String, Object>();
            menuMap.put("menus",menu);
            return ResponseUtils.successExtJSProxyResponse(menuMap,"");
        }catch (ServiceException e){
            return ResponseUtils.failureExtJSProxyResponse(e.getMessage());
        }
    }

    @RequestMapping(value = "/roles/permission/{roleId}", method = RequestMethod.POST)
    public Map<String, Object> saveRolePermission(@PathVariable("roleId") long roleId,String[] roleMenuIds) throws Exception {
            try{
                RoleMenu rm = new RoleMenu(roleId,roleMenuIds);
                systemRoleService.updateRoleMenus(rm);
                return ResponseUtils.successExtJSProxyResponse("权限保存成功");
            }catch(Exception e){
                return ResponseUtils.failureExtJSProxyResponse("权限保存失败");
            }
    }

    @RequestMapping(value = "/roles/copypermission/{roleId}", method = RequestMethod.POST)
    public Map<String, Object> copyRolePermission(@PathVariable("roleId") long roleId,long copiedRoleId) throws Exception {
        try{
            RoleMenu rm = new RoleMenu(roleId,copiedRoleId);
            systemRoleService.copyRoleMenus(rm);
            return ResponseUtils.successExtJSProxyResponse("岗位权限复制成功");
        }catch(Exception e){
            return ResponseUtils.failureExtJSProxyResponse("岗位权限复制失败");
        }
    }
}
