package com.hotel.HotelBooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.HotelBooking.entity.User;
import com.hotel.HotelBooking.service.UserService;

@Controller
public class ForgotPasswordController {

@Autowired
private UserService userService;

// =========================
// OPEN FORGOT PAGE
// =========================
@GetMapping("/forgot")
public String forgotPage() {

    return "forgot";
}

// =========================
// RESET PASSWORD
// =========================
@PostMapping("/forgot-password")
public String forgotPassword(

        @RequestParam String username,

        @RequestParam String oldPassword,

        @RequestParam String newPassword

) {

    try {

        // ===== VALIDATION =====

        if(username == null ||
           username.trim().isEmpty()) {

            return "redirect:/forgot?error=username";
        }

        if(oldPassword == null ||
           oldPassword.trim().isEmpty()) {

            return "redirect:/forgot?error=oldpassword";
        }

        if(newPassword == null ||
           newPassword.trim().isEmpty()) {

            return "redirect:/forgot?error=newpassword";
        }

        if(newPassword.length() < 3) {

            return "redirect:/forgot?error=passwordlength";
        }

        // ===== VERIFY USER =====

        User user =
                userService.login(
                        username.trim(),
                        oldPassword.trim()
                );

        if(user == null) {

            return "redirect:/forgot?error=wrong";
        }

        // ===== UPDATE PASSWORD =====

        user.setPassword(
                newPassword.trim()
        );

        userService.save(user);

        return "redirect:/login?success=reset";

    } catch(Exception e) {

        e.printStackTrace();

        return "redirect:/forgot?error=server";
    }
}

}
