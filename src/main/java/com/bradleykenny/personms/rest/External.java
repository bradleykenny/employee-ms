package com.bradleykenny.personms.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/external/employees")
public class External {

    @GetMapping
    public String getEmployees() {
        return "Hello, world!";
    }

}
