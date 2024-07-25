package org.ems.pages;

import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.http.services.Request;
import org.apache.tapestry5.http.services.Response;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.annotations.InjectService;
import org.ems.entities.Employee;
import org.ems.services.EmployeeService;
import org.ems.services.LoginService;

import java.util.List;

public class EmployeeDetails {
    @Property
    private Employee employee;

    @Property
    @SessionState
    private Employee currentEmployee;

    @Inject
    private EmployeeService employeeService;

    @InjectPage
    private NewEmployee newEmployeePage;

    @Inject
    private Request request;

    @Inject
    private Response response;

    @InjectService("LoginService")
    private LoginService loginService;


    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }

    public Employee getEmployeeById(Long id) {
        return employeeService.getEmployeeById(id);
    }

    public String getRole() {
        if (employee != null && employee.getRole() != null) {
            return employee.getRole().getRole_name();
        }
        return "No Role!";
    }

    @OnEvent(value = "deleteEmployee")
    void deleteEmployee(Long employeeId) {
        if (employeeId != null) {
            employeeService.deleteEmployee(employeeId);
        }
    }

    public boolean isCanEdit() {
        System.out.println("Can Edit called---");
        System.out.println(employeeService.hasEditPermit(currentEmployee,"edit"));
        return employeeService.hasEditPermit(currentEmployee, "edit");
    }


    public boolean isCanDelete() {
        System.out.println("Can Delete called---");
        return employeeService.hasDeletePermit(currentEmployee, "DELETE");
    }

    public boolean isLoggedIn() {
        return currentEmployee != null;
    }

    @OnEvent(component = "newEmployeeLink")
    Object onActionFromNewEmployeeLink() {
        return newEmployeePage;
    }

}





