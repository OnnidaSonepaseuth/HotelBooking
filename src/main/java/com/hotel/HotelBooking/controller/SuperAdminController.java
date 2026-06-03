package com.hotel.HotelBooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hotel.HotelBooking.service.BookingService;
import com.hotel.HotelBooking.service.RoomService;
import com.hotel.HotelBooking.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class SuperAdminController {

@Autowired
private UserService userService;

@Autowired
private RoomService roomService;

@Autowired
private BookingService bookingService;

// =========================
// SUPER ADMIN DASHBOARD
// =========================
@GetMapping("/superadmin")

public String superAdmin(
        Model model,
        HttpSession session) {

    // ===== LOGIN CHECK =====

    if(session.getAttribute("userId") == null) {

        return "redirect:/login";
    }
    System.out.println("SESSION USER = "
            + session.getAttribute("username"));

    System.out.println("SESSION ROLE = "
            + session.getAttribute("role"));
    // ===== ROLE CHECK =====

    String role =
            (String) session.getAttribute("role");

    if(role == null ||
       !"superadmin".equalsIgnoreCase(role)) {

        return "redirect:/rooms?error=access";
    }

    // ===== DASHBOARD DATA =====

    model.addAttribute(
            "users",
            userService.countUsers()
    );

    model.addAttribute(
            "rooms",
            roomService.countRooms()
    );

    model.addAttribute(
            "bookings",
            bookingService.countBookings()
    );

    model.addAttribute(
            "username",
            session.getAttribute("username")
    );

    return "superadmin";
    
}
}
