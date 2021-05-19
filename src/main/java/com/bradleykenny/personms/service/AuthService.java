package com.bradleykenny.personms.service;

import com.bradleykenny.personms.dto.request.LoginRequest;
import com.bradleykenny.personms.entity.Employee;
import com.bradleykenny.personms.entity.User;
import com.bradleykenny.personms.security.EncryptionService;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

@Service
public class AuthService {

    Employee employee;
    Datastore datastore;
    EncryptionService encryptionService;

    @Autowired
    public AuthService(Employee employee, Datastore datastore, EncryptionService encryptionService) {
        this.employee = employee;
        this.datastore = datastore;
        this.encryptionService = encryptionService;
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

        datastore.save(user);

        return user.toString();
    }

}
