package com.example.comfyrental.Controllers;

import com.example.comfyrental.Entities.User;
import com.example.comfyrental.Services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/User")
public class UserController {
    private UserService userService;
    @RequestMapping("/createUser")
    public String createUser(){
        return "User/createUser";
    }
    @RequestMapping("saveUser")
    public String saveUser(@ModelAttribute("newUser") User newuser,ModelMap model){
        try {
            userService.saveUser(newuser);
            Page<User> userList=userService.findAllUsers(0,10);
            model.addAttribute("UserList", userList);
            model.addAttribute("successMessage", "User saved successfully!");
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Failed to save user: " + e.getMessage());
        }
        return "User/usersList";
    }
    @RequestMapping("/usersList")
    public String usersList(ModelMap modelMap ,@RequestParam ( name="page" , defaultValue = "0") int page ,@RequestParam ( name="size" , defaultValue = "5") int size ){
            Page<User> userList=userService.findAllUsers(page,size);
        for (User user:userList) {
            user.setPassword(user.getPassword().substring(0,10)+"...");
        }
        modelMap.addAttribute("UserList", userList);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("pages", new int[userList.getTotalPages()]);
        return "User/usersList";
    }
    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") String id ,ModelMap modelMap,ModelMap model){
        try {
            userService.deleteUserById(id);
            Page<User> userList=userService.findAllUsers(0,10);
            modelMap.addAttribute("UserList", userList);
            model.addAttribute("successMessage", "User Deleted successfully!");
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Failed to delete user: " + e.getMessage());
        }
        return "User/usersList";
    }
    @RequestMapping("/showUser")
    public String showUser(@RequestParam("id") String id ,ModelMap modelMap){
        User user=userService.findUserById(id);
        modelMap.addAttribute("User", user);
        return "User/editUser";
    }
    @RequestMapping("editUser")
    public String editUser(@ModelAttribute("editedUser") User editedUser ,ModelMap modelMap,ModelMap model){
        try {
            userService.saveUser(editedUser);
            List<User> userList=userService.findAllUsers();
            modelMap.addAttribute("UserList", userList);
            model.addAttribute("successMessage", "User edited successfully!");
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Failed to edit user: " + e.getMessage());
        }
               return "User/usersList";
    }


}
