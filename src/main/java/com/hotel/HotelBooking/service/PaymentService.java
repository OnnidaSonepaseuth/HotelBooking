package com.hotel.HotelBooking.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.HotelBooking.entity.Booking;
import com.hotel.HotelBooking.repository.BookingRepository;

@Service
public class PaymentService {

    @Autowired
    private BookingRepository bookingRepository;

    public double getTotalRevenue(){

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

    public List<Integer> getChartData(){

        return Arrays.asList(
                5,8,3,9,12,7,4
        );
    }

    public List<Booking> getPayments(){

        return bookingRepository.findAll();
    }
}