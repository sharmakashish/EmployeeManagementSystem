// src/main/java/com/example/entities/Employee.java
package org.ems.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
    @Id
    private Long id;
    private String name;
    private int age;
    private String address;
    private String username;

    private String password;

    public String getPassword() {
        return password;
    }

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public Employee(Long id, String name, int age, String address, String username, String password) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.username = username;
        this.password = password;
    }
    public boolean isValidCredentials(String enteredUsername, String enteredPassword) {
        return this.username.equals(enteredUsername) && this.password.equals(enteredPassword);
    }
}
