package com.hotel.HotelBooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hotel.HotelBooking.entity.User;
import com.hotel.HotelBooking.repository.UserRepository;

@Service
public class UserService {

@Autowired
private UserRepository userRepository;
@Autowired
private BCryptPasswordEncoder passwordEncoder;

// =========================
// FIND ALL USERS
// =========================
public List<User> findAll() {

    return userRepository.findAll();
}

// =========================
// LOGIN
// =========================
public User login(
        String username,
        String password) {

    if(username == null || password == null) {
        return null;
    }

    username = username.trim();
    password = password.trim();

    User user =
            userRepository.findByUsername(username);

    if(user == null) {
        return null;
    }

    if(passwordEncoder.matches(
            password,
            user.getPassword()
    )) {
        return user;
    }

    return null;
}

// =========================
// FIND USER BY ID
// =========================
public User findById(Integer id) {

    return userRepository
            .findById(id)
            .orElse(null);
}

// =========================
// FIND USERNAME
// =========================
public Optional<User> findByUsername(
        String username) {

    return userRepository
            .findOptionalByUsername(
                    username
            );
}

// =========================
// SAVE USER
// =========================
public User save(User user){

    user.setPassword(
            passwordEncoder.encode(
                    user.getPassword()
            )
    );

    return userRepository.save(user);
}

// =========================
// UPDATE USER
// =========================
public boolean updateUser(
        Integer id,
        String username,
        String password,
        String role) {

    User user =
            userRepository
                    .findById(id)
                    .orElse(null);

    if(user == null) {
        return false;
    }

    user.setUsername(
            username.trim()
    );

    user.setPassword(
            passwordEncoder.encode(
                    password.trim()
            )
    );

    user.setRole(role);

    userRepository.save(user);

    return true;
}

// =========================
// DELETE USER
// =========================
public boolean deleteById(
        Integer id) {

    if(!userRepository.existsById(id)) {
        return false;
    }

    userRepository.deleteById(id);

    return true;
}

// =========================
// TOTAL USERS
// =========================
public long countUsers() {

    return userRepository.count();
}
}
