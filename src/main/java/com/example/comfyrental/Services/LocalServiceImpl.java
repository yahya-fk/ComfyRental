package com.example.comfyrental.Services;

import com.example.comfyrental.Entities.Local;
import com.example.comfyrental.Repositories.LocalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class LocalServiceImpl implements LocalService{
    private LocalRepository localRepository;
    @Override
    public Local saveLocal(Local local) {
        return localRepository.save(local);
    }

    @Override
    public Local updateLocal(Local local) {return localRepository.save(local);}
    @Override
    public Local findLocalById(long id) {
        return localRepository.findById(id).get();
    }

    @Override
    public List<Local> findAllLocals() {
        return localRepository.findAll();
    }

    @Override
    public void deleteAllLocals() {
        localRepository.deleteAll();
    }

    @Override
    public void deleteLocalById(long id) {
        localRepository.deleteById(id);
    }
}
