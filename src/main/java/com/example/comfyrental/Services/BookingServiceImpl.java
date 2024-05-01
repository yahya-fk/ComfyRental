package com.example.comfyrental.Services;

import com.example.comfyrental.Entities.Booking;
import com.example.comfyrental.Entities.User;
import com.example.comfyrental.Repositories.BookingRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {
    BookingRepository bookingRepository;

    @Override
    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Booking updateBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Booking findBookingById(long id) {
        return bookingRepository.findById(id).get();
    }

    @Override
    public List<Booking> findAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Page<Booking> findAllBookings(int page, int size) {
        return bookingRepository.findAll(PageRequest.of(page, size));

    }

    @Override
    public void deleteAllBookings() {
        bookingRepository.deleteAll();
    }

    @Override
    public void deleteBookingById(long id) {
        bookingRepository.deleteById(id);
    }
@Override
    public List<Booking> findAllBookingByUserId(String id) {
        List<Booking> Lbu = new ArrayList<>();
        List<Booking> bookings = findAllBookings();
        for (Booking booking : bookings) {
            User x = booking.getUser();
            if (x != null && id.equals(x.getIdU())) {
                Lbu.add(booking);
            }
        }
        return Lbu;
    }
}
