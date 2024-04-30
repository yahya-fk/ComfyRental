package com.example.comfyrental.Services;

import com.example.comfyrental.Entities.Bill;
import com.example.comfyrental.Entities.Local;
import com.example.comfyrental.Entities.User;
import com.example.comfyrental.Enums.TypeEnums;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LocalService {
    Local saveLocal(Local local);
    Local updateLocal(Local local);
    Local findLocalById(long id);
    List<Local> findLocalByType(TypeEnums type);
    List<Local> findAllLocals();
    Page<Local> findAllLocals(int page , int size);
    void deleteAllLocals();
    void deleteLocalById(long id);
}
