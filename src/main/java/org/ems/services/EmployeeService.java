package org.ems.services;

import org.ems.entities.Employee;
import java.util.List;

public interface EmployeeService {
    void saveEmployee(Employee employee);
    Employee getEmployeeById(Long id);
    List<Employee> getAllEmployees();

}
