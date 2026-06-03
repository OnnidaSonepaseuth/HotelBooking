package com.hotel.HotelBooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.HotelBooking.entity.User;
import com.hotel.HotelBooking.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class DeleteUserController {

    @Autowired
    private UserService userService;

    @PostMapping("/delete-user")
    public String deleteUser(

            @RequestParam Integer id,
            HttpSession session

    ) {

        if(session.getAttribute("userId") == null){

            return "redirect:/login";
        }

        Integer currentUserId =
                (Integer) session.getAttribute("userId");

        String currentRole =
                (String) session.getAttribute("role");

        if(!"admin".equals(currentRole)
                &&
           !"superadmin".equals(currentRole)){

            return "redirect:/login";
        }

        User targetUser =
                userService.findById(id);

        if(targetUser == null){

            return "redirect:/users?error=notfound";
        }

        String targetRole =
                targetUser.getRole();

        // ห้ามลบตัวเอง
        if(currentUserId.equals(id)){

            return "redirect:/users?error=self";
        }

        // admin ลบได้เฉพาะ user
        if("admin".equals(currentRole)){

            if("admin".equals(targetRole)){

                return "redirect:/users?error=admin";
            }

            if("superadmin".equals(targetRole)){

                return "redirect:/users?error=superadmin";
            }
        }

        userService.deleteById(id);

        return "redirect:/users?msg=deleted";
    }
}