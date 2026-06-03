package com.hotel.HotelBooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hotel.HotelBooking.service.ReportService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ReportController {


private final ReportService reportService;

public ReportController(
        ReportService reportService) {

    this.reportService = reportService;
}

@GetMapping("/reports")
public String reports(
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

    // ===== REPORT DATA =====

    model.addAttribute(
            "totalBookings",
            reportService.getTotalBookings());

    model.addAttribute(
            "totalUsers",
            reportService.getTotalUsers());

    model.addAttribute(
            "totalRooms",
            reportService.getTotalRooms());

    model.addAttribute(
            "revenue",
            reportService.getRevenue());

    model.addAttribute(
            "chartLabels",
            reportService.getChartLabels());

    model.addAttribute(
            "chartData",
            reportService.getChartData());

    model.addAttribute(
            "username",
            session.getAttribute("username"));

    return "reports";
}

}
