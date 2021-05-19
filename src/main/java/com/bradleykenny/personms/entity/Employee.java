package com.bradleykenny.personms.entity;

import com.bradleykenny.personms.security.EncryptionService;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Random;

@Entity
public class Employee extends Person {

    @Id String employeeId;
    private String password;

    @Autowired
    EncryptionService encryptionService;

    public Employee() {
        Random r = new Random();
        this.setEmployeeId(Integer.toString(r.nextInt(1000000)));
    }

    public Employee(String firstName, String lastName, String password)
    throws GeneralSecurityException, UnsupportedEncodingException {
        Random r = new Random();
        this.setEmployeeId(Integer.toString(r.nextInt(1000000)));
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setPassword(encryptionService.encrypt(password));
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
