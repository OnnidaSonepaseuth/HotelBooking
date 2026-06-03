package com.hotel.HotelBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.HotelBooking.entity.Contact;

public interface ContactRepository
        extends JpaRepository<Contact,Integer>{

}