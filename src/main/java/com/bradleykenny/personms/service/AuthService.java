package com.bradleykenny.personms.service;

import com.bradleykenny.personms.dto.request.LoginRequest;
import com.bradleykenny.personms.entity.Employee;
import com.bradleykenny.personms.entity.User;
import com.bradleykenny.personms.security.Encryption;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

@Service
public class AuthService {

    Employee employee;
    Datastore datastore;

    @Value("${encryption.key}")
    private String encryptionKey;

    @Autowired
    public AuthService(Employee employee, Datastore datastore) {
        this.employee = employee;
        this.datastore = datastore;
    }

    public String login(LoginRequest request) throws GeneralSecurityException, UnsupportedEncodingException {
        byte[] encKeyInBytes = encryptionKey.getBytes();
        SecretKeySpec key = new SecretKeySpec(encKeyInBytes, "AES");
        String encPassword = Encryption.encrypt(request.getPassword(), key);

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(encPassword);
        datastore.save(user);

        return user.toString();
    }

}
