package com.hotel.HotelBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.HotelBooking.entity.Room;

public interface RoomRepository
        extends JpaRepository<Room,Integer>{

}