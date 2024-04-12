package com.example.comfyrental.Security.Services;

import com.example.comfyrental.Security.Entities.Admin;
import com.example.comfyrental.Security.Entities.Role;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {
    public Admin CreateAdmin(Admin admin);
    public Role CreateRole(String roleId);
    public void addRoletoUser(String username,String role);
    public void removeRoletoUser(String username,String role);

}
