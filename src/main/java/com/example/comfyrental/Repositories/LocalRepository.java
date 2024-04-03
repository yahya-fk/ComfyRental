package com.example.comfyrental.Repositories;

import com.example.comfyrental.Entities.Bill;
import com.example.comfyrental.Entities.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalRepository extends JpaRepository<Local,Long> {
}
