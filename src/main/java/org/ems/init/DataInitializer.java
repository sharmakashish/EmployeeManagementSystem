package org.ems.init;

import org.ems.dao.EmployeeDao;
import org.ems.dao.PermissionDao;
import org.ems.dao.RoleDao;
import org.ems.entities.Employee;
import org.ems.entities.Permission;
import org.ems.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class DataInitializer {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PermissionDao permissionDao;

    @PostConstruct
    @Transactional
    public void init() {
        // Create permissions
        Permission editPermission = new Permission();
        editPermission.setPermission_type("edit");
        permissionDao.save(editPermission);

        Permission deletePermission = new Permission();
        deletePermission.setPermission_type("delete");
        permissionDao.save(deletePermission);

        // Create roles
        Role adminRole = new Role();
        adminRole.setRole_name("Admin");
        adminRole.setPermissions(List.of(editPermission, deletePermission));
        roleDao.save(adminRole);

        Role employeeRole = new Role();
        employeeRole.setRole_name("Employee");
        roleDao.save(employeeRole);

        Role hrRole = new Role();
        hrRole.setRole_name("HR");
        hrRole.setPermissions(List.of(editPermission));
        roleDao.save(hrRole);

        // Create employees
        Employee admin = new Employee();
        admin.setName("Admin");
        admin.setAge(30);
        admin.setAddress("Admin Address");
        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setRole(adminRole);
        employeeDao.save(admin);

        Employee employee = new Employee();
        employee.setName("Employee");
        employee.setAge(25);
        employee.setAddress("Employee Address");
        employee.setUsername("employee");
        employee.setPassword("employee");
        employee.setRole(employeeRole);
        employeeDao.save(employee);

        Employee hr = new Employee();
        hr.setName("HR");
        hr.setAge(28);
        hr.setAddress("HR Address");
        hr.setUsername("hr");
        hr.setPassword("hr");
        hr.setRole(hrRole);
        employeeDao.save(hr);
    }
}
