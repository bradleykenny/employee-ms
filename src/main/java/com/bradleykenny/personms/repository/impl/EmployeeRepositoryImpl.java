package com.bradleykenny.personms.repository.impl;

import com.bradleykenny.personms.entity.Employee;
import com.bradleykenny.personms.repository.BasicRepository;
import com.bradleykenny.personms.repository.EmployeeRepository;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepositoryImpl extends BasicRepository<Employee> implements EmployeeRepository {

    Datastore datastore;

    @Autowired
    public EmployeeRepositoryImpl(Datastore datastore) {
        this.datastore = datastore;
    }

}
