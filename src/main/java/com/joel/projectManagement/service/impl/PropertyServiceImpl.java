package com.joel.projectManagement.service.impl;

import com.joel.projectManagement.converter.PropertyConverter;
import com.joel.projectManagement.dto.PropertyDTO;
import com.joel.projectManagement.entity.Property;
import com.joel.projectManagement.repository.PropertyRepository;
import com.joel.projectManagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyConverter propertyConverter;

    @Override
    public Property createProperty(PropertyDTO propertyDTO) {
        Property newProperty = propertyConverter.convertDTOToEntity(propertyDTO);
        Property returned = propertyRepository.save(newProperty);
        return returned;
    }
}
