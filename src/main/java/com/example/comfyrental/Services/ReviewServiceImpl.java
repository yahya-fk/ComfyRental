package com.example.comfyrental.Services;

import com.example.comfyrental.Entities.Review;
import com.example.comfyrental.Entities.Room;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService{

    @Override
    public Review saveReview(Review review) {
        return null;
    }

    @Override
    public Review updateReview(Review review) {
        return null;
    }

    @Override
    public Review findReviewById(long id) {
        return null;
    }

    @Override
    public List<Review> findAllReviews() {
        return null;
    }

    @Override
    public void deleteAllReviews() {

    }

    @Override
    public void deleteReviewById(long id) {

    }
}
