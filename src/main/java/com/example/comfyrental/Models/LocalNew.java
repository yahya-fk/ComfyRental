package com.example.comfyrental.Models;

import com.example.comfyrental.Enums.TypeEnums;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocalNew {
    private String address;
    private String city;
    private String type;
    private String descLocal;
    private String name;
    private String idU;
    private String price;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private java.sql.Date dateStart;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private java.sql.Date dateEnd;
}
