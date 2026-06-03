package com.hotel.HotelBooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.HotelBooking.entity.Room;
import com.hotel.HotelBooking.repository.RoomRepository;
import java.util.List;

@Service
public class RoomService {
	
	public List<Room> findAll(){

	    return roomRepository.findAll();
	}
	

    @Autowired
    private RoomRepository roomRepository;

    public Room save(Room room){

        return roomRepository.save(room);
    }

    public long countRooms(){

        return roomRepository.count();
    }
    public Room findById(Integer id){

        return roomRepository
                .findById(id)
                .orElse(null);
    }
}