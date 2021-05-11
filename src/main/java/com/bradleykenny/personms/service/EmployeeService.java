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
    Datastore datastore;

    @Autowired
    public EmployeeService(Employee employee, Datastore datastore) {
        this.employee = employee;
        this.datastore = datastore;
    }

    public Employee getEmployeeById(String id) {
        return datastore.find(Employee.class).field("_id").equal(id).get();
    }

    public String createEmployee(CreateEmployeeDto dto) {
        Employee emp = new Employee();
        String id = UUID.randomUUID().toString();
        emp.setEmployeeId(id);
        emp.setFirstName(dto.getFirstName());
        emp.setLastName(dto.getLastName());

        datastore.save(emp);

        return String.format("%s: %s %s", id, dto.getFirstName(), dto.getLastName());
    }

}
