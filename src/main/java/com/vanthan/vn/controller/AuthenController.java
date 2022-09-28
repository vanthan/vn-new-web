package com.vanthan.vn.controller;

import com.vanthan.vn.dto.BaseResponse;
import com.vanthan.vn.dto.LoginRequest;
import com.vanthan.vn.dto.RegisterRequest;
import com.vanthan.vn.dto.RegisterResponse;
import com.vanthan.vn.service.IAuthen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthenController {

    @Autowired
    private IAuthen iAuthen;

    @GetMapping(value = "")
    public String redirect(){
        return "redirect:login";
    }

    @GetMapping(value = "login")
    public String login(HttpServletRequest request){
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String repeatPassword = request.getParameter("repeatPassword");

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail(email);
        loginRequest.setPassword(password);
        loginRequest.setFullName(fullName);

        //login


        return "authen/login";
    }

    @GetMapping(value = "register")
    public String register(HttpServletRequest request){
        return "authen/register";
    }

    @PostMapping(value = "do/register")
    public RedirectView doRegister(HttpServletRequest request){
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String repeatPassword = request.getParameter("repeatPassword");

        //check password
        if(!password.equals(repeatPassword)){

        }

        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail(email);
        registerRequest.setPassword(password);
        registerRequest.setFullName(fullName);

        //register
//        BaseResponse<RegisterResponse> response =  iAuthen.register(registerRequest);

//        if (!response.getCode().equals("00") && !response.getMessage().equals("Success")){
//
//        }

        return new RedirectView("/dashboard");
    }
}
