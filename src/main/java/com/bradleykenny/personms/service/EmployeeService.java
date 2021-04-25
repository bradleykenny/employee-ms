package com.bradleykenny.personms.service;

import com.bradleykenny.personms.database.MongoDB;
import com.bradleykenny.personms.entity.Employee;
import org.mongodb.morphia.query.Query;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    Employee employee;
    MongoDB mongoDB;

    public EmployeeService(Employee employee, MongoDB mongoDB) {
        this.employee = employee;
        this.mongoDB = mongoDB;
    }

    public String getFirstName() {
        return this.employee.getFirstName();
    }

    public String getLastName() {
        return this.employee.getLastName();
    }

    public String setFirstName(String name) {
        var test = mongoDB.getDatabase();
        Employee emp = new Employee();
        emp.setFirstName(name);
        test.save(emp);

        return this.employee.getFirstName();
    }

}
