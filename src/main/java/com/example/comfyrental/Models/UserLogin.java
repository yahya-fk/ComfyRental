package com.example.comfyrental.Models;

import com.example.comfyrental.Entities.Booking;
import com.example.comfyrental.Entities.Hosting;
import com.example.comfyrental.Entities.Local;
import com.example.comfyrental.Entities.Review;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLogin {
    private String email;
    private String password;
    private String idU;
    private String firstName;
    private String lastName;
    private String imgPath;


}
