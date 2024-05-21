package com.example.comfyrental.Entities;

import com.example.comfyrental.Models.UserRegisterModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User{
    @Id
    private String idU;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String password;
    @Lob
    @Column(nullable = true, columnDefinition="longblob")
    private byte[] img;
    @OneToMany(mappedBy = "user")
    private List<Booking> bookingList = new ArrayList<>();
    @ManyToMany(mappedBy = "userList")
    private List<Local> localList =new ArrayList();
    @OneToMany(mappedBy = "user")
    private List<Hosting> hostingList = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<Review> reviewList = new ArrayList<>();


    public User(UserRegisterModel userRegisterModel) throws IOException {
        this.firstName=userRegisterModel.getFirstName();
        this.lastName=userRegisterModel.getLastName();
        this.email=userRegisterModel.getEmail();
        this.password=userRegisterModel.getPassword();
    }
    @Override
    public String toString() {
        return "User{" +
                "idU='" + idU + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}