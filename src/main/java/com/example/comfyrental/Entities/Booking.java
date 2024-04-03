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

}
