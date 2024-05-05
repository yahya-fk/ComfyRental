package com.example.comfyrental.Repositories;

import com.example.comfyrental.Entities.Booking;
import com.example.comfyrental.Services.BookingService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface BookingRepository extends JpaRepository<Booking,Long> {

}
