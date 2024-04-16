package com.example.comfyrental.RestControllers;

import com.example.comfyrental.Entities.User;
import com.example.comfyrental.Models.UserLogin;
import com.example.comfyrental.Services.UserService;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@AllArgsConstructor
@RequestMapping("/Auth")
public class UserRestController {

    private final UserService userService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public User savePerson(@RequestBody User user) {
        return userService.saveUser(user);
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
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void Login(@RequestBody UserLogin userLogin) {
        User user =userService.findUserByEmail(userLogin.getEmail());
        if(user==null) System.out.println("ERROR");
        else {
            System.out.println(user.getIdU());
        }
    }
}