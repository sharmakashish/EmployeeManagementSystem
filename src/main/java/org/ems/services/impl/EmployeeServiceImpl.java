package org.ems.services.impl;

import org.ems.entities.Employee;
import org.ems.services.EmployeeService;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private List<Employee> employees = new ArrayList<>();

    public EmployeeServiceImpl() {
        // Initialize some sample data
        employees.add(new Employee(1L, "Kashish", 24, "Punjab"));
        employees.add(new Employee(2L, "Simran", 24, "Canada"));
        employees.add(new Employee(3L, "Dennis", 35, "America"));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                return employee;
            }
        }
        return null;  // Return null if no employee found with given id
    }

    @Override
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    @Override
    public void saveEmployee(Employee employee) {
        // Simulating database auto-increment id for simplicity
        employee.setId((long) (employees.size() + 1));
        employees.add(employee);
    }
}
