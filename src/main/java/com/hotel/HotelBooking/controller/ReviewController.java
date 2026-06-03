package com.hotel.HotelBooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.HotelBooking.entity.Review;
import com.hotel.HotelBooking.service.ReviewService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ReviewController {


private final ReviewService reviewService;

public ReviewController(
        ReviewService reviewService) {

    this.reviewService = reviewService;
}

// =========================
// REVIEW MANAGEMENT
// ADMIN / SUPERADMIN ONLY
// =========================
@GetMapping("/reviews")
public String reviewsPage(
        Model model,
        HttpSession session){

    if(session.getAttribute("userId") == null){
        return "redirect:/login";
    }

    String role =
            (String) session.getAttribute("role");

    if(
        !"admin".equalsIgnoreCase(role)
        &&
        !"superadmin".equalsIgnoreCase(role)
    ){
        return "redirect:/rooms?error=access";
    }

    model.addAttribute(
            "reviews",
            reviewService.findAll()
    );

    return "reviews";
}

// =========================
// ADD REVIEW
// USER / ADMIN / SUPERADMIN
// =========================
@PostMapping("/addReview")
public String addReview(

        @RequestParam("customer_name")
        String customerName,

        @RequestParam("review_text")
        String reviewText,

        @RequestParam("rating")
        Integer rating,

        HttpSession session

){

    try {

        if(session.getAttribute("userId") == null){
            return "redirect:/login";
        }

        if(customerName == null
                || customerName.trim().isEmpty()){

            return "redirect:/?error=name";
        }

        if(reviewText == null
                || reviewText.trim().isEmpty()){

            return "redirect:/?error=review";
        }

        if(rating == null
                || rating < 1
                || rating > 5){

            return "redirect:/?error=rating";
        }

        Review review = new Review();

        review.setCustomerName(
                customerName.trim()
        );

        review.setReviewText(
                reviewText.trim()
        );

        review.setRating(rating);

        reviewService.save(review);

        return "redirect:/?msg=review-success";

    } catch(Exception e){

        e.printStackTrace();

        return "redirect:/?error=server";
    }
}


}
