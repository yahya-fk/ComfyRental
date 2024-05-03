package com.example.comfyrental.RestControllers;
import com.example.comfyrental.Models.UserRegisterModel;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.example.comfyrental.Entities.User;
import com.example.comfyrental.Models.UserLogin;
import com.example.comfyrental.Services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.MultipartFile;
import java.io.File;
;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/Auth")
@CrossOrigin(origins = "*")
public class UserRestController {
    private final UserService userService;
    PasswordEncoder passwordEncoder;
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@RequestBody UserRegisterModel user) {
        if(userService.findUserByEmail(user.getEmail()) != null){
            return "Email Already Exist";
        }
        else{
            try {
                User user1 = new User(user);
                User u1 = userService.saveUser(user1);
                return u1.getIdU();
            }catch (Exception e){
                System.out.println(e.getMessage());
                return "Error";
            }

        }
    }
    @PostMapping("/ProfileImage/upload/{id}")
    public String uploadProfileImage(@RequestParam("file") MultipartFile file,@PathVariable String id){
        if (file.isEmpty()) {
            return "Please select a file to upload.";
        }
        try {
            User user=userService.findUserById(id);
            user.setImg(file.getBytes());
            userService.updateUser(user);
            return "Khedam";
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to upload file.";
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

    @PutMapping(value = "/Update/{idU}")
    public UserLogin updatePerson(@PathVariable String idU, @RequestBody User updatedPerson) {
        System.out.println("haya l ID: " + idU);
        User existingUser = userService.findUserById(idU);
        System.out.println("Hawa l user l9ah: " + existingUser);
        if (existingUser == null) {
            System.out.println("User not found");
            return null;
        }
        System.out.println("hawa l user jdid"+ updatedPerson);
        existingUser.setLastName(updatedPerson.getLastName());
        existingUser.setFirstName(updatedPerson.getFirstName());
        existingUser.setPassword(passwordEncoder.encode(updatedPerson.getPassword()));

        UserLogin userLogin = new UserLogin(existingUser.getEmail(), existingUser.getPassword(), existingUser.getIdU(),
        existingUser.getFirstName(), existingUser.getLastName(), existingUser.getImgPath());
        return userLogin;
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