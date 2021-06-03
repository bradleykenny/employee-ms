package com.bradleykenny.personms.repository;

import com.bradleykenny.personms.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

}
