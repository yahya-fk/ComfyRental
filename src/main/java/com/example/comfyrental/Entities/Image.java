package com.example.comfyrental.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdI;
    private String ImagePath;
    @Lob
    @Column(nullable = true, columnDefinition="longblob")
    private byte[] img;
    @ManyToOne
    private Local local;

}
