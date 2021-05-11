package com.bradleykenny.personms.service;

import com.bradleykenny.personms.dto.request.LoginRequest;
import com.bradleykenny.personms.entity.Employee;
import com.bradleykenny.personms.security.Encryption;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.*;

@Service
public class AuthService {

    Employee employee;
    Datastore datastore;

    @Autowired
    public AuthService(Employee employee, Datastore datastore) {
        this.employee = employee;
        this.datastore = datastore;
    }

    public String login(LoginRequest request) {
        String encPassword = Encryption.encrypt(request.getPassword());

        return null;
    }

}
