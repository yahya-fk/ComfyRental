package com.example.comfyrental.Services;

import com.example.comfyrental.Entities.Hosting;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HostingService {
    Hosting saveHosting(Hosting hosting);
    Hosting updateHosting(Hosting hosting);
    Hosting findHostingById(long id);
    List<Hosting> findAllHosting();
    void deleteAllHosting();
    void deleteHostingById(long id);

}
