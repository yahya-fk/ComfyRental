package com.example.comfyrental.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

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
    public Review(){
        super();
    }
    public Review(User user, Local local, String comment, Long nbrStar) {
        this.user = user;
        this.local = local;
        this.comment = comment;
        this.nbrStar = nbrStar;
    }

    @Override
    public String toString() {
        return "Review{" +
                "idR=" + idR +
                ", user=" + user +
                ", local=" + local +
                ", comment='" + comment + '\'' +
                ", nbrStar=" + nbrStar +
                '}';
    }

    public long getIdR() {
        return idR;
    }

    public void setIdR(long idR) {
        this.idR = idR;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getNbrStar() {
        return nbrStar;
    }

    public void setNbrStar(Long nbrStar) {
        this.nbrStar = nbrStar;
    }
}
