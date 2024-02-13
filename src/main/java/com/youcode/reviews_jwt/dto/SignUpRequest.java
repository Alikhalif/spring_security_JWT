package com.youcode.reviews_jwt.dto;

import com.youcode.reviews_jwt.enums.Role;
import lombok.Data;

import java.util.Set;

@Data
public class SignUpRequest {

    private String firstname;
    private String lastname;
    private String username;
    private String password;
}
