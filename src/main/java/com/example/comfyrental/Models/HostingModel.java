package com.example.comfyrental.Models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class HostingModel {
    private long idH;
    private java.sql.Date dateH;
    private java.sql.Date dateStart;
    private java.sql.Date dateEnd;



}
