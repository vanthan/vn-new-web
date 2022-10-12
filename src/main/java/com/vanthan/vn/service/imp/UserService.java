package com.vanthan.vn.service.imp;

import com.vanthan.vn.dto.*;
import com.vanthan.vn.service.IUser;
import com.vanthan.vn.util.CommonUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
@Log4j2
public class UserService implements IUser {

    @Value("${base.url.authen}")
    private String baseUrl;
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    @Override
    public BaseResponse<UserResponse> getUser(String keyword, GetUserRequest request,String token) {

        ResponseEntity<BaseResponse<UserResponse>> response = null;
        //call back-end
        String url = baseUrl + "/search-userName?userName=" + keyword;
        log.info("Request body {}", CommonUtil.convertFromObject(request));

        try {
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(token);
            HttpEntity<GetUserRequest> requestUpdate = new HttpEntity<>(request, headers);
            response = restTemplate.exchange(url, HttpMethod.POST, requestUpdate, new ParameterizedTypeReference<BaseResponse<UserResponse>>() {});
            log.info("Response body {}", response.getBody());
        }catch (RestClientException e){
            log.error("Error {}", e.getMessage());
        }
        return response.getBody();
    }

    @Override
    public BaseResponse addCustomer(AddCustomerRequest request, String token) {
        ResponseEntity<BaseResponse> response = null;
        String url = baseUrl + "/saveCustomer";
        log.info("Request body {}", CommonUtil.convertFromObject(request));

        try {
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(token);
            HttpEntity<AddCustomerRequest> requestUpdate = new HttpEntity<>(request, headers);
            response = restTemplate.exchange(url, HttpMethod.POST, requestUpdate, new ParameterizedTypeReference<BaseResponse>() {});
            log.info("Response body {}", response.getBody());
        }catch (RestClientException e){
            log.error("Error {}", e.getMessage());
        }
        return response.getBody();

    }

    @Override
    public BaseResponse<UserResponse> searchUser(GetUserRequest request, String token, String userName) {
        ResponseEntity<BaseResponse<UserResponse>> response = null;
        //call back-end
        String url = baseUrl + "/search-userName?userName="+userName;
        log.info("Request body {}", CommonUtil.convertFromObject(request));

        try {
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(token);
            HttpEntity<GetUserRequest> requestUpdate = new HttpEntity<>(request, headers);
            response = restTemplate.exchange(url, HttpMethod.POST, requestUpdate, new ParameterizedTypeReference<BaseResponse<UserResponse>>() {});
            log.info("Response body {}", response.getBody());
        }catch (RestClientException e){
            log.error("Error {}", e.getMessage());
        }
        return response.getBody();
    }

    @Override
    public BaseResponse deleteUser(String token, String id) {
        ResponseEntity<BaseResponse> response = null;
        String url = baseUrl + "/deleteCustomer/"+id;
        log.info("Request body {}", id);

        try {
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(token);
            HttpEntity<String> requestDeleteProduct = new HttpEntity<>(headers);
            response = restTemplate.exchange(url, HttpMethod.DELETE, requestDeleteProduct, new ParameterizedTypeReference<BaseResponse>() {});
            log.info("Response body {}", response.getBody());
            return response.getBody();
        }catch (RestClientException e){
            log.error("Error {}", e.getMessage());
            return null;
        }

    }

    @Override
    public BaseResponse<UserItem> editUser(UserItem userItem, String token) {
        ResponseEntity<BaseResponse<UserItem>> response = null;
        String url = baseUrl + "/updateCustomer";
        log.info("Request body {}", CommonUtil.convertFromObject(userItem));

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity<UserItem> requestSaveProduct = new HttpEntity<>(userItem, headers);
        response = restTemplate.exchange(url, HttpMethod.PUT, requestSaveProduct,new ParameterizedTypeReference<BaseResponse<UserItem>>() {} );

        return response.getBody();
    }

    @Override
    public BaseResponse<UserItem> getUserDetailById(String id, String token) {
        ResponseEntity<BaseResponse<UserItem>> response = null;
        String url = baseUrl + "/customerDetail/" + id;
        log.info("Request Body {}", id);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity<String> requestGetProduct = new HttpEntity<>(headers);
        response = restTemplate.exchange(url, HttpMethod.GET, requestGetProduct,new ParameterizedTypeReference<BaseResponse<UserItem>>() {} );

        return response.getBody();
    }
}
