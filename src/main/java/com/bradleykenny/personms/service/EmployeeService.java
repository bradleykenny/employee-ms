package com.bradleykenny.personms.service;

import com.bradleykenny.personms.dto.CreateEmployeeDto;
import com.bradleykenny.personms.entity.Employee;
import com.bradleykenny.personms.repository.EmployeeRepository;
import com.bradleykenny.personms.security.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {

    Employee employee;
    EmployeeRepository employeeRepository;
    EncryptionService encryptionService;

    @Autowired
    public EmployeeService(Employee employee, EmployeeRepository employeeRepository, EncryptionService encryptionService) {
        this.employee = employee;
        this.employeeRepository = employeeRepository;
        this.encryptionService = encryptionService;
    }

    /**
     * Finds an employee by their ID.
     * @param id the Employee's `_id`.
     * @return the Employee object if one matches the `id`, otherwise `null`.
     */
    public Employee getEmployeeById(String id) throws GeneralSecurityException {
        Optional<Employee> opt = employeeRepository.findById(id);
        if (opt.isPresent()) {
            opt.get().setPassword(encryptionService.decrypt(opt.get().getPassword()));
            return opt.get();
        } return null;
    }

    /**
     * Creates a new Employee and then saves it in the DB.
     * @param dto the request DTO that will be used to base the new DB entry off of.
     * @return a string describing the created Employee entry.
     */
    public String createEmployee(CreateEmployeeDto dto) throws GeneralSecurityException, UnsupportedEncodingException {
        Employee emp = new Employee();

        String id = UUID.randomUUID().toString();
        emp.setEmployeeId(id);
        emp.setFirstName(dto.getFirstName());
        emp.setLastName(dto.getLastName());
        emp.setPassword(encryptionService.encrypt(dto.getPassword()));

        employeeRepository.save(emp);

        return emp.toString();
    }

}
