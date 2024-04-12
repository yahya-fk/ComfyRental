package com.example.comfyrental.Security.Services;

import com.example.comfyrental.Security.Entities.Admin;
import com.example.comfyrental.Security.Entities.Role;
import com.example.comfyrental.Security.Repositories.AdminRepository;
import com.example.comfyrental.Security.Repositories.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class AccountServiceImp implements AccountService {
    private AdminRepository adminRepository;
    private RoleRepository roleRepository;
    PasswordEncoder passwordEncoder;
    @Override
    public Admin CreateAdmin(Admin admin){
        Admin admin1=adminRepository.findById(admin.getUsername()).orElse(null);
        if(admin1!=null) throw new RuntimeException("UserName Exists");
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        return adminRepository.save(admin);
    }
    @Override
    public Role CreateRole(String roleId){
        Role role=roleRepository.findById(roleId).orElse(null);
        if(role!=null) throw new RuntimeException("Role Exists");
        role.setRole(roleId);
        return roleRepository.save(role);
    }

    @Override
    public void addRoletoUser(String username,String role){
        Role role1=roleRepository.findById(role).orElse(null);
        Admin admin=adminRepository.findById(username).orElse(null);
        admin.getRoles().add(role1);
    }

    @Override
    public void removeRoletoUser(String username, String role) {
        Role role1=roleRepository.findById(role).orElse(null);
        Admin admin=adminRepository.findById(username).orElse(null);
        admin.getRoles().remove(role1);
    }

}
