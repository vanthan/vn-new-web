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

    @Override
    public BaseResponse<UserResponse> getUser(GetUserRequest request) {

        ResponseEntity<BaseResponse<UserResponse>> response = null;
        //call back-end
        String url = baseUrl + "/getCustomer";
        log.info("Request body {}", CommonUtil.convertFromObject(request));

        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<GetUserRequest> requestUpdate = new HttpEntity<>(request, headers);
            response = restTemplate.exchange(url, HttpMethod.POST, requestUpdate, new ParameterizedTypeReference<BaseResponse<UserResponse>>() {});
            log.info("Response body {}", response.getBody());
        }catch (RestClientException e){
            log.error("Error {}", e.getMessage());
        }
        return response.getBody();
    }
}
