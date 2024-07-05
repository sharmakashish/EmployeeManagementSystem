// src/main/java/com/example/services/EmployeeServiceImpl.java
package org.ems.services;

import org.ems.entities.Employee;
import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    void addEmployee(Employee employee);
    void saveEmployee(Employee employee);

}
