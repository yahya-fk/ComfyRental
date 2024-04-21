package com.example.comfyrental.RestControllers;

import com.example.comfyrental.Entities.User;
import com.example.comfyrental.Models.UserLogin;
import com.example.comfyrental.Services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@AllArgsConstructor
@RequestMapping("/Auth")
public class UserRestController {
    private final UserService userService;
    PasswordEncoder passwordEncoder;
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String savePerson(@RequestBody User user) {
        if(userService.findUserByEmail(user.getEmail()) != null){
            return "Email Already Exist";
        }
        if(userService.findUserByImage(user.getImgPath()) != null){
            return  "Image already exist";
        }
        else{
            try {
                User u1 = userService.saveUser(user);
                return u1.getIdU();
            }catch (Exception e){
                return "Error";
            }

        }
    }
    @GetMapping(value = "/show/{id}")
    public User showPerson(@PathVariable String id) {
        return userService.findUserById(id);
    }
    @GetMapping(value = "/showALL")
    public List<User> showAllPerson() {
        return userService.findAllUsers();
    }
    @PutMapping(value = "/update")
    public User updatePerson( @RequestBody User updatedPerson) {
        return userService.saveUser(updatedPerson);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deletePerson(@PathVariable String id) {
        userService.deleteUserById(id);
    }

    @GetMapping(value = "/send/{email}")
    public User sendUser(@PathVariable String email) {
        return userService.findUserByEmail(email);
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public User Login(@RequestBody UserLogin userLogin) {
        User user = userService.findUserByEmail(userLogin.getEmail());
        if (user == null) return null;
        else {
            System.out.println(userLogin.getPassword()+"      "  +user.getPassword());
            if (passwordEncoder.matches(userLogin.getPassword(),user.getPassword())) {
                return /*user.getEmail()*/user;
            }else{
                return null;
            }
        }
    }
}