package com.example.comfyrental.Entities;

import com.example.comfyrental.Models.LocalNew;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Data
@Entity
@NoArgsConstructor
public class Hosting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idH;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private java.sql.Date dateH;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private java.sql.Date dateStart;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private java.sql.Date dateEnd;
    @ManyToOne
    private User user;
    @ManyToOne
    private Local local;
    @Override
    public String toString() {
        return "Hosting{" +
                "idH=" + idH +
                ", dateH=" + dateH +
                ", dateStart=" + dateStart +
                ", dateEnd=" + dateEnd +
                '}';
    }

    public Hosting(LocalNew localNew) {
        this.dateH = new Date(System.currentTimeMillis());
        this.dateStart = localNew.getDateStart();
        this.dateEnd = localNew.getDateEnd();
    }
}
