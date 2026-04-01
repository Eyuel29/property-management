package com.joel.propertyManagement.service.impl;

import com.joel.propertyManagement.dto.UserDTO;
import com.joel.propertyManagement.entity.User;
import com.joel.propertyManagement.exception.PMSError;
import com.joel.propertyManagement.exception.PMSException;
import com.joel.propertyManagement.mapper.UserMapper;
import com.joel.propertyManagement.repository.UserRepository;
import com.joel.propertyManagement.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO signIn(String email, String password) throws PMSException {
        Optional<User> result = userRepository.findFirstByEmail(email);

        if (!result.isPresent()) {
            List<PMSError> allErrors = List.of(new PMSError("INVALID_CREDENTIALS", "Invalid email or password"));
            throw new PMSException(allErrors);
        };

        if (!result.get().getPassword().equals(password)) {
            List<PMSError> allErrors = List.of(new PMSError("INVALID_CREDENTIALS", "Invalid email or password"));
            throw new PMSException(allErrors);
        }

        return userMapper.toDTO(result.get());
    }

    @Override
    public UserDTO signUp(UserDTO userDTO) throws PMSException {
        Optional<User> existingUser = userRepository.findFirstByEmail(userDTO.getEmail());

        if (existingUser.isPresent()) {
            List<PMSError> allErrors = List.of(new PMSError("DUPLICATE_USER", "User with this email has already signed up!"));
            throw new PMSException(allErrors);
        };

        User newUser = userMapper.toEntity(userDTO);
        User result = userRepository.save(newUser);
        return userMapper.toDTO(result);
    }
}
