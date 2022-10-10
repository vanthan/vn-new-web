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
    public BaseResponse<UserResponse> getUser(GetUserRequest request,String token) {

        ResponseEntity<BaseResponse<UserResponse>> response = null;
        //call back-end
        String url = baseUrl + "/getCustomer";
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
}
