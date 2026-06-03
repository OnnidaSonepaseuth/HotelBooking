package com.hotel.HotelBooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hotel.HotelBooking.service.ContactService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MessagesController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/messages")
    public String messages(
            Model model,
            HttpSession session){

        // Login Check
        if(session.getAttribute("userId") == null){

            return "redirect:/login";
        }

        String role =
                (String) session.getAttribute("role");

        // Allow only admin and superadmin
        if(
            !"admin".equals(role)
            &&
            !"superadmin".equals(role)
        ){

            return "redirect:/login";
        }

        model.addAttribute(
                "contacts",
                contactService.findAll()
        );

        model.addAttribute(
                "role",
                role
        );

        return "messages";
    }
}