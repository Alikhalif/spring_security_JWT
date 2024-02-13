package com.youcode.reviews_jwt.service;

import com.youcode.reviews_jwt.dto.SignUpRequest;
import com.youcode.reviews_jwt.entity.OurUsers;

public interface AuthenticationService {
    OurUsers signup(SignUpRequest signUpRequest);
}
