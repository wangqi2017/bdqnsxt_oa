package com.bdqnsxt.oa.dao;

import com.bdqnsxt.oa.model.SystemRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SystemRoleDao {
    SystemRole getById(long id) throws Exception;
    SystemRole getByIds(long id) throws Exception;
    void save(SystemRole systemRole) throws Exception;
    void update(SystemRole systemRole) throws Exception;
    void delete(SystemRole systemRole) throws Exception;
    List<SystemRole> getAll() throws  Exception;
    List<SystemRole> getByDepartment(long departmentId) throws Exception;
    List<SystemRole> getBasicRole() throws Exception;
    void saveRoleMenu(@Param("roleId") long roleId,@Param("menuIds") String[] menuIds,@Param("id") long id) throws Exception;
    void deleteRoleMenu(long roleId) throws Exception;
    String[] getVisibleMenusByRole(long roleId) throws Exception;

}
