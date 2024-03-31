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

}