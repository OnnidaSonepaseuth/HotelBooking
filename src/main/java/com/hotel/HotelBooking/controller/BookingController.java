package com.hotel.HotelBooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.hotel.HotelBooking.entity.Booking;
import com.hotel.HotelBooking.entity.Room;
import com.hotel.HotelBooking.entity.User;
import com.hotel.HotelBooking.service.BookingService;
import com.hotel.HotelBooking.service.RoomService;
import com.hotel.HotelBooking.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class BookingController {

@Autowired
private BookingService bookingService;

@Autowired
private UserService userService;

@Autowired
private RoomService roomService;

// =========================
// BOOK ROOM
// =========================
@PostMapping("/booking")
public String bookingRoom(
        Integer room_id,
        String check_in,
        String check_out,
        HttpSession session) {

    try {

        if(session.getAttribute("userId") == null) {
            return "redirect:/login";
        }

        if(room_id == null ||
           check_in == null ||
           check_out == null ||
           check_in.isEmpty() ||
           check_out.isEmpty()) {

            return "redirect:/rooms?error=missing";
        }

        Integer userId =
                (Integer) session.getAttribute("userId");

        User user =
                userService.findById(userId);

        Room room =
                roomService.findById(room_id);

        if(user == null || room == null) {

            return "redirect:/rooms?error=invalid";
        }

        Booking booking = new Booking();

        booking.setUser(user);

        booking.setRoom(room);

        booking.setCheckIn(check_in);

        booking.setCheckOut(check_out);

        booking.setStatus("booked");

        bookingService.save(booking);

        return "redirect:/mybookings?success=booked";

    } catch(Exception e) {

        e.printStackTrace();

        return "redirect:/rooms?error=booking";
    }
}

// =========================
// CANCEL BOOKING
// =========================
@PostMapping("/cancelBooking")
public String cancelBooking(
        Integer booking_id,
        HttpSession session) {

    try {

        if(session.getAttribute("userId") == null) {

            return "redirect:/login";
        }

        Integer userId =
                (Integer) session.getAttribute("userId");

        if(booking_id == null) {

            return "redirect:/mybookings?error=missing";
        }

        Booking booking =
                bookingService.findById(booking_id);

        if(booking == null) {

            return "redirect:/mybookings?error=notfound";
        }

        if(!booking.getUser()
                   .getId()
                   .equals(userId)) {

            return "redirect:/mybookings?error=access";
        }

        booking.setStatus("cancelled");

        bookingService.save(booking);

        return "redirect:/mybookings?success=cancel";

    } catch(Exception e) {

        e.printStackTrace();

        return "redirect:/mybookings?error=server";
    }
}

// =========================
// ADMIN / USER ACTION
// =========================
@PostMapping("/booking/action")
public String bookingAction(
        Integer booking_id,
        String action,
        HttpSession session) {

    try {

        if(session.getAttribute("userId") == null) {

            return "redirect:/login";
        }

        if(booking_id == null ||
           action == null ||
           action.isEmpty()) {

            return "redirect:/mybookings?error=missing";
        }

        String role =
                (String) session.getAttribute("role");

        Booking booking =
                bookingService.findById(booking_id);

        if(booking == null) {

            return "redirect:/mybookings?error=notfound";
        }

        String status = booking.getStatus();

        // ===== ADMIN / SUPERADMIN =====

        if("admin".equalsIgnoreCase(role)
                || "superadmin".equalsIgnoreCase(role)) {

            if("checkin".equalsIgnoreCase(action)) {

                status = "checked_in";

            } else if("checkout".equalsIgnoreCase(action)) {

                status = "checked_out";

            } else if("cancel".equalsIgnoreCase(action)) {

                status = "cancelled";
            }

        }

        // ===== USER =====

        else {

            if("cancel".equalsIgnoreCase(action)) {

                status = "cancelled";

            } else {

                return "redirect:/mybookings?error=access";
            }
        }

        booking.setStatus(status);

        bookingService.save(booking);

        return "redirect:/mybookings?success=updated";

    } catch(Exception e) {

        e.printStackTrace();

        return "redirect:/mybookings?error=server";
    }
}
}
