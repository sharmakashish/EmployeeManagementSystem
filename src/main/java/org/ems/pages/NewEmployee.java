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
    private Long id;

    @Property
    private Employee employee = new Employee();

    @Inject
    private EmployeeService employeeService;

    @InjectComponent
    private Form employeeForm;

    @Inject
    private AlertManager alertManager;

    void onValidateFromEmployeeForm() {
        // Validate ID
        if (id == null || id <= 0) {
            employeeForm.recordError("ID must be a positive number.");
        } else {
            try {
                // Check if the ID is unique
                for (Employee existingEmployee : employeeService.getAllEmployees()) {
                    if (existingEmployee.getId().equals(id)) {
                        employeeForm.recordError("Employee ID must be unique.");
                        break;
                    }
                }
            } catch (Exception e) {
                employeeForm.recordError("Error checking unique ID: " + e.getMessage());
            }
        }

        // Validate name
        if (employee.getName() == null || employee.getName().isEmpty()) {
            employeeForm.recordError("Name is required.");
        }

        // Validate age
        if (employee.getAge() <= 0) {
            employeeForm.recordError("Age must be a positive number.");
        }

        // Validate address
        if (employee.getAddress() == null || employee.getAddress().isEmpty()) {
            employeeForm.recordError("Address is required.");
        }
    }

    Object onSuccessFromEmployeeForm() {
        try {
            employee.setId(id);
            employeeService.saveEmployee(employee);
            alertManager.info("Employee added successfully.");
            return EmployeeDetails.class;
        } catch (IllegalArgumentException e) {
            employeeForm.recordError(e.getMessage());
            return this;
        }
    }
}
