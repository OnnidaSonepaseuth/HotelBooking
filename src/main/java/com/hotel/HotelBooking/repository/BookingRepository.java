package com.hotel.HotelBooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.HotelBooking.entity.Booking;

public interface BookingRepository
        extends JpaRepository<Booking,Integer>{

    List<Booking> findByUserId(Integer userId);

    List<Booking> findTop5ByOrderByIdDesc();
}