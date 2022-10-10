package com.vanthan.vn.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class DataProduct implements Serializable {
    private List<ProductItem> content;
    private String totalPages;
    private String totalElements;
}
