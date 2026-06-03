package com.hotel.HotelBooking.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.HotelBooking.entity.Booking;
import com.hotel.HotelBooking.repository.BookingRepository;
import com.hotel.HotelBooking.repository.RoomRepository;
import com.hotel.HotelBooking.repository.UserRepository;

@Service
public class ReportService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoomRepository roomRepository;

    // ========================
    // TOTAL BOOKINGS
    // ========================
    public long getTotalBookings(){

        return bookingRepository.count();
    }

    // ========================
    // TOTAL USERS
    // ========================
    public long getTotalUsers(){

        return userRepository.count();
    }

    // ========================
    // TOTAL ROOMS
    // ========================
    public long getTotalRooms(){

        return roomRepository.count();
    }

    // ========================
    // REVENUE
    // ========================
    public double getRevenue(){

        double revenue = 0;

        List<Booking> bookings =
                bookingRepository.findAll();

        for(Booking booking : bookings){

            if(
                booking.getRoom() != null
            ){

                revenue +=
                        booking.getRoom()
                               .getPrice();
            }
        }

        return revenue;
    }

    // ========================
    // CHART LABELS
    // ========================
    public List<String> getChartLabels(){

        return Arrays.asList(
                "Mon",
                "Tue",
                "Wed",
                "Thu",
                "Fri",
                "Sat",
                "Sun"
        );
    }

    // ========================
    // CHART DATA
    // ========================
    public List<Integer> getChartData(){

        return Arrays.asList(
                5,8,3,9,12,7,4
        );
    }
}