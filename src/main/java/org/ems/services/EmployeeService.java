package org.ems.services;

import org.ems.entities.Employee;
import org.ems.entities.Role;

import java.util.List;

public interface EmployeeService {
    void saveEmployee(Employee employee);
    Employee getEmployeeById(Long id);
    List<Employee> getAllEmployees();
    void deleteEmployee(Long id);
    void updateEmployee(Employee employee);
    public List<Role> getAllRoles();
    public boolean hasEditPermit(Employee e, String edit);

   public boolean hasDeletePermit(Employee e, String delete);



}
