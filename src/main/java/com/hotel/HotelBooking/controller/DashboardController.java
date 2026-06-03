package com.hotel.HotelBooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hotel.HotelBooking.service.BookingService;
import com.hotel.HotelBooking.service.ReviewService;
import com.hotel.HotelBooking.service.RoomService;
import com.hotel.HotelBooking.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class DashboardController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private UserService userService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/dashboard")
    public String dashboard(
            Model model,
            HttpSession session){

        // ===== LOGIN CHECK =====

        if(session.getAttribute("userId") == null){
            return "redirect:/login";
        }

        // ===== ROLE CHECK =====

        String role =
                (String) session.getAttribute("role");

        if(
            !"admin".equalsIgnoreCase(role)
            &&
            !"superadmin".equalsIgnoreCase(role)
        ){
            return "redirect:/rooms?error=access";
        }

        // ===== DASHBOARD DATA =====

        model.addAttribute(
                "totalBookings",
                bookingService.countBookings()
        );

        model.addAttribute(
                "totalUsers",
                userService.countUsers()
        );

        model.addAttribute(
                "totalRooms",
                roomService.countRooms()
        );

        model.addAttribute(
                "totalReviews",
                reviewService.countReviews()
        );

        model.addAttribute(
                "recentBookings",
                bookingService.getRecentBookings()
        );

        // ===== CHART =====

        model.addAttribute(
                "chartLabels",
                bookingService.getChartLabels()
        );

        model.addAttribute(
                "chartData",
                bookingService.getChartData()
        );

        model.addAttribute(
                "username",
                session.getAttribute("username")
        );

        return "dashboard";
    }
}