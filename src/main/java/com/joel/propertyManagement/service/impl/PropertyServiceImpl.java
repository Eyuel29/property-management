package com.joel.propertyManagement.service.impl;

import com.joel.propertyManagement.dto.PropertyDTO;
import com.joel.propertyManagement.entity.Property;
import com.joel.propertyManagement.entity.User;
import com.joel.propertyManagement.exception.PMSError;
import com.joel.propertyManagement.exception.PMSException;
import com.joel.propertyManagement.mapper.PropertyMapper;
import com.joel.propertyManagement.repository.PropertyRepository;
import com.joel.propertyManagement.repository.UserRepository;
import com.joel.propertyManagement.service.PropertyService;
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
    private PropertyMapper propertyMapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) throws PMSException {

        Property newProperty = propertyMapper.toEntity(propertyDTO);
        Optional<User> ownerOpt = userRepository.findById(propertyDTO.getUserId());

        if (ownerOpt.isPresent()){
            newProperty.setUser(ownerOpt.get());
        }else{
            List<PMSError> allErrors = List.of(new PMSError("USER_ID_NOT_FOUND", "There is no user with the specified id!"));
            throw new PMSException(allErrors);
        }

        Property result = propertyRepository.save(newProperty);
        return propertyMapper.toDTO(result);
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        return StreamSupport.stream(propertyRepository.findAll().spliterator(), false).map((Property property) -> propertyMapper.toDTO(property)).toList();
    }

    @Override
    public List<PropertyDTO> getAllUserProperties(String userId) {
        List<Property> allUserProperties = propertyRepository.findAllByUserId(userId);
        return StreamSupport
            .stream(allUserProperties.spliterator(), false)
            .map(property -> propertyMapper.toDTO(property))
            .toList();
    }

    @Override
    public PropertyDTO getPropertyById(String propertyId) {
        Optional<Property> result = propertyRepository.findById(propertyId);
        return result.map(property -> propertyMapper.toDTO(property)).orElse(null);
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

        return propertyMapper.toDTO(result);
    }

    @Override
    public void deletePropertyById(String propertyId) {
        propertyRepository.deleteById(propertyId);
    }
}
