package com.example.comfyrental.Models;

import com.example.comfyrental.Entities.Bill;
import com.example.comfyrental.Entities.Local;
import com.example.comfyrental.Entities.User;
import com.example.comfyrental.Enums.BookingStatusEnums;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingModel {
    private long idB;
    private Date dateB;
    private Date dateStart;
    private Date dateEnd;
    private Double price;
    private BookingStatusEnums bookingStatus=BookingStatusEnums.waitPayment;
}
