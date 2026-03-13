package com.joel.projectManagement.service.impl;
import com.joel.projectManagement.dto.UserDTO;
import com.joel.projectManagement.entity.User;
import com.joel.projectManagement.mapper.UserMapper;
import com.joel.projectManagement.repository.UserRepository;
import com.joel.projectManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO signIn(String email, String password) {
        Optional<User> result = userRepository.findByEmail(email);
        return result.isPresent() ? userMapper.toDTO(result.get()) : null;
    }

    @Override
    public UserDTO signUp(UserDTO userDTO) {
        User newUser = userMapper.toEntity(userDTO);
        User result = userRepository.save(newUser);
        return userMapper.toDTO(result);
    }
}
