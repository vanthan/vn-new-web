package com.vanthan.vn.service;

import com.vanthan.vn.dto.*;

public interface IAuthen {
    BaseResponse<LoginResponse> login(LoginRequest request);
    BaseResponse<RegisterResponse> register(RegisterRequest request);
}
