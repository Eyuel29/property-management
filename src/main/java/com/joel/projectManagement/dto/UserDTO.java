package com.joel.projectManagement.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.Instant;

@Getter
@Setter
public class UserDTO {
        private String id;
        private String name;
        private String email;
        private String phoneNumber;
        private String password;
        private Instant createdAt;
        private Instant updatedAt;
}
