package org.ems.services.impl;

import org.ems.services.EmployeeService;
import org.ems.dao.EmployeeDao;
import org.ems.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDAO;

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        employeeDAO.save(employee);
    }

    @Override
    @Transactional
    public Employee getEmployeeById(Long id) {
        return employeeDAO.findById(id);
    }

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDAO.findAll();
    }


    }

