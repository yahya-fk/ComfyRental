package com.example.comfyrental.Security.Repositories;

import com.example.comfyrental.Security.Entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,String> {
}
