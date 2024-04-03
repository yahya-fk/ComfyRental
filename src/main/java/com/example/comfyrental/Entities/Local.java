package com.example.comfyrental.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Local {
    @Id
    private long idL;
    @OneToMany(mappedBy = "local")
    private List<Booking> bookingList = new ArrayList<>();
    @OneToMany(mappedBy = "local")
    private List<Favorite> favoriteList = new ArrayList<>();
    @OneToMany(mappedBy = "local")
    private List<Hosting> hostingList = new ArrayList<>();
    @OneToMany(mappedBy = "local")
    private List<Review> reviewList = new ArrayList<>();
    @OneToMany(mappedBy = "local")
    private List<Image> ImagesList = new ArrayList<>();

    @OneToMany(mappedBy = "local")
    private List<Room> RoomList = new ArrayList<>();
    private String addresse;
    private String city;
    private String type;

}
