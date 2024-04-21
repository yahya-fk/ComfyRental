package com.example.comfyrental.Services;

import com.example.comfyrental.Entities.Review;
import com.example.comfyrental.Entities.Room;
import com.example.comfyrental.Repositories.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService{
    ReviewRepository reviewRepository;
    @Override
    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review updateReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review findReviewById(long id) {
        return reviewRepository.findById(id).get();
    }

    @Override
    public List<Review> findAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public void deleteAllReviews() {
        reviewRepository.deleteAll();
    }

    @Override
    public void deleteReviewById(long id) {
        reviewRepository.deleteById(id);
    }
}
