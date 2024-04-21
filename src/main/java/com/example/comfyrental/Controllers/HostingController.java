package com.example.comfyrental.Controllers;

import com.example.comfyrental.Entities.Booking;
import com.example.comfyrental.Entities.Hosting;
import com.example.comfyrental.Services.HostingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class HostingController {
    private HostingService hostingService;
    @RequestMapping("/createHosting")
    public String createHosting(){
        return "Hosting/createHosting";
    }
    @RequestMapping("saveHosting")
    public String saveHosting(@ModelAttribute("hosting") Hosting hosting){
        //hostingService.saveHosting(hosting);
        return "Hosting/createHosting";
    }
    @RequestMapping("/hostingList")
    public String hostingList(ModelMap modelMap){
        List<Hosting> hostingList=hostingService.findAllHosting();
        modelMap.addAttribute("HostingList", hostingList);
        return "Hosting/HostingList";
    }
    @RequestMapping("/deleteBooking")
    public String deleteUser(@RequestParam("id") long id , ModelMap modelMap, ModelMap model){
        try {
            hostingService.deleteHostingById(id);
            List<Hosting> hostingList=hostingService.findAllHosting();
            modelMap.addAttribute("HostingList", hostingList);
            model.addAttribute("successMessage", "Hosting Deleted successfully!");
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Failed to delete hosting: " + e.getMessage());
        }
        return "Hosting/HostingList";
    }
}
