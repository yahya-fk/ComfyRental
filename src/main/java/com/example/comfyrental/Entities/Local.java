package com.example.comfyrental.Entities;


import com.example.comfyrental.Enums.TypeEnums;
import com.example.comfyrental.Models.LocalNew;
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
@NoArgsConstructor
public class Local {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private TypeEnums type;
    private String descLocal;
    private String name;
    private String price;

    public Local(LocalNew localNew) {
        this.addresse = localNew.getAddress();
        this.city = localNew.getCity();
        this.type = TypeEnums.valueOf (localNew.getType());
        this.descLocal = localNew.getDescLocal();
        this.name = localNew.getName();
        this.price = localNew.getPrice();
    }
}
