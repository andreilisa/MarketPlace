package com.example.demo.service;

import com.example.demo.dao.UserRepository;
import com.example.demo.model.User;
import com.example.demo.model.UserRole;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username)

            throws UsernameNotFoundException {
        return userRepository.findByUsername(username);

    }

    public String signUp(User user) {
        userRepository.findByUsername(user.getUsername());
        String encodePass = bCryptPasswordEncoder
                .encode(user.getPassword());
        user.setPassword(encodePass);
        userRepository.save(user);
        return "it works";
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
