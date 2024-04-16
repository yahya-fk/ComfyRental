package com.example.comfyrental.Security.Services;

import com.example.comfyrental.Security.Entities.Admin;
import com.example.comfyrental.Security.Entities.Role;
import com.example.comfyrental.Security.Repositories.AdminRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AdminServiceImp implements AdminService {
    AdminRepository adminRepository;

    public Admin FindUserById(String id) {
        return adminRepository.findById(id).get();
    }

    @Override
    public List<String> listRole(Admin admin) {
        return admin.getRoles().stream().map(Role::getRole)
                .collect(Collectors.toList());
    }

}