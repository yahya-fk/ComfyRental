package com.example.comfyrental.Services;

import com.example.comfyrental.Entities.Bill;
import com.example.comfyrental.Entities.Local;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LocalService {
    Local saveLocal(Local local);
    Local updateLocal(Local local);
    Local findLocalById(long id);
    List<Local> findAllLocals();
    void deleteAllLocals();
    void deleteLocalById(long id);
}
