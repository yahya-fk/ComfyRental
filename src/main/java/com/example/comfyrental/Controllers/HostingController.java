package com.example.comfyrental.Controllers;

import com.example.comfyrental.Entities.Hosting;
import com.example.comfyrental.Services.HostingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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
        return "Hosting/hostingList";
    }
}
