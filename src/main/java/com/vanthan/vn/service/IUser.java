package com.vanthan.vn.service;

import com.vanthan.vn.dto.AddCustomerRequest;
import com.vanthan.vn.dto.BaseResponse;
import com.vanthan.vn.dto.GetUserRequest;
import com.vanthan.vn.dto.UserResponse;

public interface IUser {
    BaseResponse<UserResponse> getUser(GetUserRequest request, String token);
    BaseResponse addCustomer(AddCustomerRequest request, String token);
}
