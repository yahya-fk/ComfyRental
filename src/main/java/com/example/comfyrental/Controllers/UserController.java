package com.example.comfyrental.Controllers;

import com.example.comfyrental.Entities.User;
import com.example.comfyrental.Services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class UserController {
    private UserService userService;
    @RequestMapping("/createUser")
    public String createUser(){
        return "User/createUser";
    }
    @RequestMapping("saveUser")
    public String saveUser(@ModelAttribute("newUser") User newuser){
        userService.saveUser(newuser);
        return "User/createUser";
    }
    @RequestMapping("/usersList")
    public String usersList(ModelMap modelMap){
        List<User> userList=userService.findAllUsers();
        modelMap.addAttribute("UserList", userList);
        return "User/usersList";
    }
}
