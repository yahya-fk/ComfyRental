package com.example.comfyrental.Entities;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

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
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date dateR;
}
