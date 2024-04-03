package com.example.comfyrental.Controllers;

import com.example.comfyrental.Services.LocalFeatureService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class LocalFeatureController {
    private LocalFeatureService localFeatureService;
    @RequestMapping("/createLocalFeature")
    public String createFavorite(){
        return "LocalFeature/createLocalFeature";
    }
}
