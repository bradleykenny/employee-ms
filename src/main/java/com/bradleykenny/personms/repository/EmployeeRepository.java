package com.bradleykenny.personms.repository;

import com.bradleykenny.personms.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, String> {

}
