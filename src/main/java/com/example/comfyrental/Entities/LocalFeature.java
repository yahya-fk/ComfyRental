package com.example.comfyrental.Entities;

import jakarta.persistence.*;

@Entity
public class LocalFeature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long Id;
    private Double Price;
    @ManyToOne
    private Local local;
    @ManyToOne
    private Feature feature;

}
