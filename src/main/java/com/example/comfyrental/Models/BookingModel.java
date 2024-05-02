package com.example.comfyrental.Models;

import com.example.comfyrental.Enums.BookingStatusEnums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingModel {
    private long idB;
    private Date dateB;
    private Date dateStart;
    private Date dateEnd;
    private float price;
    private BookingStatusEnums bookingStatus=BookingStatusEnums.waitPayment;
}
