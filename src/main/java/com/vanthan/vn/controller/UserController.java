package com.vanthan.vn.controller;

import com.vanthan.vn.dto.*;
import com.vanthan.vn.service.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

        String pageNum = request.getParameter("pageNum");
        String keyword = request.getParameter("keyword");

        if(pageNum == null){
            pageNum = "0";
        }

        if(keyword == null){
            keyword = "";
        }

        // call api getCustomer
        GetUserRequest getUserRequest = new GetUserRequest();
        getUserRequest.setPageNum(Integer.valueOf(pageNum));
        getUserRequest.setTotalNum(5);
        String token = saveToken.get("token");
        BaseResponse<UserResponse> response = iUser.getUser(keyword, getUserRequest, token);

        model.addAttribute("userPage", response.getBody().getContent());
        int totalPages = response.getBody().getTotalPages();

        request.setAttribute("endP", response.getBody().getTotalPages());
        request.setAttribute("totalElements", response.getBody().getTotalElements());
        request.setAttribute("tag", pageNum);
        request.setAttribute("totalNum", 5);
        request.setAttribute("keyword", keyword);

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

    @PostMapping("user/search")
    public RedirectView searchUser(HttpServletRequest request, Model model){
        RedirectView redirectView = new RedirectView("/user", false);
        String userName = request.getParameter("search_user");

        GetUserRequest getUserRequest = new GetUserRequest();
        getUserRequest.setPageNum(0);
        getUserRequest.setTotalNum(10);
        String token = saveToken.get("token");
        BaseResponse<UserResponse> response = iUser.searchUser(getUserRequest, token,userName);

        model.addAttribute("userPage", response.getBody().getContent());
        return redirectView;
    }

    @PostMapping("user/delete")
    public RedirectView delete(HttpServletRequest request, RedirectAttributes redirectAttributes){
        RedirectView redirectView = new RedirectView("/user", false);
        String idUser = request.getParameter("idUser");

        String token = saveToken.get("token");
        BaseResponse<UserResponse> response = iUser.deleteUser(token,idUser);

        if (!response.getCode().equals("00") && !response.getMessage().equals("Success")){
            redirectAttributes.addFlashAttribute("message","Thanh Công");
        }
        return redirectView;
    }

    @PostMapping(value ="edit-user")
    public String editNewProduct(UserItem userItem, Model model, HttpServletRequest request){

        userItem.setId(Integer.valueOf(request.getParameter("id")));
        userItem.setUserName(request.getParameter("userName"));
        userItem.setEmail(request.getParameter("email"));
        userItem.setAge(request.getParameter("age"));

        iUser.editUser(userItem ,saveToken.get("token"));

        return "redirect:/user";
    }
}
