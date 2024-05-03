package com.example.comfyrental.Services;

import com.example.comfyrental.Entities.Bill;
import com.example.comfyrental.Entities.Booking;
import com.example.comfyrental.Entities.Local;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookingService {
    Booking saveBooking(Booking booking);
    Booking updateBooking(Booking booking);
    Booking findBookingById(long id);
    List<Booking> findAllBookings();
    Page<Booking> findAllBookings(int page , int size);
    void deleteAllBookings();
    void deleteBookingById(long id);
    List<Booking> findAllBookingByLocal(long local);
    List<Booking> findAllBookingByLocalAndUser(long local,String user);
    List<Booking> findAllBookingByUserId(String id);
}
