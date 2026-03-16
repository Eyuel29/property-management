package com.joel.projectManagement.service.impl;

import com.joel.projectManagement.dto.UserDTO;
import com.joel.projectManagement.entity.User;
import com.joel.projectManagement.exception.PMSError;
import com.joel.projectManagement.exception.PMSException;
import com.joel.projectManagement.mapper.UserMapper;
import com.joel.projectManagement.repository.UserRepository;
import com.joel.projectManagement.service.UserService;

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
