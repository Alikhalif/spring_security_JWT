package com.youcode.reviews_jwt.service;

import com.youcode.reviews_jwt.dto.ReviewDTO;
import com.youcode.reviews_jwt.repository.ReviewsRepository;
import com.youcode.reviews_jwt.repository.UserRepository;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.UUID;

public interface ReviewService {
    ReviewDTO getReviewById(UUID id);

    List<ReviewDTO> getAllReviews();

    void deleteReview(UUID id);

    //void makeClaim(UUID id);

    List<ReviewDTO> calimedReviews();
}
