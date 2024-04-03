package com.example.comfyrental.Services;

import com.example.comfyrental.Entities.Room;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;


@Service
public interface RoomService {
    Room saveRoom(Room room);
    Room updateReview(Room room);
    Room findRoomById(long id);
    List<Room> findAllRoom();
    void deleteAllRoom();
    void deleteRoomById(long id);
}
