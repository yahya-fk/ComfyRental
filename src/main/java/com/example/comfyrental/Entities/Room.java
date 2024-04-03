package com.example.comfyrental.Entities;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.AutoConfiguration;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdRoom;
    private Double price;
    private Long nbrBed;
    private Double pricePerBed;
    @ManyToOne
    private Local local;

}
