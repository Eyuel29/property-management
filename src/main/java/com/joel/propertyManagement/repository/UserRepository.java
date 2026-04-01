package com.joel.propertyManagement.repository;

import com.joel.propertyManagement.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String> {
    @Query
    Iterable<User> findAllByEmail(String email);

    @Query
    Optional<User> findFirstByEmail(String email);
}
