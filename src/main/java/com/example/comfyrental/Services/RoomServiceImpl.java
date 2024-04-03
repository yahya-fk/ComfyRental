package com.example.comfyrental.Services;

import com.example.comfyrental.Entities.Room;
import com.example.comfyrental.Repositories.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class RoomServiceImpl implements RoomService{

private RoomRepository roomRepository;
    @Override
    public Room addRoom(Room room) {
        return roomRepository.save(room); //l'IDE m'a suggere le cast je vais retraiter ce cas demain
    }

    @Override
    public Room updateRoom(Room r) {
        return roomRepository.save(r);
    }

    @Override
    public Room getroombyid(Long id) {
        return null;
    }

    @Override
    public void deleteRoomById(Long id) {

    }

    @Override
    public List<Room> getAllRooms() {
        return null;
    }
}
