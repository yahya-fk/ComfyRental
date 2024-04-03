package com.example.comfyrental.Controllers;

import com.example.comfyrental.Services.LocalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor


public class LocalController {
    private LocalService localService;
    @RequestMapping("/createLocal")
    public String createLocl(){
        return "Local/createLocal";
    }
}
