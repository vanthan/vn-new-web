package com.vanthan.vn.service;

import com.vanthan.vn.dto.*;
import javassist.compiler.ast.MethodDecl;

public interface IUser {
    BaseResponse<UserResponse> getUser(String keyword, GetUserRequest request, String token);
    BaseResponse addCustomer(AddCustomerRequest request, String token);
    BaseResponse<UserResponse> searchUser(GetUserRequest request, String token, String userName);
    BaseResponse deleteUser(String token, String id);
    BaseResponse<UserItem> editUser(UserItem userItem, String token);
    BaseResponse<UserItem> getUserDetailById(String id, String token);
}
