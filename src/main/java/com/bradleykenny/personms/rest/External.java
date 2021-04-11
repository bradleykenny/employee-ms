package com.bradleykenny.personms.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/external/employees")
public class External {

    @GetMapping
    public ResponseEntity<String> getEmployees() {
        return ResponseEntity.ok("Hello, world!");
    }

    @PostMapping
    public ResponseEntity<Void> postEmployees() {
        return ResponseEntity.status(200).build();
    }

    @GetMapping("/all")
    public ResponseEntity<String> getAllEmployees() {
        return ResponseEntity.ok("Hello, all!");
    }

}
