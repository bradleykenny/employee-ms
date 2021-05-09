package com.bradleykenny.personms.service;

import com.bradleykenny.personms.dto.CreateEmployeeDto;
import com.bradleykenny.personms.entity.Employee;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmployeeService {

    @Autowired
    Datastore mongoDb;

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

    public String createEmployee(CreateEmployeeDto dto) {
        var mongo = mongoDb;

        Employee emp = new Employee();
        String id = UUID.randomUUID().toString();
        emp.setEmployeeId(id);
        emp.setFirstName(dto.getFirstName());
        emp.setLastName(dto.getLastName());

        mongo.save(emp);

        return String.format("%s: %s %s", id, dto.getFirstName(), dto.getLastName());
    }

}
