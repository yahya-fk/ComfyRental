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
    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Room updateReview(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Room findRoomById(long id) {
        return roomRepository.findById(id).get();
    }

    @Override
    public List<Room> findAllRoom() {
        return roomRepository.findAll();
    }

    @Override
    public void deleteAllRoom() {
        roomRepository.deleteAll();
    }

    @Override
    public void deleteRoomById(long id) {
        roomRepository.deleteById(id);
    }
}
