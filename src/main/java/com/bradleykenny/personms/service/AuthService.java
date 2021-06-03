package com.bradleykenny.personms.service;

import com.bradleykenny.personms.dto.request.LoginRequest;
import com.bradleykenny.personms.dto.request.RegisterUserRequest;
import com.bradleykenny.personms.entity.Employee;
import com.bradleykenny.personms.entity.User;
import com.bradleykenny.personms.repository.UserRepository;
import com.bradleykenny.personms.security.EncryptionService;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

@Service
public class AuthService {

    private Employee employee;
    private UserRepository userRepository;
    private EncryptionService encryptionService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public AuthService(Employee employee, UserRepository userRepository, EncryptionService encryptionService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.employee = employee;
        this.userRepository = userRepository;
        this.encryptionService = encryptionService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    /**
     * Takes a login request, compares the credentials and returns a response indicating
     * if the user should be logged in.
     * @param request
     * @return
     * @throws GeneralSecurityException
     * @throws UnsupportedEncodingException
     */
    public String login(LoginRequest request) throws GeneralSecurityException, UnsupportedEncodingException {
        User user = new User();
        user.setUsername(request.getUsername());

        String encPassword = encryptionService.encrypt(request.getPassword());
        user.setPassword(encPassword);

        userRepository.save(user);

        return user.toString();
    }

    public boolean register (RegisterUserRequest request) {
        String password = bCryptPasswordEncoder.encode(request.getPassword());
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(password);

        userRepository.save(user);
        return true;
    }

}
