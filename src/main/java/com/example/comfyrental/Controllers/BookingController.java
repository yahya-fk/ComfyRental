package com.example.comfyrental.Controllers;

import com.example.comfyrental.Entities.Booking;
import com.example.comfyrental.Services.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class BookingController {
    private BookingService bookingService;
    @RequestMapping("/createBooking")
    public String createBooking(){
        return "Booking/createBooking";
    }
    @RequestMapping("saveBooking")
    public String saveBooking(@ModelAttribute("booking") Booking booking){
        //bookingService.saveBooking(booking);
        return "Booking/createBooking";
    }
    @RequestMapping("/bookingList")
    public String bookingList(ModelMap modelMap){
        List<Booking> bookingList=bookingService.findAllBookings();
        modelMap.addAttribute("bookingList", bookingList);
        return "Booking/bookingList";
    }
}
