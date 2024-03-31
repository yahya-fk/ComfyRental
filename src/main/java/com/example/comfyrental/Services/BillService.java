package com.example.comfyrental.Services;


import com.example.comfyrental.Entities.Bill;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BillService {
    Bill saveBill(Bill bill);
    Bill updateBill(Bill bill);
    Bill findBillById(long id);
    List<Bill> findAllBills();
    void deleteAllBills();
    void deleteBillById(long id);

}
