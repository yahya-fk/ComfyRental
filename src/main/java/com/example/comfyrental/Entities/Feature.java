package com.example.comfyrental.Entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdF;
    private Long nameFeature;
  @OneToMany(mappedBy = "feature")
    private List<LocalFeature> localFeaturesList = new ArrayList<>();


}
