package com.example.comfyrental.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Hosting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idH;
    private Date dateH;
    @ManyToOne
    private User user;
    @ManyToOne
    private Local local;


}
