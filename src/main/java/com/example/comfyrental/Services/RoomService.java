package com.example.comfyrental.Services;

import com.example.comfyrental.Entities.Room;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;


@Service
public interface RoomService {
    Room addRoom(Room r);
    Room updateRoom(Room r);

    Room getroombyid(Long id);

    void deleteRoomById(Long id);
}
