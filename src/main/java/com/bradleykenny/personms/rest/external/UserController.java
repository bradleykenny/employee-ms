package com.bradleykenny.personms.rest.external;

import com.bradleykenny.personms.dto.CreateEmployeeDto;
import com.bradleykenny.personms.entity.Employee;
import com.bradleykenny.personms.entity.User;
import com.bradleykenny.personms.repository.UserRepository;
import com.bradleykenny.personms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

@RestController
@RequestMapping("/api/v1/external/user")
public class UserController {

    UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getEmployee(@PathVariable("id") String userId) {
        return ResponseEntity.ok(userRepository.findById(userId).get());
    }

}
