package com.hotel.HotelBooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.hotel.HotelBooking.entity.Room;
import com.hotel.HotelBooking.service.RoomService;

import jakarta.servlet.http.HttpSession;

@Controller
public class RoomController {

@Autowired
private RoomService roomService;

// =========================
// VIEW ALL ROOMS
// =========================
@GetMapping("/rooms")
public String roomsPage(
        Model model,
        HttpSession session) {

    if(session.getAttribute("userId") == null) {

        return "redirect:/login";
    }

    model.addAttribute(
            "rooms",
            roomService.findAll()
    );

    return "rooms";
}

// =========================
// OPEN ADD ROOM PAGE
// =========================
@GetMapping("/admin")
public String adminPage(
        HttpSession session) {

    if(session.getAttribute("userId") == null) {

        return "redirect:/login";
    }

    String role =
            (String) session.getAttribute("role");

    if(!"admin".equalsIgnoreCase(role)
            &&
       !"superadmin".equalsIgnoreCase(role)) {

        return "redirect:/rooms";
    }

    return "admin";
}

// =========================
// ADD ROOM
// =========================
@PostMapping("/addRoom")
public String addRoom(

        String room_number,

        String type,

        Double price,

        HttpSession session

) {

    try {

        if(session.getAttribute("userId") == null) {

            return "redirect:/login";
        }

        String role =
                (String) session.getAttribute("role");

        if(!"admin".equalsIgnoreCase(role)
                &&
           !"superadmin".equalsIgnoreCase(role)) {

            return "redirect:/rooms";
        }

        // ===== VALIDATION =====

        if(room_number == null
                || room_number.trim().isEmpty()) {

            return "redirect:/admin?error=roomnumber";
        }

        if(type == null
                || type.trim().isEmpty()) {

            return "redirect:/admin?error=type";
        }

        if(price == null
                || price <= 0) {

            return "redirect:/admin?error=price";
        }

        // ===== CREATE ROOM =====

        Room room = new Room();

        room.setRoomNumber(
                room_number.trim()
        );

        room.setType(
                type.trim()
        );

        room.setPrice(price);

        room.setStatus("available");

        roomService.save(room);

        // ===== REDIRECT =====

        if("superadmin".equalsIgnoreCase(role)) {

            return "redirect:/superadmin?success=room";
        }

        return "redirect:/dashboard?success=room";

    } catch(Exception e) {

        e.printStackTrace();

        return "redirect:/admin?error=server";
    }
}
}
