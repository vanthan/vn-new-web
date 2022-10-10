package com.vanthan.vn.controller;

import com.vanthan.vn.dto.BaseResponse;
import com.vanthan.vn.dto.DataProduct;
import com.vanthan.vn.dto.Paging;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DashboardController extends AbtractController{

    @Value("${base.url.authen}")
    private String baseUrl;

    @GetMapping(value = "dashboard")
    public String dashboard(HttpServletRequest request){
        return "dashboard/dashboard";
    }
}
