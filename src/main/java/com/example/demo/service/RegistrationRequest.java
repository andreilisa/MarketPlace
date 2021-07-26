package com.example.demo.service;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;


@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class RegistrationRequest {
    private final String username;
    private final String password;
    private final String email;
}
