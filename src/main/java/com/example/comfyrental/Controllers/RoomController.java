package com.example.comfyrental.Controllers;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class RoomController {
    @RequestMapping("/RoomList")
    public String allRoom(){
        return "/Room/RoomList";
    }

}
