package com.bradleykenny.personms.rest.external;

import com.bradleykenny.personms.dto.request.LoginRequest;
import com.bradleykenny.personms.entity.Employee;
import com.bradleykenny.personms.entity.User;
import com.bradleykenny.personms.service.AuthService;
import com.bradleykenny.personms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

@RestController
@RequestMapping("/api/v1/external/auth")
public class AuthController {

    AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> getEmployee(@RequestBody LoginRequest request) throws GeneralSecurityException, UnsupportedEncodingException {
        return ResponseEntity.ok(authService.login(request));
    }

}
