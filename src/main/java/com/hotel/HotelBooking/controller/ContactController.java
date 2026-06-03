package com.hotel.HotelBooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.HotelBooking.entity.Contact;
import com.hotel.HotelBooking.service.ContactService;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    // เปิดหน้า contact.html
    @GetMapping("/contact")
    public String contactPage() {

        return "contact";
    }

    // บันทึกข้อมูล Contact
    @PostMapping("/contact")
    public String saveContact(

            @RequestParam(required = false)
            Integer userId,

            @RequestParam
            String name,

            @RequestParam
            String email,

            @RequestParam
            String subject,

            @RequestParam
            String message

    ){

        Contact contact = new Contact();

        contact.setUserId(userId);
        contact.setName(name);
        contact.setEmail(email);
        contact.setSubject(subject);
        contact.setMessage(message);

        contactService.save(contact);

        return "redirect:/contact?msg=success";
    }
}