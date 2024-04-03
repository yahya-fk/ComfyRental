package com.example.comfyrental.Services;

import com.example.comfyrental.Entities.Local;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class LocalServiceImpl implements LocalService{
    @Override
    public Local saveLocal(Local local) {
        return null;
    }

    @Override
    public Local updateLocal(Local local) {
        return null;
    }

    @Override
    public Local findLocalById(long id) {
        return null;
    }

    @Override
    public List<Local> findAllLocals() {
        return null;
    }

    @Override
    public void deleteAllLocals() {

    }

    @Override
    public void deleteLocalById(long id) {

    }
}
