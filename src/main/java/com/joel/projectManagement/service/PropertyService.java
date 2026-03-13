package com.joel.projectManagement.service;

import com.joel.projectManagement.dto.PropertyDTO;
import java.util.List;

public interface PropertyService {
    List<PropertyDTO> getAllProperties();
    PropertyDTO getPropertyById(String propertyId);
    PropertyDTO createProperty(PropertyDTO propertyDTO);
    PropertyDTO updateProperty(String propertyId, PropertyDTO propertyDTO);
    void deletePropertyById(String propertyId);
}
