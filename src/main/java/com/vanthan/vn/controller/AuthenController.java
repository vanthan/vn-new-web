package com.vanthan.vn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthenController {


    @GetMapping(value = "")
    public String redirect(){
        return "redirect:login";
    }

    @GetMapping(value = "login")
    public String login(HttpServletRequest request){
        return "authen/login";
    }

    @GetMapping(value = "login")
    public String register(HttpServletRequest request){
        return "authen/register";
    }
}
