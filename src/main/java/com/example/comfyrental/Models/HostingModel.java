package com.example.comfyrental.Models;

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
public class HostingModel {
    private long idH;
    private java.sql.Date dateH;
    private java.sql.Date dateStart;
    private java.sql.Date dateEnd;



}
