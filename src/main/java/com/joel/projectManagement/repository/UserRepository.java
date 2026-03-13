package com.joel.projectManagement.repository;

import com.joel.projectManagement.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String> {
    @Query
    Optional<User> findByEmail(String email);
}
