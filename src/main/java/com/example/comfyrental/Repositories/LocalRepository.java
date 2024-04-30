package com.example.comfyrental.Repositories;

import com.example.comfyrental.Entities.Local;
import com.example.comfyrental.Enums.TypeEnums;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalRepository extends JpaRepository<Local,Long> {
    List<Local> findByType(TypeEnums typeEnums);
}
