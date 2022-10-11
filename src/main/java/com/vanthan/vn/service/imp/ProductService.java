package com.vanthan.vn.service.imp;

import com.vanthan.vn.dto.BaseResponse;
import com.vanthan.vn.dto.DataProduct;
import com.vanthan.vn.dto.Paging;
import com.vanthan.vn.dto.ProductItem;
import com.vanthan.vn.service.iProduct;
import com.vanthan.vn.util.CommonUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.persistence.criteria.CriteriaBuilder;

@Service
@Log4j2
public class ProductService implements iProduct {

    @Value("${base.url.authen}")
    private String baseUrl;

    @Override
    public BaseResponse<DataProduct> getProduct(String keyword, Paging request, String token) {

        ResponseEntity<BaseResponse<DataProduct>> response = null;
        //call back-end
        String url = baseUrl + "/search?name=" + keyword;
        log.info("Request body {}", CommonUtil.convertFromObject(request));

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(token);
        HttpEntity<Paging> requestProducts= new HttpEntity<>(request, headers);
        response = restTemplate.exchange(url, HttpMethod.POST, requestProducts,new ParameterizedTypeReference<BaseResponse<DataProduct>>() {} );
        log.info("Response body {}", response.getBody());

        return response.getBody();
    }

    @Override
    public void saveProduct(ProductItem productItem, String token) {

        String url = baseUrl + "/products";
        log.info("Resquest Body {}", CommonUtil.convertFromObject(productItem));

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity<ProductItem> requestSaveProduct = new HttpEntity<>(productItem, headers);
        restTemplate.exchange(url, HttpMethod.POST, requestSaveProduct,new ParameterizedTypeReference<BaseResponse<ProductItem>>() {} );

    }

    @Override
    public void deleteProduct(String id, String token) {

        String url = baseUrl + "/products/" + id;
        log.info("Request Body {}", id);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity<String> requestDeleteProduct = new HttpEntity<>(headers);

        restTemplate.exchange(url, HttpMethod.DELETE, requestDeleteProduct, String.class);
    }

    @Override
    public void editProduct(ProductItem request, String id, String token) {

        String url = baseUrl + "/products/" + id;
        log.info("Request Body {}", id);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity<ProductItem> requestSaveProduct = new HttpEntity<>(request, headers);
        restTemplate.exchange(url, HttpMethod.PUT, requestSaveProduct,new ParameterizedTypeReference<BaseResponse<ProductItem>>() {} );

    }

    @Override
    public BaseResponse<ProductItem> getProductDetail(String id, String token) {

        ResponseEntity<BaseResponse<ProductItem>> response = null;
        String url = baseUrl + "/productDetail/" + id;
        log.info("Request Body {}", id);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity<String> requestGetProduct = new HttpEntity<>(headers);
        response = restTemplate.exchange(url, HttpMethod.GET, requestGetProduct,new ParameterizedTypeReference<BaseResponse<ProductItem>>() {} );

        return response.getBody();
    }
}
