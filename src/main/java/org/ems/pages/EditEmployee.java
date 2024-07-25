package org.ems.pages;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.ems.entities.Employee;
import org.ems.services.EmployeeService;

public class EditEmployee {

    @Inject
    private EmployeeService employeeService;

    @Property
    private Employee employee;

    public void setupRender(Long id) {
        employee = employeeService.getEmployeeById(id);
    }

    void onSuccessFromEditForm() {
        employeeService.updateEmployee(employee);
    }
}
