package com.example.user_management_app.entity;

import com.example.user_management_app.dto.UserRegistrationDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Setter;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username is mandatory")
    @Column(unique = true)
    private String username;

    // Getters and setters
    @Setter
    @NotBlank(message = "Password is mandatory")
    private String password;

    @Setter
    @Email
    @NotBlank(message = "Email is mandatory")
    private String email;

    @Setter
    @Enumerated(EnumType.STRING)
    private Role role;

    public void setUsername(Class<? extends UserRegistrationDto> aClass) {

    }

}


