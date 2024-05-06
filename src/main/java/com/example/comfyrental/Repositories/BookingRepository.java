package com.example.comfyrental.Repositories;

import com.example.comfyrental.Entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository

public interface BookingRepository extends JpaRepository<Booking,Long> {
    List<Booking> findByLocal_IdL(Long local);
    List<Booking> findByLocal_IdLAndUser_IdU(long local,String user);
}
