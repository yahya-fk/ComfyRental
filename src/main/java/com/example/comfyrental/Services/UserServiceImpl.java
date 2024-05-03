package com.example.comfyrental.Services;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.example.comfyrental.ComfyRentalApplication;
import com.example.comfyrental.Entities.User;
import com.example.comfyrental.Repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    PasswordEncoder passwordEncoder;
    @Override
    public User saveUser(User user) {
        user.setIdU(UUID.randomUUID().toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserById(String id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }
    /*@Override
    public User findUserByImage(String image) {
        List<User> UserList =findAllUsers();
        for (User user:UserList) {
            if(image.equals(user.getImgPath())){
                return user;
            }
        }
        return null;
    }*/

    @Override
    public User saveUserImage(String userId, String imagePath) {
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Page<User> findAllUsers(int page, int size) {
        return userRepository.findAll(PageRequest.of(page,size));
    }

    @Override
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    @Override
    public void deleteUserById(String id) {
        userRepository.deleteById(id);
    }



}
