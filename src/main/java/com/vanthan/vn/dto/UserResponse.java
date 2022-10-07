package com.vanthan.vn.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserResponse {
    private List<UserItem> content;
    private Integer totalPages;
    private Integer totalElements;
}
