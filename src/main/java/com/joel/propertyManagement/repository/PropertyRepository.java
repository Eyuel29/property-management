package com.joel.propertyManagement.repository;

import com.joel.propertyManagement.entity.Property;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PropertyRepository extends CrudRepository<Property, String> {
    @Query
    List<Property> findAllByUserId (String userId);
}
