package com.bradleykenny.personms.rest.external;

import com.bradleykenny.personms.entity.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.GregorianCalendar;

@RestController
@RequestMapping("/external/employees")
public class EmployeeRest {

    @GetMapping
    public ResponseEntity<String> getEmployees() {
        return ResponseEntity.ok("Hello, world!");
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
