package com.example.comfyrental.RestControllers;

import com.example.comfyrental.Models.BookingModel;
import com.example.comfyrental.Services.BookingService;
import com.example.comfyrental.Entities.Booking;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Reservations")
@CrossOrigin(origins = "*")
public class BookingRestController {

    private final BookingService bookingService;

    @GetMapping(value = "/ShowALL/{user_idu}")
    public List<BookingModel> showBooking(@PathVariable String user_idu) {
        List<Booking> bookings = bookingService.findAllBookingByUserId(user_idu);

        if (bookings == null) {
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
    @DeleteMapping(value = "/Delete/{idB}")
    public String DeleteReservation(@PathVariable long idB) {

        try {
            bookingService.deleteBookingById(idB);
            System.out.println("Reservation deleted successfully");
            return "Reservation deleted successfully";
        } catch (Exception e) {
            System.out.println("Error Deleting Reservation");
            return "Error Deleting Reservation";
        }
    }

}
