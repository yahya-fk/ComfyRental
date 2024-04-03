package com.example.comfyrental.Services;

import com.example.comfyrental.Entities.Bill;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class LocalFeatureServiceImpl implements LocalFeatureService {
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
