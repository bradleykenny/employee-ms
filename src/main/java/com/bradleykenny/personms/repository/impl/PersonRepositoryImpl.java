package com.bradleykenny.personms.repository.impl;

import com.bradleykenny.personms.entity.Person;
import com.bradleykenny.personms.repository.BasicRepository;
import com.bradleykenny.personms.repository.PersonRepository;
import org.mongodb.morphia.Datastore;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepositoryImpl extends BasicRepository<Person> implements PersonRepository {

    Datastore datastore;

    public PersonRepositoryImpl(Datastore datastore) {
        this.datastore = datastore;
    }

}
