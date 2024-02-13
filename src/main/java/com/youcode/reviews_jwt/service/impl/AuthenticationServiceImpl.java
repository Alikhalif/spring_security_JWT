package com.youcode.reviews_jwt.service.impl;

import com.youcode.reviews_jwt.dto.SignUpRequest;
import com.youcode.reviews_jwt.entity.OurUsers;
import com.youcode.reviews_jwt.enums.Role;
import com.youcode.reviews_jwt.repository.UserRepository;
import com.youcode.reviews_jwt.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public OurUsers signup(SignUpRequest signUpRequest){
        OurUsers user = new OurUsers();

        user.setFirstname(signUpRequest.getFirstname());
        user.setLastname(signUpRequest.getLastname());
        Set<Role> userRoles = Collections.singleton(Role.BASE_USER);
        user.setRoles(userRoles);
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

        return userRepository.save(user);
    }
}
