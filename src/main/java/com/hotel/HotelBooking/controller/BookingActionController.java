package com.hotel.HotelBooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.hotel.HotelBooking.entity.Booking;
import com.hotel.HotelBooking.service.BookingService;

@Controller
public class BookingActionController {

    private final BookingService bookingService;

    public BookingActionController(
            BookingService bookingService) {

        this.bookingService = bookingService;
    }

    @PostMapping("/booking-action")
    public String bookingAction(
            Integer booking_id,
            String action){

        Booking booking =
                bookingService.findById(
                        booking_id);

        if(booking == null){

            return "redirect:/mybookings";
        }

        if("checkin".equals(action)){

            booking.setStatus(
                    "checked_in");
        }

        else if("checkout".equals(action)){

            booking.setStatus(
                    "checked_out");
        }

        else if("cancel".equals(action)){

            booking.setStatus(
                    "cancelled");
        }

        bookingService.save(booking);

        return "redirect:/mybookings";
    }
}