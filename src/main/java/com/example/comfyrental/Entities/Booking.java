package com.example.comfyrental.Entities;

import com.example.comfyrental.Enums.BookingStatusEnums;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long idB;
    private Date dateB;
    private Date dateStart;
    private Date dateEnd;
    private float price;
    private BookingStatusEnums bookingStatus=BookingStatusEnums.waitPayment;
    @ManyToOne
    private Bill bill;
    @ManyToOne
    private User user;
    @ManyToOne
    private Local local;

    public Booking(Date dateB, Date dateStart, Date dateEnd, float price, BookingStatusEnums bookingStatus, Bill bill, User user, Local local) {
        this.dateB = dateB;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.price = price;
        this.bookingStatus = bookingStatus;
        this.bill = bill;
        this.user = user;
        this.local = local;
    }

    public long getIdB() {
        return idB;
    }

    public void setIdB(long idB) {
        this.idB = idB;
    }

    public Date getDateB() {
        return dateB;
    }

    public void setDateB(Date dateB) {
        this.dateB = dateB;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public BookingStatusEnums getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatusEnums bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
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
        return "Booking{" +
                "idB=" + idB +
                ", dateB=" + dateB +
                ", dateStart=" + dateStart +
                ", dateEnd=" + dateEnd +
                ", price=" + price +
                ", bookingStatus=" + bookingStatus +
                ", bill=" + bill +
                ", user=" + user +
                ", local=" + local +
                '}';
    }
}
