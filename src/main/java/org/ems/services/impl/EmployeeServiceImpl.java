package org.ems.services.impl;

import org.ems.dao.EmployeeDao;
import org.ems.dao.RoleDao;
import org.ems.entities.Employee;
import org.ems.entities.Role;
import org.ems.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDAO;

    @Autowired
    private RoleDao roleDao;

    @Override
    public void saveEmployee(Employee employee) {
        employeeDAO.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeDAO.findById(id);
    }

    @Override
    public List<Role> getAllRoles() {
       System.out.println("rolesss ---"+roleDao.findAllRoles());
        List<Role> roles = roleDao.findAllRoles();
        System.out.println("Roles from DAO: " + roles); // Debug print

        return roleDao.findAllRoles();
    }


    @Override
    public boolean hasEditPermit(Employee e, String edit) {
        System.out.println("in editttt");
        System.out.println("emp"+e);
        return e.getRole().getPermissions().stream().anyMatch(permission -> permission.getPermission_type().equals(edit));
    }

    @Override
    public boolean hasDeletePermit(Employee e, String delete) {
        System.out.println("in deleteee");
        System.out.println("emp"+e);
        return e.getRole().getPermissions().stream().anyMatch(permission -> permission.getPermission_type().equals(delete));
    }

    @Override
    public List<Employee> getAllEmployees() {
        System.out.println("all employess"+employeeDAO.findAll());

        return employeeDAO.findAll();
    }

    @Override
    public void deleteEmployee(Long id) {
        System.out.println("deleteeee");
        Employee employee = employeeDAO.findById(id);
        if (employee != null) {
            employeeDAO.delete(employee);
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        System.out.println("updateeee");
        employeeDAO.save(employee);
    }
}
