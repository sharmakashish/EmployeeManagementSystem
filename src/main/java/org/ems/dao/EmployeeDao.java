package org.ems.dao;

import org.ems.entities.Employee;
import java.util.List;

public interface EmployeeDao {
    void save(Employee employee);
    Employee findById(Long id);
    List<Employee> findAll();

}
