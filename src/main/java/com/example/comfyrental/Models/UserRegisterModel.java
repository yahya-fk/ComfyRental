package com.example.comfyrental.Models;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
@Data
public class UserRegisterModel {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

}
