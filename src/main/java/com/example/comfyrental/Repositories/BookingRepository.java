package com.example.comfyrental.Repositories;

import com.example.comfyrental.Entities.Booking;
import com.example.comfyrental.Entities.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Locale;

@Repository

public interface BookingRepository extends JpaRepository<Booking,Long> {
    List<Booking> findByLocal_IdL(Long local);
    List<Booking> findByLocal_IdLAndUser_IdU(long local,String user);
}
