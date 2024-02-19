package com.youcode.reviews_jwt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class SignInRequest {
    private String username;
    private String password;
}
