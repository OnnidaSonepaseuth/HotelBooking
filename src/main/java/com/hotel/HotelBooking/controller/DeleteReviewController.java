package com.hotel.HotelBooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.hotel.HotelBooking.service.ReviewService;

@Controller
public class DeleteReviewController {

    private final ReviewService reviewService;

    public DeleteReviewController(
            ReviewService reviewService) {

        this.reviewService = reviewService;
    }

    @GetMapping("/delete-review")
    public String deleteReview(Integer id){

        reviewService.delete(id);

        return "redirect:/reviews?msg=deleted";
    }
}