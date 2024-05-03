package com.example.comfyrental.Repositories;

import com.example.comfyrental.Entities.Hosting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface HostingRepository extends JpaRepository<Hosting,Long> {
    List<Hosting> findAllByOrderByLocal();

}
