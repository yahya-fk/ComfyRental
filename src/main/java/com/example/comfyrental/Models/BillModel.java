package com.example.comfyrental.Models;

import com.example.comfyrental.Enums.BillMethodEnums;
import com.example.comfyrental.Enums.BillStatusEnums;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillModel {
    private long idBill;
    private Date dateBill;
    private float priceTotal;
    private BillStatusEnums billStatus;
    private BillMethodEnums billMethod;


}

