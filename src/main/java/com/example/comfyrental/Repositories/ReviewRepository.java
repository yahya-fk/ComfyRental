package com.example.comfyrental.Repositories;

import com.example.comfyrental.Entities.Bill;
import com.example.comfyrental.Entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
}
