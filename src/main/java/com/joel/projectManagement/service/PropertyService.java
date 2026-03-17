package com.joel.projectManagement.service;

import com.joel.projectManagement.dto.PropertyDTO;
import com.joel.projectManagement.exception.PMSException;

import java.util.List;

public interface PropertyService {
    List<PropertyDTO> getAllProperties();
    List<PropertyDTO> getAllUserProperties(String userId);
    PropertyDTO getPropertyById(String propertyId);
    PropertyDTO saveProperty(PropertyDTO propertyDTO) throws PMSException;
    PropertyDTO updateProperty(String propertyId, PropertyDTO propertyDTO);
    void deletePropertyById(String propertyId);
}
