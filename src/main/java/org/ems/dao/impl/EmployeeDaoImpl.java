package org.ems.dao.impl;

import org.ems.dao.EmployeeDao;
import org.ems.entities.Employee;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Employee employee) {
        sessionFactory.getCurrentSession().saveOrUpdate(employee);
    }

    @Override
    public Employee findById(Long id) {
        return sessionFactory.getCurrentSession().get(Employee.class, id);
    }
  // criteria Api for getting all values
    @Override
    public List<Employee> findAll() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Employee.class);
        return criteria.list();
    }


}
