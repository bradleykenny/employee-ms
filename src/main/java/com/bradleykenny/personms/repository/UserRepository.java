package com.bradleykenny.personms.repository;

import com.bradleykenny.personms.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

}
