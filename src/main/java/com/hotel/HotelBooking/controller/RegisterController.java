package com.hotel.HotelBooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.HotelBooking.entity.User;
import com.hotel.HotelBooking.repository.UserRepository;
import com.hotel.HotelBooking.service.UserService;

@Controller
public class RegisterController {


@Autowired
private UserService userService;

@Autowired
private UserRepository userRepository;

// =========================
// OPEN REGISTER PAGE
// =========================
@GetMapping("/register")
public String registerPage() {

    return "register";
}

// =========================
// REGISTER PROCESS
// =========================
@PostMapping("/register")
public String register(

        @RequestParam String username,

        @RequestParam String password,

        @RequestParam(required = false)
        String email,

        @RequestParam(required = false)
        String role

) {

    try {

        // ===== VALIDATION =====

        if(username == null || username.trim().isEmpty()) {

            return "redirect:/register?error=username";
        }

        if(password == null || password.trim().isEmpty()) {

            return "redirect:/register?error=password";
        }

        if(password.length() < 3) {

            return "redirect:/register?error=passwordlength";
        }

        // ===== DUPLICATE USERNAME =====

        if(userRepository.existsByUsername(
                username.trim())) {

            return "redirect:/register?error=exists";
        }

        // ===== DUPLICATE EMAIL =====

        if(email != null
                && !email.trim().isEmpty()
                && userRepository.existsByEmail(
                        email.trim())) {

            return "redirect:/register?error=email";
        }

        // ===== DEFAULT ROLE =====

        if(role == null || role.trim().isEmpty()) {

            role = "user";
        }

        // ===== CREATE USER =====

        User user = new User();

        user.setUsername(
                username.trim()
        );

        user.setPassword(
                password.trim()
        );

        user.setRole(
                role.trim()
        );

        if(email != null
                && !email.trim().isEmpty()) {

            user.setEmail(
                    email.trim()
            );
        }

        userService.save(user);

        // ===== USER REGISTER =====

        if("user".equalsIgnoreCase(role)) {

            return "redirect:/login?success";
        }

        // ===== ADMIN ADD USER =====

        return "redirect:/users?msg=added";

    } catch(Exception e) {

        e.printStackTrace();

        return "redirect:/register?error=server";
    }
}


}
