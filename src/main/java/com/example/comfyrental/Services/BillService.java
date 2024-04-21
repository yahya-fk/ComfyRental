package com.example.comfyrental.Services;


import com.example.comfyrental.Entities.Bill;
import com.example.comfyrental.Entities.Local;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BillService {
    Bill saveBill(Bill bill);
    Bill updateBill(Bill bill);
    Bill findBillById(long id);
    List<Bill> findAllBills();
    Page<Bill> findAllBills(int page , int size);
    void deleteAllBills();
    void deleteBillById(long id);

}
