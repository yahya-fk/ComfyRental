package com.example.comfyrental.Services;

import com.example.comfyrental.Entities.Hosting;
import com.example.comfyrental.Repositories.HostingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HostingServiceImpl implements HostingService{
    HostingRepository hostingRepository;
    @Override
    public Hosting saveHosting(Hosting hosting) {
        return null;
    }

    @Override
    public Hosting updateHosting(Hosting hosting) {
        return null;
    }

    @Override
    public Hosting findHostingById(long id) {
        return null;
    }

    @Override
    public List<Hosting> findAllHosting() {
        return null;
    }

    @Override
    public void deleteAllHosting() {

    }

    @Override
    public void deleteHostingById(long id) {

    }
}
