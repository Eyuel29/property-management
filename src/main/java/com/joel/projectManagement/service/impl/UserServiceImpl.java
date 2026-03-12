package com.joel.projectManagement.service.impl;
import com.joel.projectManagement.converter.UserConverter;
import com.joel.projectManagement.dto.UserDTO;
import com.joel.projectManagement.entity.User;
import com.joel.projectManagement.repository.UserRepository;
import com.joel.projectManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO signIn(String email, String password) {
//        User result = userRepository.();
        return userConverter.convertEntityToDTO(result);
    }

    @Override
    public UserDTO signUp(UserDTO userDTO) {
        User newUser = userConverter.convertDTOToEntity(userDTO);
        User result = userRepository.save(newUser);
        return userConverter.convertEntityToDTO(result);
    }
}
