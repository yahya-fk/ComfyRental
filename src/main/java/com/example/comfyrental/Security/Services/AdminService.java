package com.example.comfyrental.Security.Services;

import com.example.comfyrental.Security.Entities.Admin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {
    Admin FindUserById(String id);
    List<String> listRole(Admin admin);
    Page<Admin> findAll(int page, int size);
    void delete(String id);
    Admin save(Admin admin);
}
