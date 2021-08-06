package com.example.demo.service;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class RegistrationRequest {
    @NotBlank
    @NotEmpty(message = "username must be between 4 and 32")
    @Size(min = 4, max = 32)
    private final String username;
    @NotEmpty(message = "password must not be empty")
    @Size(min = 6, max = 25)
    private final String password;
    @NotEmpty(message ="email must not be empty )")
    private final String email;
}
