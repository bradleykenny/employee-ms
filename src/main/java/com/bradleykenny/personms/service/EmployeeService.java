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

    /**
     * Finds an employee by their ID.
     * @param id the Employee's `_id`.
     * @return the Employee object if one matches the `id`, otherwise `null`.
     */
    public Employee getEmployeeById(String id) {
        Optional<Employee> opt = employeeRepository.findById(id);
        if (opt.isPresent()) {
            return opt.get();
        } return null;
    }

    /**
     * Creates a new Employee and then saves it in the DB.
     * @param dto the request DTO that will be used to base the new DB entry off of.
     * @return a string describing the created Employee entry.
     */
    public String createEmployee(CreateEmployeeDto dto) {
        Employee emp = new Employee();

        String id = UUID.randomUUID().toString();
        emp.setEmployeeId(id);
        emp.setFirstName(dto.getFirstName());
        emp.setLastName(dto.getLastName());

        employeeRepository.save(emp);

        return emp.toString();
    }

}
