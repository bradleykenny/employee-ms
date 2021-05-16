package com.bradleykenny.personms.entity;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.util.Random;

@Entity
public class Employee extends Person {

    @Id String employeeId;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("employee={");
        sb.append("id=").append(employeeId);
        sb.append(", firstName=").append(firstName);
        sb.append(", lastName=").append(lastName);
        sb.append("}");

        return sb.toString();
    }
}
