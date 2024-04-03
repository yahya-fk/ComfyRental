package com.example.comfyrental.Entities;

import com.example.comfyrental.Enums.BillMethodEnums;
import com.example.comfyrental.Enums.BillStatusEnums;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBill ;
    private Date dateBill;
    private BillStatusEnums billStatus=BillStatusEnums.waitPayment;
    private BillMethodEnums billMethod=BillMethodEnums.None;
    @OneToMany(mappedBy = "bill")
    private List<Booking> bookingList = new ArrayList<>();
    @ManyToOne
    private User user;

    public Bill(Date dateBill, BillStatusEnums billStatus, BillMethodEnums billMethod, List<Booking> bookingList, User user) {
        this.dateBill = dateBill;
        this.billStatus = billStatus;
        this.billMethod = billMethod;
        this.bookingList = bookingList;
        this.user = user;
    }

    public long getIdBill() {
        return idBill;
    }

    public void setIdBill(long idBill) {
        this.idBill = idBill;
    }

    public Date getDateBill() {
        return dateBill;
    }

    public void setDateBill(Date dateBill) {
        this.dateBill = dateBill;
    }

    public BillStatusEnums getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(BillStatusEnums billStatus) {
        this.billStatus = billStatus;
    }

    public BillMethodEnums getBillMethod() {
        return billMethod;
    }

    public void setBillMethod(BillMethodEnums billMethod) {
        this.billMethod = billMethod;
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "idBill=" + idBill +
                ", dateBill=" + dateBill +
                ", billStatus=" + billStatus +
                ", billMethod=" + billMethod +
                ", bookingList=" + bookingList +
                ", user=" + user +
                '}';
    }
}
