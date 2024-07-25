package org.ems.pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.ems.entities.Employee;
import org.ems.services.LoginService;

public class Login {

    @Property
    private String username;

    @Property
    private String password;

    @Component
    private Form loginForm;

    @Property
    private boolean error;

    @Property
    private String errorMessage;

    @Inject
    private LoginService loginService;

    @Inject
    private HttpServletRequest request;

    void onValidateFromLoginForm() {
        // Validate login
        Employee employee = loginService.validateLogin(username, password);
        if (employee == null) {
            // Invalid login
            error = true;
            errorMessage = "Invalid username or password.";
            loginForm.recordError(errorMessage);
        } else {
            // Successful login: Store user in session
            HttpSession session = request.getSession(true);
            session.setAttribute("loggedInUser", employee);
            error = false; // Clear error state if login is successful
        }
    }

    Object onSuccessFromLoginForm() {
        if (!error) {
            return EmployeeDetails.class; // Redirect to the EmployeeDetails page upon successful login
        }
        return this; // Stay on the same page if there is an error
    }
}
