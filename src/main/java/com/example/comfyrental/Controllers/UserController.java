package com.example.comfyrental.Controllers;

import com.example.comfyrental.Entities.User;
import com.example.comfyrental.Services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        for (User user:userList) {
            user.setPassword(user.getPassword().substring(0,10)+"...");

        }
        modelMap.addAttribute("UserList", userList);
        return "User/usersList";
    }
    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") String id ,ModelMap modelMap){
        userService.deleteUserById(id);
        List<User> userList=userService.findAllUsers();
        modelMap.addAttribute("UserList", userList);
        return "User/usersList";
    }
    @RequestMapping("/showUser")
    public String showUser(@RequestParam("id") String id ,ModelMap modelMap){
        User user=userService.findUserById(id);
        modelMap.addAttribute("User", user);
        return "User/editUser";
    }
    @RequestMapping("editUser")
    public String editUser(@ModelAttribute("editedUser") User editedUser ,ModelMap modelMap){
        userService.saveUser(editedUser);
        List<User> userList=userService.findAllUsers();
        modelMap.addAttribute("UserList", userList);
        return "User/usersList";
    }


}
