package org.ems.pages;

import org.apache.tapestry5.annotations.OnEvent;
import org.ems.entities.Employee;
import org.ems.services.EmployeeService;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import java.util.List;

public class EmployeeDetails {
    @Property
    private Employee employee;

    @Inject
    private EmployeeService employeeService;

    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }


    @OnEvent(component = "newEmployeeLink")
    Object onActionFromNewEmployeeLink() {
        return NewEmployee.class;
    }
}
