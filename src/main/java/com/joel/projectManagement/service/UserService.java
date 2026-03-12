package com.joel.projectManagement.service;

import com.joel.projectManagement.dto.UserDTO;

public interface UserService {
    UserDTO signIn (String email, String password);
    UserDTO signUp (UserDTO userDTO);
}
