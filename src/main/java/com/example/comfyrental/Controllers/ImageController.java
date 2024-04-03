package com.example.comfyrental.Controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ImageController {
    @RequestMapping("/uploadImage")
    public String uploadImage(){
        return "Image/UploadImage";
    }

}
