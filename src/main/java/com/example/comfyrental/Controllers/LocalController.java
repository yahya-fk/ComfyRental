package com.example.comfyrental.Controllers;

import com.example.comfyrental.Entities.Local;
import com.example.comfyrental.Services.LocalService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
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
    public String localList(ModelMap modelMap ,@RequestParam ( name="page" , defaultValue = "0") int page ,@RequestParam ( name="size" , defaultValue = "5") int size ){
        Page<Local> localList =localService.findAllLocals(page, size);
        modelMap.addAttribute("localList",localList );
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("pages", new int[localList.getTotalPages()]);
        return "Local/LocalList";
    }

    @RequestMapping("/deleteLocal")
    public String deleteLocal(@RequestParam("id") long id, ModelMap modelMap, ModelMap model){
        try {
            localService.deleteLocalById(id);
            Page<Local> localList =localService.findAllLocals(0, 10);
            modelMap.addAttribute("localList", localList);

            model.addAttribute("successMessage", "Local Deleted successfully!");
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Failed to delete local: " + e.getMessage());
        }

        return "Local/LocalList";
    }

}
