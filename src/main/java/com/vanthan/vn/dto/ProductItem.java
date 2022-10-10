package com.vanthan.vn.dto;

import lombok.Data;

@Data
public class ProductItem {
    private Integer id;
    private String sku;
    private String name;
    private Integer quantity;
}
