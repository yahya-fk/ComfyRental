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
        return hostingRepository.save(hosting);
    }

    @Override
    public Hosting updateHosting(Hosting hosting) {
        return hostingRepository.save(hosting);

    }

    @Override
    public Hosting findHostingById(long id) {
        return hostingRepository.findById(id).get();
    }

    @Override
    public List<Hosting> findAllHosting() {
        return hostingRepository.findAll();
    }

    @Override
    public void deleteAllHosting() {
        hostingRepository.deleteAll();
    }

    @Override
    public void deleteHostingById(long id) {
        hostingRepository.deleteById(id);
    }
}
