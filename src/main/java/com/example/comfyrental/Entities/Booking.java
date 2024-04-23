package com.example.comfyrental.Entities;

import com.example.comfyrental.Enums.BookingStatusEnums;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long idB;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateB;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateStart;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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
