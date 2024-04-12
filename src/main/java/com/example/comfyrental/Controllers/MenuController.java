package com.example.comfyrental.Controllers;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@AllArgsConstructor
public class MenuController {
    @RequestMapping("/login")
    public String userLogin(){
        return "User/userLogin";
    }
    @RequestMapping("/")
    public String MainPage(){
        return "Menu/MainPage";
    }
    @RequestMapping("/accessDenied")
    public String accessDenied(){
        return "Menu/AccessDenied";
    }
}
