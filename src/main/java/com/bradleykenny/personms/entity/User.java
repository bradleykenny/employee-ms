package com.bradleykenny.personms.entity;

import org.mongodb.morphia.annotations.Id;

import java.util.UUID;

public class User {

    @Id String userId;
    private String username;
    private String password;

    public User () {
        setUserId(UUID.randomUUID().toString());
    }

    public String getUserId() {
        return userId;
    }

    private void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", getUserId(), getUsername());
    }
}
