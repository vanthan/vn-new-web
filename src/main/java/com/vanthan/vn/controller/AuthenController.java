package com.vanthan.vn.controller;

import com.vanthan.vn.dto.*;
import com.vanthan.vn.service.IAuthen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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

    @PostMapping(value = "login")
    public RedirectView doLogin(HttpServletRequest request, RedirectAttributes redirectAttributes){
        final RedirectView redirectView = new RedirectView("/dashboard", false);
        final RedirectView redirectView2 = new RedirectView("/login", true);

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        LoginRequest login = new LoginRequest();
        login.setEmail(email);
        login.setPassword(password);

        BaseResponse<LoginResponse> response =  iAuthen.login(login);
        if (!response.getCode().equals("00") && !response.getMessage().equals("Success")){
            redirectAttributes.addFlashAttribute("message",response.getMessage());
            return redirectView2;
        }
        return redirectView;
    }

    @PostMapping(value = "register")
    public RedirectView doRegister(HttpServletRequest request, RedirectAttributes redirectAttributes){
        final RedirectView redirectView = new RedirectView("/dashboard", false);
        final RedirectView redirectView2 = new RedirectView("/register", true);
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String username = request.getParameter("username");
        String repeatPassword = request.getParameter("repeatPassword");

        //check password
        if(!password.equals(repeatPassword)){
            redirectAttributes.addFlashAttribute("message","Mật khẩu không đúng");
            return redirectView2;
        }

        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail(email);
        registerRequest.setPassword(password);
        registerRequest.setUsername(username);
        registerRequest.setFullName(fullName);

        //register
        BaseResponse<RegisterResponse> response =  iAuthen.register(registerRequest);

        if (!response.getCode().equals("00") && !response.getMessage().equals("Success")){
            redirectAttributes.addFlashAttribute("message",response.getMessage());
            return redirectView2;
        }
        return redirectView;
    }
}
