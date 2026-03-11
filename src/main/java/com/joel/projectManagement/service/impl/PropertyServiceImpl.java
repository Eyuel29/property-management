package com.joel.projectManagement.service.impl;

import com.joel.projectManagement.converter.PropertyConverter;
import com.joel.projectManagement.dto.PropertyDTO;
import com.joel.projectManagement.entity.Property;
import com.joel.projectManagement.repository.PropertyRepository;
import com.joel.projectManagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyConverter propertyConverter;

    @Override
    public PropertyDTO createProperty(PropertyDTO propertyDTO) {
        Property newProperty = propertyConverter.convertDTOToEntity(propertyDTO);
        Property result = propertyRepository.save(newProperty);
        return propertyConverter.convertEntityToDTO(result);
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        return StreamSupport.stream(propertyRepository.findAll().spliterator(), false).map((Property property) -> propertyConverter.convertEntityToDTO(property)).toList();
    }

    @Override
    public PropertyDTO getPropertyById(String propertyId) {
        Optional<Property> result = propertyRepository.findById(propertyId);
        return result.map(property -> propertyConverter.convertEntityToDTO(property)).orElse(null);
    }

    @Override
    public PropertyDTO updateProperty(String propertyId, PropertyDTO propertyDTO) {

        Optional<Property> optionalResult = propertyRepository.findById(propertyId);
        if (optionalResult.isEmpty()) return null;
        Property result = optionalResult.get();

        result.setTitle(propertyDTO.getTitle());
        result.setDescription(propertyDTO.getDescription());
        result.setPrice(propertyDTO.getPrice());
        result.setAddress(propertyDTO.getAddress());

        result = propertyRepository.save(result);

        return propertyConverter.convertEntityToDTO(result);
    }

    @Override
    public void deletePropertyById(String propertyId) {
        propertyRepository.deleteById(propertyId);
    }
}
