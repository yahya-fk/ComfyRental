package com.example.comfyrental.Services;

import com.example.comfyrental.Entities.Bill;
import com.example.comfyrental.Repositories.BillRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BillServiceImpl implements BillService{
    BillRepository billRepository;
    @Override
    public Bill saveBill(Bill bill) {
        return null;
    }

    @Override
    public Bill updateBill(Bill bill) {
        return null;
    }

    @Override
    public Bill findBillById(long id) {
        return null;
    }

    @Override
    public List<Bill> findAllBills() {
        return null;
    }

    @Override
    public void deleteAllBills() {

    }

    @Override
    public void deleteBillById(long id) {

    }
}
