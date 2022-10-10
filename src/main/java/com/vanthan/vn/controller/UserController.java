package com.vanthan.vn.controller;

import com.vanthan.vn.dto.AddCustomerRequest;
import com.vanthan.vn.dto.BaseResponse;
import com.vanthan.vn.dto.GetUserRequest;
import com.vanthan.vn.dto.UserResponse;
import com.vanthan.vn.service.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("")
public class UserController extends AbtractController{

    @Autowired
    private IUser iUser;

    @GetMapping("user")
    public String user(HttpServletRequest request, Model model){

        // call api getCustomer
        GetUserRequest getUserRequest = new GetUserRequest();
        getUserRequest.setPageNum(0);
        getUserRequest.setTotalNum(10);
        String token = saveToken.get("token");
        BaseResponse<UserResponse> response = iUser.getUser(getUserRequest, token);

        model.addAttribute("userPage", response.getBody().getContent());
        int totalPages = response.getBody().getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "user/user";
    }

    @PostMapping("user")
    public RedirectView addCustomer(HttpServletRequest request, RedirectAttributes redirectAttributes){
        RedirectView redirectView = new RedirectView("/user", false);
        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String age = request.getParameter("age");

        AddCustomerRequest customerRequest = new AddCustomerRequest();
        customerRequest.setUserName(userName);
        customerRequest.setEmail(email);
        customerRequest.setAge(Integer.valueOf(age));
        String token = saveToken.get("token");
        BaseResponse response = iUser.addCustomer(customerRequest, token);

        if (!response.getCode().equals("00") && !response.getMessage().equals("Success")){
            redirectAttributes.addFlashAttribute("message","Thanh Công");
        }
        return redirectView;
    }

}
