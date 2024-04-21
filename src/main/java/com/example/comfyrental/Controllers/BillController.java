package com.example.comfyrental.Controllers;

import com.example.comfyrental.Entities.Bill;
import com.example.comfyrental.Entities.User;
import com.example.comfyrental.Services.BillService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/Bill")
public class BillController {
    private BillService billService;

   /* @RequestMapping("/createBill")
    public String createBill(){
        return "Bill/createBill";
    }
    @RequestMapping("saveBill")
    public String saveBill(@ModelAttribute("bill") Bill bill){
        //billService.saveBill(bill);
        return "Bill/createBill";
    }*/
    @RequestMapping("/billList")
    public String billList(ModelMap modelMap){
        List<Bill> billList=billService.findAllBills();
        modelMap.addAttribute("billList", billList);
        return "Bill/BillList";
    }
    @RequestMapping("/deleteBill")
    public String deleteUser(@RequestParam("id") long id , ModelMap modelMap,ModelMap model){
        try {
            billService.deleteBillById(id);
            List<Bill> billList=billService.findAllBills();
            modelMap.addAttribute("billList", billList);
            model.addAttribute("successMessage", "Bill Deleted successfully!");
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Failed to delete bill: " + e.getMessage());
        }

        return "Bill/billList";
    }
}
