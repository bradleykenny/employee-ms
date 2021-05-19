package com.bradleykenny.personms.repository.impl;

import com.bradleykenny.personms.entity.User;
import com.bradleykenny.personms.repository.MongoRepository;
import com.bradleykenny.personms.repository.UserRepository;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl extends MongoRepository<User> implements UserRepository {

    Datastore datastore;

    @Autowired
    public UserRepositoryImpl(Datastore datastore) {
        this.datastore = datastore;
    }

}
