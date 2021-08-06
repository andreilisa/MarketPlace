package com.example.demo.service;

import com.example.demo.dao.UserRepository;
import com.example.demo.model.User;
import com.example.demo.model.UserRole;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username)

            throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());

    }

    public String signUp(User user) {

       User users =  userRepository.findByUsername(user.getUsername());
       if (users != null)
           throw  new UsernameNotFoundException(String.format("User with %s already exists", users.getUsername()));
        String encodePass = bCryptPasswordEncoder
                .encode(user.getPassword());
        user.setPassword(encodePass);
        userRepository.save(user);
        return  HttpStatus.OK + " \nRegister with success";
    }

    public String register(RegistrationRequest request) {
        return signUp(
                new User(

                        request.getUsername(),
                        request.getPassword(),
                        request.getEmail(),
                        UserRole.USER
                )
        );
    }

}
