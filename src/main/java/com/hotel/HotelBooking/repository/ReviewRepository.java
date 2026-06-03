package com.hotel.HotelBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.HotelBooking.entity.Review;

public interface ReviewRepository
        extends JpaRepository<Review, Integer> {

}