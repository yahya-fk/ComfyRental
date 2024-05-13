package com.example.comfyrental.Security.Services;

import com.example.comfyrental.Security.Entities.Admin;
import com.example.comfyrental.Security.Entities.Role;
import com.example.comfyrental.Security.Repositories.AdminRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AdminServiceImp implements AdminService {
    AdminRepository adminRepository;
    PasswordEncoder passwordEncoder;
    public Admin FindUserById(String id) {
        return adminRepository.findById(id).get();
    }

    @Override
    public List<String> listRole(Admin admin) {
        return admin.getRoles().stream().map(Role::getRole)
                .collect(Collectors.toList());
    }

    @Override
    public Page<Admin> findAll(int page, int size) {
        return adminRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public void delete(String id) {
        adminRepository.deleteById(id);
    }

    @Override
    public Admin save(Admin admin) {
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        return adminRepository.save(admin);
    }

}