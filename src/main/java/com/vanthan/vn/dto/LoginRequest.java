package com.vanthan.vn.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String fullName;
    private String email;
    private String password;
}
