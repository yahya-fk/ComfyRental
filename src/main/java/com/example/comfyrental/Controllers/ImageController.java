package com.example.comfyrental.Controllers;
import com.example.comfyrental.Entities.Image;
import com.example.comfyrental.Services.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class ImageController {
    private ImageService imageService;
    @RequestMapping("/createImage")
    public String createImage(){
        return "Image/createImage";
    }

}
