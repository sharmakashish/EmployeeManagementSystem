// src/main/java/com/example/pages/EmployeeById.java
package org.ems.pages;

import org.ems.entities.Employee;
import org.ems.services.EmployeeService;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.annotations.ActivationRequestParameter;

public class EmployeeById {
    @ActivationRequestParameter
    private Long id;

    @Property
    private Employee employee;

    @Inject
    private EmployeeService employeeService;

    void onActivate(Long id) {
        this.id = id;
        this.employee = employeeService.getEmployeeById(id);
    }
}
