package com.bdqnsxt.oa.service.impl;



import com.bdqnsxt.oa.dao.SystemRoleDao;
import com.bdqnsxt.oa.exception.ServiceException;
import com.bdqnsxt.oa.model.Menu;
import com.bdqnsxt.oa.model.RoleMenu;
import com.bdqnsxt.oa.model.SystemRole;
import com.bdqnsxt.oa.service.SystemRoleService;
import com.bdqnsxt.oa.utils.MenuUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SystemRoleServiceImpl implements SystemRoleService {


    @Autowired
    private SystemRoleDao systemRoleDao;

    @Transactional(readOnly = true)
    @Override
    public List<SystemRole> getAll() throws Exception {
        return systemRoleDao.getAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<SystemRole> getByDepartment(long departmentId) throws Exception {
        return systemRoleDao.getByDepartment(departmentId);
    }

    @Transactional()
    @Override
    public void save(SystemRole systemRole) throws Exception {
        systemRoleDao.save(systemRole);
    }

    @Transactional()
    @Override
    public void update(SystemRole systemRole) throws Exception {
        systemRoleDao.update(systemRole);
    }

    @Transactional()
    @Override
    public void delete(SystemRole systemRole) throws Exception {
        systemRoleDao.delete(systemRole);
    }

    @Transactional(readOnly = true)
    @Override
    public Menu getTreeMenu(long roleId) throws Exception {
        SystemRole systemRole = systemRoleDao.getByIds(roleId);
        if(systemRole==null){
            throw new ServiceException("角色不存在");
        }
        List<String> visibleMenus = systemRole.getMenus();
        List<Menu> menus = MenuUtils.getMenuList(visibleMenus);
        Menu menu = new Menu("root", ".", false);
        menu.setChildren(menus);
        return menu;
    }

    @Transactional()
    @Override
    public void updateRoleMenus(RoleMenu rm) throws Exception {
        if(rm!=null && rm.getRoleId() >0 ){
            systemRoleDao.deleteRoleMenu(rm.getRoleId());
        }
        if(rm!=null&& rm.getMenuIds()!=null&&rm.getMenuIds().length>0){
            systemRoleDao.saveRoleMenu(rm.getRoleId(),rm.getMenuIds(),0);
        }

    }

    @Transactional()
    @Override
    public void copyRoleMenus(RoleMenu rm) throws Exception {
        String[] visibleMenus = systemRoleDao.getVisibleMenusByRole(rm.getCopiedRoleId());
        systemRoleDao.deleteRoleMenu(rm.getRoleId());
        systemRoleDao.saveRoleMenu(rm.getRoleId(),visibleMenus,0);
    }

    @Transactional(readOnly = true)
    @Override
    public List<SystemRole> getBasicRole() throws Exception {
        return systemRoleDao.getBasicRole();
    }
}
