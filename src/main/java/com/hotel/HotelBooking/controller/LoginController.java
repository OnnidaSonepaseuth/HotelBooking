package com.hotel.HotelBooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.HotelBooking.entity.User;
import com.hotel.HotelBooking.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    // =========================
    // OPEN LOGIN PAGE
    // =========================
    @GetMapping("/login")
    public String loginPage(HttpSession session) {

        // ถ้า Login แล้ว ไม่ให้กลับมาหน้า Login
        if(session.getAttribute("userId") != null) {

            String role =
                    (String) session.getAttribute("role");

            if("superadmin".equalsIgnoreCase(role)) {
                return "redirect:/superadmin";
            }

            if("admin".equalsIgnoreCase(role)) {
                return "redirect:/dashboard";
            }

            return "redirect:/rooms";
        }

        return "login";
    }

    // =========================
    // LOGIN PROCESS
    // =========================
    @PostMapping("/login")
    public String login(

            @RequestParam String username,
            @RequestParam String password,

            HttpSession session

    ) {

        try {

            // Validation
            if(username == null || username.trim().isEmpty()) {
                return "redirect:/login?error=username";
            }

            if(password == null || password.trim().isEmpty()) {
                return "redirect:/login?error=password";
            }

            User user =
                    userService.login(
                            username.trim(),
                            password.trim()
                    );

            if(user == null) {

                return "redirect:/login?error=invalid";
            }

            // Create Session
            session.setAttribute(
                    "userId",
                    user.getId()
            );

            session.setAttribute(
                    "username",
                    user.getUsername()
            );

            session.setAttribute(
                    "role",
                    user.getRole()
            );
            System.out.println("LOGIN SUCCESS");
            System.out.println("USERNAME = " + user.getUsername());
            System.out.println("ROLE = " + user.getRole());

            // Redirect ตาม Role
            if("superadmin".equalsIgnoreCase(
                    user.getRole()
            )) {

                return "redirect:/superadmin";
            }

            if("admin".equalsIgnoreCase(
                    user.getRole()
            )) {

                return "redirect:/dashboard";
            }

            return "redirect:/rooms";

        } catch(Exception e) {

            e.printStackTrace();

            return "redirect:/login?error=server";
        }
    }
}