package com.bradleykenny.personms.service;

import com.bradleykenny.personms.entity.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    Employee employee;

    public EmployeeService(Employee employee) {
        this.employee = employee;
    }

    public String getFirstName() {
        return this.employee.getFirstName();
    }

    public String getLastName() {
        return this.employee.getLastName();
    }
}
