package org.ems.services;

import org.ems.entities.Employee;

public interface LoginService {
    Employee validateLogin(String username , String password);
}

