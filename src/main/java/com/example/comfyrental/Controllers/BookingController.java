package com.example.comfyrental.Controllers;

import com.example.comfyrental.Entities.Bill;
import com.example.comfyrental.Entities.Booking;
import com.example.comfyrental.Services.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("Booking")
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
        return "Booking/BookingList";
    }
    @RequestMapping("/deleteBooking")
    public String deleteUser(@RequestParam("id") long id , ModelMap modelMap, ModelMap model){
        try {
            bookingService.deleteBookingById(id);
            List<Booking> bookingList=bookingService.findAllBookings();
            modelMap.addAttribute("bookingList", bookingList);
            model.addAttribute("successMessage", "Booking Deleted successfully!");
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Failed to delete booking: " + e.getMessage());
        }

        return "Booking/BookingList";
    }
}
