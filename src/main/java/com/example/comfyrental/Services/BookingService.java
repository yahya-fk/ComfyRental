package com.example.comfyrental.Services;

import com.example.comfyrental.Entities.Booking;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookingService {
    Booking saveBooking(Booking booking);
    Booking updateBooking(Booking booking);
    Booking findBookingById(long id);
    List<Booking> findAllBookings();
    void deleteAllBookings();
    void deleteBookingById(long id);

}
