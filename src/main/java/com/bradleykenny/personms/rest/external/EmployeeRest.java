package com.bradleykenny.personms.rest.external;

import com.bradleykenny.personms.entity.Employee;
import com.bradleykenny.personms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.GregorianCalendar;

@RestController
@RequestMapping("/external/employees")
public class EmployeeRest {

    EmployeeService employeeService;

    @Autowired
    public EmployeeRest (EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/firstName")
    public ResponseEntity<String> getEmployeeFirstName() {
        return ResponseEntity.ok(employeeService.getFirstName());
    }

    @GetMapping("/lastName")
    public ResponseEntity<String> getEmployeeLastName() {
        return ResponseEntity.ok(employeeService.getLastName());
    }

    @PostMapping
    public ResponseEntity<Void> postEmployees() {
        return ResponseEntity.status(200).build();
    }

    @GetMapping("/me")
    public ResponseEntity<Employee> getAllEmployees() {
        Employee employee = new Employee();
        employee.setFirstName("Brad");
        employee.setLastName("Kenny");
        employee.setDateOfBirth(new GregorianCalendar(1998, 3, 28).getTime());

        return ResponseEntity.ok(employee);
    }

}
