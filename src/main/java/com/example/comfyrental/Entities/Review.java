package com.example.comfyrental.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {
    @Id
    private long idR;
    @ManyToOne
    private User user;
    @ManyToOne
    private Local local;
    private String comment;
    private Long nbrStar;

}
