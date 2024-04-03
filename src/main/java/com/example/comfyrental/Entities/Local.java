package com.example.comfyrental.Entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Local {
    @Id
    private long idL;
    @OneToMany(mappedBy = "local")
    private List<Booking> bookingList = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "Favorite")
    private List<User> userList =new ArrayList();
    @OneToMany(mappedBy = "local")
    private List<Hosting> hostingList = new ArrayList<>();
    @OneToMany(mappedBy = "local")
    private List<Review> reviewList = new ArrayList<>();
}
