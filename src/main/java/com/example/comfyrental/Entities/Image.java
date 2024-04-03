package com.example.comfyrental.Entities;

import jakarta.persistence.*;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdI;
    private String ImagePath;
    @ManyToOne
    private Local local;

}
