package com.example.comfyrental.Services;

import com.example.comfyrental.Entities.User;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User saveUser(User user);
    User updateUser(User user);
    User findUserById(String id);
    User findUserByEmail(String email);
    List<User> findAllUsers();
    Page<User> findAllUsers(int page , int size);
    void deleteAllUsers();
    void deleteUserById(String id);
    public User findUserByImage(String image);}
