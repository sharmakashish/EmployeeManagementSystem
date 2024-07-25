package org.ems.dao.impl;

import org.ems.dao.EmployeeDao;
import org.ems.entities.Employee;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
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
//        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Employee.class);
//        List<Employee> employees = criteria.list();
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Employee.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Employee> employees = criteria.list();


        // Print the list of employees
        System.out.println("Employees List: " + employees);
//        return employees.stream()
//                .distinct()
//                .collect(Collectors.toList());

        return employees;
    }

    @Override
    public void delete(Employee employee) {
        sessionFactory.getCurrentSession().delete(employee);
    }


}
