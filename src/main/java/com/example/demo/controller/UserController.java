package com.example.demo.controller;
import com.example.demo.service.RegistrationRequest;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api
@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class UserController {


    private  UserService userService;
    @PostMapping
    public String register(@RequestBody RegistrationRequest request)
    {
       return userService.register(request);
    }


}

