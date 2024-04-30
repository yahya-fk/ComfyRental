package com.example.comfyrental.RestControllers;

import com.example.comfyrental.Entities.User;
import com.example.comfyrental.Models.UserLogin;
import com.example.comfyrental.Services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.nio.file.Files;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/Auth")
@CrossOrigin(origins = "*")
public class UserRestController {
    private final UserService userService;
    PasswordEncoder passwordEncoder;
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@RequestBody User user) {
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
    @PostMapping("/ProfileImage/upload")
    public String uploadProfileImage(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "Please select a file to upload.";
        }
        try {
            byte[] bytes = file.getBytes();
            String directory = "Images/Profile/";
            File dir = new File(directory);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            String fileName = UUID.randomUUID()+".jpg";
            Path filePath = Paths.get(directory, fileName);
            Files.write(filePath, bytes);
            System.out.println(dir.getAbsolutePath().replace("\\","/")+"/"+fileName);
            return dir.getAbsolutePath().replace("\\","/")+"/"+fileName;
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