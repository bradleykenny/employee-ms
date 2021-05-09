package com.bradleykenny.personms.service;

import com.bradleykenny.personms.dto.CreateEmployeeDto;
import com.bradleykenny.personms.entity.Employee;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    Employee employee;
    Datastore mongoDb;

    @Autowired
    public EmployeeService(Employee employee, Datastore mongoDb) {
        this.employee = employee;
        this.mongoDb = mongoDb;
    }

    public Employee getEmployees(String id) {
        return mongoDb.find(Employee.class).field("employeeId").equal(id).get();
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
