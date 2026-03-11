package com.joel.projectManagement.service;

import com.joel.projectManagement.dto.PropertyDTO;
import com.joel.projectManagement.entity.Property;

public interface PropertyService {
    Property createProperty(PropertyDTO propertyDTO);
}
