// src/main/java/org/ems/pages/NewEmployee.java
package org.ems.pages;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.ComponentResources;
import org.ems.entities.Employee;
import org.ems.services.EmployeeService;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.alerts.AlertManager;

public class NewEmployee {
    @Property
    private Employee employee = new Employee();

    @Inject
    private EmployeeService employeeService;

    @InjectComponent
    private Form employeeForm;

    @Inject
    private ComponentResources componentResources;

    @Inject
    private AlertManager alertManager;

    void onValidateFromEmployeeForm() {
        if (employee.getName() == null || employee.getName().isEmpty()) {
            employeeForm.recordError("Name is required.");
        }
        if (employee.getAge() <= 0) {
            employeeForm.recordError("Age must be a positive number.");
        }
        if (employee.getAddress() == null || employee.getAddress().isEmpty()) {
            employeeForm.recordError("Address is required.");
        }
    }

    Object onSuccessFromEmployeeForm() {
        employeeService.saveEmployee(employee);
        alertManager.info("Employee added successfully.");
        return EmployeeDetails.class;
    }
}
