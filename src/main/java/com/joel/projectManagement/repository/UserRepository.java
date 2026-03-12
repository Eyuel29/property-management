package com.joel.projectManagement.repository;

import com.joel.projectManagement.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

}
