package com.hotel.HotelBooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hotel.HotelBooking.service.PaymentService;

import jakarta.servlet.http.HttpSession;

@Controller
public class PaymentController {


@Autowired
private PaymentService paymentService;

@GetMapping("/payments")
public String payments(
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

    // ===== PAYMENT DATA =====

    model.addAttribute(
            "revenue",
            paymentService.getTotalRevenue()
    );

    model.addAttribute(
            "chartLabels",
            paymentService.getChartLabels()
    );

    model.addAttribute(
            "chartData",
            paymentService.getChartData()
    );

    model.addAttribute(
            "payments",
            paymentService.getPayments()
    );

    model.addAttribute(
            "username",
            session.getAttribute("username")
    );

    return "payments";
}

}
