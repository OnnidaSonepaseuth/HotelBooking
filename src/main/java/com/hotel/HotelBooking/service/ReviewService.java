package com.hotel.HotelBooking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hotel.HotelBooking.entity.Review;
import com.hotel.HotelBooking.repository.ReviewRepository;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(
            ReviewRepository reviewRepository) {

        this.reviewRepository = reviewRepository;
    }

    public List<Review> findAll() {

        return reviewRepository.findAll();
    }

    public Review save(Review review){

        return reviewRepository.save(review);
    }

    public void delete(Integer id){

        reviewRepository.deleteById(id);
    }
    public long countReviews(){

        return reviewRepository.count();
    }
}