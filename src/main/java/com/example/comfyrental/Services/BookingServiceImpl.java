package com.example.comfyrental.Services;

import com.example.comfyrental.Entities.Booking;
import com.example.comfyrental.Repositories.BookingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService{
    BookingRepository bookingRepository;
    @Override
    public Booking saveBooking(Booking booking) {
        return null;
    }

    @Override
    public Booking updateBooking(Booking booking) {
        return null;
    }

    @Override
    public Booking findBookingById(long id) {
        return null;
    }

    @Override
    public List<Booking> findAllBookings() {
        return null;
    }

    @Override
    public void deleteAllBookings() {

    }

    @Override
    public void deleteBookingById(long id) {

    }
}
