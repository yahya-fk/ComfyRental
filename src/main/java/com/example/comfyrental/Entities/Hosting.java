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

    public Hosting(Date dateH, User user, Local local) {
        this.dateH = dateH;
        this.user = user;
        this.local = local;
    }

    public long getIdH() {
        return idH;
    }

    public void setIdH(long idH) {
        this.idH = idH;
    }

    public Date getDateH() {
        return dateH;
    }

    public void setDateH(Date dateH) {
        this.dateH = dateH;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    @Override
    public String toString() {
        return "Hosting{" +
                "idH=" + idH +
                ", dateH=" + dateH +
                ", user=" + user +
                ", local=" + local +
                '}';
    }
}
