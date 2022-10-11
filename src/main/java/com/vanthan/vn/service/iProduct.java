package com.vanthan.vn.service;

import com.vanthan.vn.dto.BaseResponse;
import com.vanthan.vn.dto.DataProduct;
import com.vanthan.vn.dto.Paging;
import com.vanthan.vn.dto.ProductItem;

public interface iProduct {

    BaseResponse<DataProduct> getProduct(String keyword,Paging request, String token);

    void saveProduct(ProductItem productItem, String token);

    void deleteProduct(String id, String token);

    void  editProduct(ProductItem request, String id, String token);

    BaseResponse<ProductItem> getProductDetail(String id, String token);
}
