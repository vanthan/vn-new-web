package com.vanthan.vn.service.imp;

import com.vanthan.vn.dto.*;
import com.vanthan.vn.service.IAuthen;
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
public class AuthenService implements IAuthen {

    @Value("${base.url.authen}")
    private String baseUrl;

    private String register;

    @Override
    public BaseResponse<LoginResponse> login(LoginRequest request) {
        ResponseEntity<BaseResponse<LoginResponse>> response = null;
        //call back-end
        String url = baseUrl + "/login";
        log.info("Request body {}", CommonUtil.convertFromObject(request));

        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<LoginRequest> requestUpdate = new HttpEntity<>(request, headers);
            response = restTemplate.exchange(url, HttpMethod.POST, requestUpdate, new ParameterizedTypeReference<BaseResponse<LoginResponse>>() {});
            log.info("Response body {}", response.getBody());
        }catch (RestClientException e){
            log.error("Error {}", e.getMessage());
        }
        return response.getBody();
    }

    @Override
    public BaseResponse<RegisterResponse> register(RegisterRequest request) {
        ResponseEntity<BaseResponse<RegisterResponse>> response = null;
        //call back-end
        String url = baseUrl + "/register";
        log.info("Request body {}", CommonUtil.convertFromObject(request));

        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<RegisterRequest> requestUpdate = new HttpEntity<>(request, headers);
            response = restTemplate.exchange(url, HttpMethod.POST, requestUpdate, new ParameterizedTypeReference<BaseResponse<RegisterResponse>>() {});
            log.info("Response body {}", response.getBody());
        }catch (RestClientException e){
            log.error("Error {}", e.getMessage());
        }
        return response.getBody();
    }

}
