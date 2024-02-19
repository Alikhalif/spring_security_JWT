package com.youcode.reviews_jwt.service;

import com.youcode.reviews_jwt.dto.JwtAuthenticationResponse;
import com.youcode.reviews_jwt.dto.ReqRes;
import com.youcode.reviews_jwt.dto.SignInRequest;
import com.youcode.reviews_jwt.dto.SignUpRequest;
import com.youcode.reviews_jwt.entity.OurUsers;

public interface AuthenticationService {
    SignUpRequest signup(SignUpRequest signUpRequest);
    JwtAuthenticationResponse signIn(SignInRequest signInRequest);
}
