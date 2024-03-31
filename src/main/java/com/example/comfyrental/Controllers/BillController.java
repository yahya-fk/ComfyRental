package com.example.comfyrental.Controllers;

import com.example.comfyrental.Entities.Bill;
import com.example.comfyrental.Services.BillService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class BillController {
    private BillService billService;
    @RequestMapping("/createBill")
    public String createBill(){
        return "Bill/createBill";
    }
    @RequestMapping("saveBill")
    public String saveBill(@ModelAttribute("bill") Bill bill){
        //billService.saveBill(bill);
        return "Bill/createBill";
    }
    @RequestMapping("/billList")
    public String billList(ModelMap modelMap){
        List<Bill> billList=billService.findAllBills();
        modelMap.addAttribute("billList", billList);
        return "Bill/billList";
    }
}
