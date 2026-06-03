package com.hotel.HotelBooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hotel.HotelBooking.service.BookingService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MyBookingController {

    private final BookingService bookingService;

    public MyBookingController(
            BookingService bookingService) {

        this.bookingService = bookingService;
    }

    @GetMapping("/mybookings")
    public String myBookings(
            HttpSession session,
            Model model){

        Integer userId =
                (Integer) session.getAttribute("userId");

        String role =
                (String) session.getAttribute("role");

        if(userId == null){

            return "redirect:/login";
        }

        if("admin".equals(role)
                || "superadmin".equals(role)){

            model.addAttribute(
                    "bookings",
                    bookingService.findAll());

        }else{

            model.addAttribute(
                    "bookings",
                    bookingService.findByUserId(userId));
        }

        model.addAttribute("role", role);
        model.addAttribute("userId", userId);

        return "mybookings";
    }
}