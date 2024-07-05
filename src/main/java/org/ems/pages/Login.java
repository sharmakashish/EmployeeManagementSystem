package org.ems.pages;

import java.util.HashMap;
import java.util.Map;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;

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

    private static final Map<String, String> USERS = new HashMap<>();

    static {
        USERS.put("user1", "password1");
        USERS.put("user2", "password2");
    }

    void onValidateFromLoginForm() {
        if (!USERS.containsKey(username) || !USERS.get(username).equals(password)) {
            error = true;
            errorMessage = "Invalid username or password.";
            loginForm.recordError("Invalid username or password.");
        }
    }

    Object onSuccessFromLoginForm() {
        if (!error) {
            return EmployeeDetails.class; // Redirect to home page or any other page upon successful login
        }
        return this; // Stay on the same page if there is an error
    }
}
