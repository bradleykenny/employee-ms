package com.bradleykenny.personms.rest.external;

import com.bradleykenny.personms.dto.CreateEmployeeDto;
import com.bradleykenny.personms.entity.Employee;
import com.bradleykenny.personms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/external/employees")
public class EmployeeController {

    EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") String employeeId) {
        return ResponseEntity.ok(employeeService.getEmployeeById(employeeId));
    }

    @PostMapping
    public ResponseEntity<String> postEmployees(@RequestBody CreateEmployeeDto createEmployeeDto) {
        return ResponseEntity.ok(employeeService.createEmployee(createEmployeeDto));
    }

}
