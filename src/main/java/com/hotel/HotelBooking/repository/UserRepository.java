package com.hotel.HotelBooking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.HotelBooking.entity.User;

public interface UserRepository
        extends JpaRepository<User, Integer> {

    // =========================
    // FIND USERNAME
    // =========================
    User findByUsername(
            String username
    );

    // =========================
    // OPTIONAL USERNAME
    // =========================
    Optional<User> findOptionalByUsername(
            String username
    );

    // =========================
    // VALIDATION
    // =========================
    boolean existsByUsername(
            String username
    );

    boolean existsByEmail(
            String email
    );
}