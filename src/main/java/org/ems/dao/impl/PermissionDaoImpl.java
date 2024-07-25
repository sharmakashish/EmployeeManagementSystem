package org.ems.dao.impl;

import org.ems.dao.PermissionDao;
import org.ems.entities.Permission;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Repository
public class PermissionDaoImpl implements PermissionDao {

    @Autowired
    private  SessionFactory sessionFactory;


    @Override
    public List<Permission> findAllPermissions() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Permission.class);
        List<Permission> list = criteria.list();
        System.out.println("listttt"+list);
        return criteria.list();
        }
        }

