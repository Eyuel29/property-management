package com.joel.projectManagement.controller;

import com.joel.projectManagement.dto.UserDTO;
import com.joel.projectManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/signup")
    public ResponseEntity<UserDTO> signUp (@RequestBody UserDTO newUser) {
        UserDTO result = userService.signUp(newUser);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/user/signin")
    public ResponseEntity<UserDTO> signIn (@RequestBody UserDTO userDTO) {

        UserDTO foundUser = userService.signIn(userDTO.getEmail(), userDTO.getPassword());

        if (foundUser == null) return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        if (foundUser.getPassword() != userDTO.getPassword()) return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);

        return new ResponseEntity<>(foundUser, HttpStatus.OK);
    }
}
