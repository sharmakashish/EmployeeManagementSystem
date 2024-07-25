package org.ems.dao;

import org.ems.entities.Employee;
import org.ems.entities.Permission;
import org.ems.entities.Role;

import java.util.List;

public interface RoleDao {
   List<Role> findAllRoles();
   List<Permission> findPermissionsByRole(Role role);




}
