package com.example.comfyrental.Controllers;

import com.example.comfyrental.Repositories.FeatureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class FeatureController {
    private FeatureRepository featureRepository;
    @RequestMapping("/Features")
    public String FeaturesList(){
        return "Feature/FeatureList";
    }
}
