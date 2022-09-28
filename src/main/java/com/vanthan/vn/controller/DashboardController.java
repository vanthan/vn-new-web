package com.vanthan.vn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DashboardController {

    @GetMapping(value = "dashboard")
    public String dashboard(HttpServletRequest request){
        return "dashboard/dashboard";
    }
}
