package com.example.comfyrental.Services;

import com.example.comfyrental.Entities.Review;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {
    Review saveReview(Review review);
    Review updateReview(Review review);
    Review findReviewById(long id);
    List<Review> findAllReviews();
    void deleteAllReviews();
    void deleteReviewById(long id);
}
