package com.hotel.HotelBooking.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hotel.HotelBooking.entity.Booking;
import com.hotel.HotelBooking.repository.BookingRepository;
@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(
            BookingRepository bookingRepository) {

        this.bookingRepository = bookingRepository;
    }

    public List<Booking> findAll(){

        return bookingRepository.findAll();
    }

    public List<Booking> findByUserId(Integer userId){

        return bookingRepository.findByUserId(userId);
    }

    public Booking findById(Integer id){

        return bookingRepository
                .findById(id)
                .orElse(null);
    }

    public Booking save(Booking booking){

        return bookingRepository.save(booking);
    }

    public long countBookings(){

        return bookingRepository.count();
    }

    public List<Booking> getRecentBookings(){

        return bookingRepository
                .findTop5ByOrderByIdDesc();
    }
    public List<String> getChartLabels(){

        return Arrays.asList(
            "Mon","Tue","Wed",
            "Thu","Fri","Sat","Sun"
        );
    }

    public List<Integer> getChartData(){

        return Arrays.asList(
            5,8,3,9,12,7,4
        );
    }
}