package org.ems.dao.impl;

import org.ems.dao.PermissionDao;
import org.ems.dao.RoleDao;
import org.ems.entities.Permission;
import org.ems.entities.Role;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Repository
@Transactional
public class RoleDaoImpl implements RoleDao {
    @Autowired
    private SessionFactory sessionFactory;

    private PermissionDao permissionDao;


    @Override
    public List<Role> findAllRoles() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Role.class);
        List<Role> role = criteria.list();
        System.out.println("roleeeee"+role);
        return criteria.list();
        }

    @Override
    public List<Permission> findPermissionsByRole(Role role) {
        List<Role> roles = findAllRoles();
        for (Role r : roles) {
            if (r.getId().equals(role.getId())) {
                System.out.println("Permissions--> " + r.getRole_name() + ": " + r.getPermissions());
                return r.getPermissions();
            }
        }
        return List.of();
    }



}