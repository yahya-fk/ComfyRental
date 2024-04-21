package com.example.comfyrental.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
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
