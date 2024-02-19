package com.youcode.reviews_jwt.service.impl;

import com.youcode.reviews_jwt.dto.JwtAuthenticationResponse;
import com.youcode.reviews_jwt.dto.SignInRequest;
import com.youcode.reviews_jwt.dto.SignUpRequest;
import com.youcode.reviews_jwt.entity.OurUsers;
import com.youcode.reviews_jwt.enums.Role;
import com.youcode.reviews_jwt.repository.UserRepository;
import com.youcode.reviews_jwt.service.AuthenticationService;
import com.youcode.reviews_jwt.service.JWTservice;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    @Autowired
    private AuthenticationManager authenticationManager;
    private final JWTServiceImpl jwtService;

    @Override
    public SignUpRequest signup(SignUpRequest signUpRequest){
        OurUsers user = new OurUsers();

        user.setFirstname(signUpRequest.getFirstname());
        user.setLastname(signUpRequest.getLastname());
        user.setUsername(signUpRequest.getUsername());
        user.setRole(Role.BASE_USER);
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

        return modelMapper.map(userRepository.save(user), SignUpRequest.class);
    }


    @Override
    public JwtAuthenticationResponse signIn(SignInRequest signInRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getUsername(),
                signInRequest.getPassword()));

        System.out.println(signInRequest.getUsername());

        var user = userRepository.findByUsername(signInRequest.getUsername()).orElseThrow(() -> new IllegalArgumentException("Invalid username or password."));
        var jwt = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(new HashMap<>(), user);

        System.out.println(user);
        System.out.println(jwt);

        JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();

        jwtAuthenticationResponse.setToken(jwt);
        jwtAuthenticationResponse.setRefreshToken(refreshToken);

        System.out.println(jwt);
        return jwtAuthenticationResponse;
    }
}
