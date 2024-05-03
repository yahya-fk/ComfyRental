package com.example.comfyrental.RestControllers;

import com.example.comfyrental.Entities.Booking;
import com.example.comfyrental.Entities.Hosting;
import com.example.comfyrental.Models.BookingModel;
import com.example.comfyrental.Models.HostingModel;
import com.example.comfyrental.Models.LocalDetailModel;
import com.example.comfyrental.Services.BookingService;
import com.example.comfyrental.Services.HostingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Hostings")
@CrossOrigin(origins = "*")
public class HostingRestController {
    private final HostingService hostingService;

    @GetMapping(value = "/ShowALL/{user_idu}")
    public List<LocalDetailModel> showBooking(@PathVariable String user_idu) {
       return hostingService.getHosetedLocalsByUserIds(user_idu);}
}
