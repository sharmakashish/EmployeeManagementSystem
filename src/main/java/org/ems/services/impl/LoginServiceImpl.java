package org.ems.services.impl;

import org.ems.entities.Employee;
import org.ems.services.EmployeeService;
import org.ems.services.LoginService;

import javax.inject.Inject;
import java.util.List;

public class LoginServiceImpl implements LoginService {

    @Inject
    private EmployeeService employeeService;

    //    @Override
//    public boolean validateLogin(String username, String password) {
//        List<Employee> employeeList = employeeService.getAllEmployees();
//
//        // Check if there's any employee with matching username and password
//        return employeeList.stream()
//                .anyMatch(emp -> emp.getUsername().equals(username) && emp.getPassword().equals(password));
//    }
    @Override
    public boolean validateLogin(String username, String password) {
        List<Employee> employeeList = employeeService.getAllEmployees();
        System.out.println(employeeList);
        System.out.println("userrrrr" + username);
        System.out.println("passsss" + password);

        // Check if there's any employee with matching username and password
        for (Employee employee : employeeList) {
            if (employee.getUsername().equals(username) && employee.getPassword().equals(password)) {
                return true;
            }

        }
        return false;
    }
}


//    String dummyUsername = "testuser";
//    String dummyPassword = "password";

  //  return username.equals(dummyUsername) && password.equals(dummyPassword);




