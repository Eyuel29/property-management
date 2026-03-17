package com.joel.projectManagement.repository;

import com.joel.projectManagement.entity.Property;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PropertyRepository extends CrudRepository<Property, String> {
    @Query
    List<Property> findAllByUserId (String userId);
}
