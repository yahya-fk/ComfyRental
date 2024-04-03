package com.example.comfyrental.Entities;

<<<<<<< HEAD
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
=======
import jakarta.persistence.*;
>>>>>>> ea4c76643dc431dbf17034af6c262f3e749cb484

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
    @OneToMany(mappedBy = "local")
    private List<Image> ImagesList = new ArrayList<>();

    @OneToMany(mappedBy = "local")
    private List<Room> RoomList = new ArrayList<>();
    @OneToMany(mappedBy = "local")
    private List<LocalFeature> localFeatures = new ArrayList<>();
    private String addresse;
    private String city;
    private String type;
    private String name;


}
