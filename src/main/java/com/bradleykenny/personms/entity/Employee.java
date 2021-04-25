package com.bradleykenny.personms.entity;

import java.util.Random;

public class Employee extends Person {
    private String employeeId;

    public Employee() {
        Random r = new Random();
        this.setEmployeeId(Integer.toString(r.nextInt(1000000)));
    }

    public Employee(String firstName, String lastName) {
        Random r = new Random();
        this.setEmployeeId(Integer.toString(r.nextInt(1000000)));
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}
