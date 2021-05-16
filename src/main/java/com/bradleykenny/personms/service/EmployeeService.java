package com.bradleykenny.personms.service;

import com.bradleykenny.personms.dto.CreateEmployeeDto;
import com.bradleykenny.personms.entity.Employee;
import com.bradleykenny.personms.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {

    Employee employee;
    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(Employee employee, EmployeeRepository employeeRepository) {
        this.employee = employee;
        this.employeeRepository = employeeRepository;
    }

    public Employee getEmployeeById(String id) {
        Optional<Employee> opt = employeeRepository.findById(id);
        if (opt.isPresent()) {
            opt.get();
        } return null;
    }

    public String createEmployee(CreateEmployeeDto dto) {
        Employee emp = new Employee();
        String id = UUID.randomUUID().toString();
        emp.setEmployeeId(id);
        emp.setFirstName(dto.getFirstName());
        emp.setLastName(dto.getLastName());

        employeeRepository.save(emp);

        return String.format("%s: %s %s", id, dto.getFirstName(), dto.getLastName());
    }

}
