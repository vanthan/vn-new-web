package com.vanthan.vn.controller;

import com.vanthan.vn.dto.BaseResponse;
import com.vanthan.vn.dto.GetUserRequest;
import com.vanthan.vn.dto.UserResponse;
import com.vanthan.vn.service.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/")
public class UserController extends AbtractController{

    @Autowired
    private IUser iUser;

    @GetMapping("user")
    public String user(HttpServletRequest request, Model model){

        // call api getCustomer
        GetUserRequest getUserRequest = new GetUserRequest();
        getUserRequest.setPageNum(1);
        getUserRequest.setTotalNum(10);
        BaseResponse<UserResponse> response = iUser.getUser(getUserRequest);

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

}
