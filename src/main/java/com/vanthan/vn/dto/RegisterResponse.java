package com.vanthan.vn.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class RegisterResponse implements Serializable {
    private String token;
}
