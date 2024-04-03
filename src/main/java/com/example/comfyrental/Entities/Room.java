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
    public Room(){
        super();
    }
    public Room(Double price, Long nbrBed, Double pricePerBed, Local local) {
        this.price = price;
        this.nbrBed = nbrBed;
        this.pricePerBed = pricePerBed;
        this.local = local;
    }

    @Override
    public String toString() {
        return "Room{" +
                "IdRoom=" + IdRoom +
                ", price=" + price +
                ", nbrBed=" + nbrBed +
                ", pricePerBed=" + pricePerBed +
                ", local=" + local +
                '}';
    }

    public Long getIdRoom() {
        return IdRoom;
    }

    public void setIdRoom(Long idRoom) {
        IdRoom = idRoom;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getNbrBed() {
        return nbrBed;
    }

    public void setNbrBed(Long nbrBed) {
        this.nbrBed = nbrBed;
    }

    public Double getPricePerBed() {
        return pricePerBed;
    }

    public void setPricePerBed(Double pricePerBed) {
        this.pricePerBed = pricePerBed;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }
}
