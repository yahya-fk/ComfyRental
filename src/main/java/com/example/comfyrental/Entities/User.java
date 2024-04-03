package com.example.comfyrental.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idU;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String password;
    @Column(unique = true)
    private String imgPath;
    @OneToMany(mappedBy = "user")
    private List<Booking> bookingList = new ArrayList<>();
    @ManyToMany(mappedBy = "userList")
    private List<Local> localList =new ArrayList();
    @OneToMany(mappedBy = "user")
    private List<Hosting> hostingList = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<Review> reviewList = new ArrayList<>();
}
