package com.hotel.HotelBooking.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

// =========================
// PRIMARY KEY
// =========================
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

// =========================
// USERNAME
// =========================
@Column(nullable = false, unique = true)
private String username;

// =========================
// PASSWORD
// =========================
@Column(nullable = false)
private String password;

// =========================
// ROLE
// user / admin / superadmin
// =========================
@Column(nullable = false)
private String role;

// =========================
// EMAIL
// =========================
@Column(unique = true)
private String email;

// =========================
// CONSTRUCTOR
// =========================
public User() {
}

// =========================
// GETTERS & SETTERS
// =========================

public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
}

public String getUsername() {
    return username;
}

public void setUsername(String username) {
    this.username = username;
}

public String getPassword() {
    return password;
}

public void setPassword(String password) {
    this.password = password;
}

public String getRole() {
    return role;
}

public void setRole(String role) {
    this.role = role;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

}
