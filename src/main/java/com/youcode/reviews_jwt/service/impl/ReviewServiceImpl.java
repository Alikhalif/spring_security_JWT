package com.youcode.reviews_jwt.service.impl;

import com.youcode.reviews_jwt.dto.ReviewDTO;
import com.youcode.reviews_jwt.entity.Reviews;
import com.youcode.reviews_jwt.repository.ReviewsRepository;
import com.youcode.reviews_jwt.repository.UserRepository;
import com.youcode.reviews_jwt.service.ReviewService;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class ReviewServiceImpl implements ReviewService {
    private final ReviewsRepository reviewRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    public ReviewServiceImpl(ReviewsRepository reviewRepository, UserRepository userRepository, ModelMapper modelMapper){
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }
    // @PreAuthorize("hasAnyRole(Role.USER, Role.ADMIN)")
    // @Override
    // public ReviewDTO saveReview(ReviewDTO reviewDTO) {
    //     var user = userRepository.findByUsername(
    //         SecurityUtils.getSessionUser()
    //     ).get();
    //     var review = modelMapper.map(reviewDTO, Review.class);
    //     review.setUser(user);
    //     review.setDate(LocalDate.now());

    //     return modelMapper.map(reviewRepository.save(review), ReviewDTO.class);
    // }
    @Override
    public ReviewDTO getReviewById(UUID id) {
        return modelMapper.map(reviewRepository.findById(id).orElse(null), ReviewDTO.class);
    }

    @Override
    public List<ReviewDTO> getAllReviews() {
        return Arrays.asList(modelMapper.map(reviewRepository.findAll(), ReviewDTO[].class));
    }
    @PreAuthorize("hasAnyRole(Role.USER, Role.ADMIN)")
    @Override
    public void deleteReview(UUID id) {
        reviewRepository.deleteById(id);
    }
    // @PreAuthorize("hasRole(Role.MODERATOR)")
    // @Override
    // public void makeClaim(UUID id) {
    //     var user = userRepository.findByUsername(
    //         SecurityUtils.getSessionUser()
    //     ).get();
    //     var review = reviewRepository.findById(id).get();
    //     var list = review.getClaimedUser();
    //     list.add(user);
    //     review.setClaimedUser(list);
    //     reviewRepository.save(review);
    // }
    @PreAuthorize("hasAnyRole(Role.MODERATOR, Role.ADMIN)")
    @Override
    public List<ReviewDTO> calimedReviews() {
        List<Reviews> claimes  = new ArrayList<>();
        for(Reviews r:reviewRepository.findAll())
            if(r.getClaimedUser() != null || r.getClaimedUser().size() > 0)
                claimes.add(r);
        return Arrays.asList(modelMapper.map(claimes, ReviewDTO[].class));
    }
}
