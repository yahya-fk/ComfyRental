package com.example.comfyrental.Models;


import com.example.comfyrental.Entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileModel {
    private String idU;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private byte[] img;

    public UserProfileModel(User user){
        this.idU = user.getIdU();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.img = user.getImg();
    }
}
