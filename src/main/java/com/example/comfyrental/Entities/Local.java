package com.example.comfyrental.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
