package com.example.demo.controller;

import com.example.demo.service.LoginRequest;
import com.example.demo.service.RegistrationRequest;
import com.example.demo.service.UserService;
import com.example.demo.util.JwtUtil;
import com.sun.media.sound.InvalidDataException;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.aop.framework.adapter.AdvisorAdapterRegistrationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@Api
@RestController
@RequestMapping(path = "api/v1/user")
@AllArgsConstructor
@Validated
public class UserController {
    @Autowired
    private final JwtUtil jwtUtil;
    @Autowired
    private final AuthenticationManager authenticationManager;
    @Autowired
    private final UserService userService;

    @PostMapping("/register")
    public String register(@Valid @RequestBody RegistrationRequest request) {
        return userService.register(request);

    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody LoginRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("Invalid username or password");
        }
        return jwtUtil.generateToken(authRequest.getUsername());
    }

}

