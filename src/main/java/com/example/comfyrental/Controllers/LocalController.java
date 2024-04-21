package com.example.comfyrental.Controllers;

import com.example.comfyrental.Entities.Local;
import com.example.comfyrental.Services.LocalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/Local")
public class LocalController {
    private LocalService localService;
    @RequestMapping("/localList")
    public String localList(ModelMap modelMap){
        List<Local> localList =localService.findAllLocals();
        modelMap.addAttribute("localList",localList );
        return "Local/LocalList";
    }

    @RequestMapping("/deleteLocal")
    public String deleteLocal(@RequestParam("id") long id, ModelMap modelMap, ModelMap model){
        try {
            localService.deleteLocalById(id);
            List<Local> localList = localService.findAllLocals();
            modelMap.addAttribute("localList", localList);
            model.addAttribute("successMessage", "Local Deleted successfully!");
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Failed to delete local: " + e.getMessage());
        }

        return "Local/LocalList";
    }

}
