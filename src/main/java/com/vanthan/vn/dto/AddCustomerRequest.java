package com.vanthan.vn.dto;

import lombok.Data;

@Data
public class AddCustomerRequest {
    private String userName;
    private String email;
    private Integer age;
}
