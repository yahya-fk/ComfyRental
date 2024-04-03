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
        return null;
    }

    @Override
    public Room updateReview(Room room) {
        return null;
    }

    @Override
    public Room findRoomById(long id) {
        return null;
    }

    @Override
    public List<Room> findAllRoom() {
        return null;
    }

    @Override
    public void deleteAllRoom() {

    }

    @Override
    public void deleteRoomById(long id) {

    }
}
