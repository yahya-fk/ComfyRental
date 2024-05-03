package com.example.comfyrental.RestControllers;

import com.example.comfyrental.Entities.Bill;
import com.example.comfyrental.Entities.Local;
import com.example.comfyrental.Entities.User;
import com.example.comfyrental.Enums.BillMethodEnums;
import com.example.comfyrental.Enums.BillStatusEnums;
import com.example.comfyrental.Enums.BookingStatusEnums;
import com.example.comfyrental.Models.BookingModel;
import com.example.comfyrental.Models.BookingSaveModel;
import com.example.comfyrental.Services.BookingService;
import com.example.comfyrental.Entities.Booking;
import com.example.comfyrental.Services.LocalService;
import com.example.comfyrental.Services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Reservations")
@CrossOrigin(origins = "*")
public class BookingRestController {
    private final UserService userService;
    private final BookingService bookingService;
    private final LocalService localService;

    @GetMapping(value = "/ShowALL/{user_idu}")
    public List<BookingModel> showBooking(@PathVariable String user_idu) {
        List<Booking> bookings = bookingService.findAllBookingByUserId(user_idu);

        if (bookings == null){
            return null;
        }

        List<BookingModel> bookingModels = new ArrayList<>();

        for (Booking booking : bookings) {
            BookingModel bookingModel = new BookingModel();
            bookingModel.setIdB(booking.getIdB());
            bookingModel.setDateB(booking.getDateB());
            bookingModel.setDateStart(booking.getDateStart());
            bookingModel.setDateEnd(booking.getDateEnd());
            bookingModel.setPrice(booking.getPrice());
            bookingModel.setBookingStatus(booking.getBookingStatus());
            bookingModels.add(bookingModel);
        }

        return bookingModels;
    }

    @PostMapping (value = "/save")
    public String saveBooking(@RequestBody BookingSaveModel bookingSaveModel){
        try{
            if(!bookingService.findAllBookingByLocalAndUser(bookingSaveModel.getLocalId(),bookingSaveModel.getUserId()).isEmpty()) return "The request already sent";
            for (Booking booking: bookingService.findAllBookingByLocal(bookingSaveModel.getLocalId())){
                System.out.println(booking.getLocal().getIdL());
                if(booking.getBookingStatus()==BookingStatusEnums.active ) return "Local already booked :(";
            }
            Local local=localService.findLocalById(bookingSaveModel.getLocalId());
            Booking booking=new Booking();
            booking.setBookingStatus(BookingStatusEnums.OnHold);
            long numberOfDays =ChronoUnit.DAYS.between(local.getHostingList().get(0).getDateStart().toLocalDate(), local.getHostingList().get(0).getDateEnd().toLocalDate());
            booking.setPrice(Long.parseLong(local.getPrice())*numberOfDays);
            booking.setDateStart(local.getHostingList().get(0).getDateStart());
            booking.setDateEnd(local.getHostingList().get(0).getDateEnd());
            java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
            booking.setDateB(currentDate);
            booking.setLocal(local);
            booking.setUser(userService.findUserById(bookingSaveModel.getUserId()));
            bookingService.saveBooking(booking);
            return "booking request sent check your booking request :)";
        }catch (Exception e){
            return "error :"+e.getMessage();
        }

    }
}
