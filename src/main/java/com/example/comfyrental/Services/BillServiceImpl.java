package com.example.comfyrental.Services;

import com.example.comfyrental.Entities.Bill;
import com.example.comfyrental.Repositories.BillRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BillServiceImpl implements BillService{
    private BillRepository billRepository;
    @Override
    public Bill saveBill(Bill bill) {
        return billRepository.save(bill);
    }

    @Override
    public Bill updateBill(Bill bill) {
        return billRepository.save(bill);
    }

    @Override
    public Bill findBillById(long id) {
        return billRepository.findById(id).get();
    }

    @Override
    public List<Bill> findAllBills() {
        return billRepository.findAll();
    }

    @Override
    public Page<Bill> findAllBills(int page, int size) {
        return billRepository.findAll(PageRequest.of(page,size));

    }

    @Override
    public void deleteAllBills() {
        billRepository.deleteAll();
    }

    @Override
    public void deleteBillById(long id) {
        billRepository.deleteById(id);
    }
}
