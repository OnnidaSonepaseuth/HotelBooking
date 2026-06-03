package com.hotel.HotelBooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.HotelBooking.entity.User;
import com.hotel.HotelBooking.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {


@Autowired
private UserService userService;

// =========================
// USERS LIST
// =========================
@GetMapping("/users")
public String users(
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
            "users",
            userService.findAll()
    );

    return "users";
}

// =========================
// OPEN ADD USER PAGE
// =========================
@GetMapping("/add-user")
public String addUserPage(
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

    return "addUser";
}

// =========================
// OPEN EDIT USER PAGE
// =========================
@GetMapping("/edit-user")
public String editUser(
        @RequestParam Integer id,
        Model model,
        HttpSession session){

    if(session.getAttribute("userId") == null){
        return "redirect:/login";
    }

    String currentRole =
            (String) session.getAttribute("role");

    User user =
            userService.findById(id);

    if(user == null){
        return "redirect:/users";
    }

    boolean allow = false;

    if("superadmin".equalsIgnoreCase(currentRole)){
        allow = true;
    }
    else if(
            "admin".equalsIgnoreCase(currentRole)
            &&
            "user".equalsIgnoreCase(user.getRole())
    ){
        allow = true;
    }

    if(!allow){
        return "redirect:/users?error=access";
    }

    model.addAttribute(
            "editUser",
            user
    );

    return "editUser";
}

// =========================
// UPDATE USER
// =========================
@PostMapping("/updateUser")
public String updateUser(
        Integer id,
        String username,
        String password,
        String role,
        HttpSession session){

    try {

        if(session.getAttribute("userId") == null){
            return "redirect:/login";
        }

        String currentRole =
                (String) session.getAttribute("role");

        Integer currentUserId =
                (Integer) session.getAttribute("userId");

        User targetUser =
                userService.findById(id);

        if(targetUser == null){
            return "redirect:/users";
        }

        String targetRole =
                targetUser.getRole();

        boolean allow = false;

        // SUPERADMIN
        if("superadmin".equalsIgnoreCase(currentRole)){
            allow = true;
        }

        // ADMIN EDIT USER ONLY
        else if(
                "admin".equalsIgnoreCase(currentRole)
                &&
                "user".equalsIgnoreCase(targetRole)
        ){
            allow = true;
            role = "user";
        }

        // USER EDIT OWN PROFILE
        else if(
                "user".equalsIgnoreCase(currentRole)
                &&
                currentUserId.equals(id)
        ){
            allow = true;
            role = "user";
        }

        if(!allow){
            return "redirect:/users?error=access";
        }

        userService.updateUser(
                id,
                username,
                password,
                role
        );

        if(
            "superadmin".equalsIgnoreCase(currentRole)
            ||
            "admin".equalsIgnoreCase(currentRole)
        ){
            return "redirect:/users?msg=updated";
        }

        return "redirect:/profile?msg=updated";

    } catch(Exception e){

        e.printStackTrace();

        return "redirect:/users?error=server";
    }
}
}
