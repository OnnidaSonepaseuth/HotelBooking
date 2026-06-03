package com.hotel.HotelBooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {

    @GetMapping("/blog")
    public String blog() {
        return "blog";
    }

    @GetMapping("/blog-single")
    public String blogSingle() {
        return "blog-single";
    }
}