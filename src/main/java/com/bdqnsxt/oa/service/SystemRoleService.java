package com.bdqnsxt.oa.service;

import com.bdqnsxt.oa.component.db.BaseQuery;
import com.bdqnsxt.oa.component.page.PageResult;
import com.bdqnsxt.oa.model.Menu;
import com.bdqnsxt.oa.model.RoleMenu;
import com.bdqnsxt.oa.model.SystemRole;
import com.bdqnsxt.oa.model.User;

import java.util.List;


public interface SystemRoleService {
    List<SystemRole> getAll() throws Exception;
    //获取总校区的Role
    List<SystemRole> getBasicRole() throws Exception;
    void save(SystemRole systemRole) throws Exception;
    void update(SystemRole systemRole) throws Exception;
    void delete(SystemRole systemRole) throws Exception;
    List<SystemRole> getByDepartment(long departmentId) throws Exception;
    Menu getTreeMenu(long roleId) throws Exception;
    void updateRoleMenus(RoleMenu rm) throws Exception;
    void copyRoleMenus(RoleMenu rm) throws Exception;

}
