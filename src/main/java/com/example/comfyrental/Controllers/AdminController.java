package com.example.comfyrental.Controllers;

import com.example.comfyrental.Entities.User;
import com.example.comfyrental.Security.Entities.Admin;
import com.example.comfyrental.Security.Entities.Role;
import com.example.comfyrental.Security.Services.AccountService;
import com.example.comfyrental.Security.Services.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/Admin")
public class AdminController {
    AdminService adminService;
    AccountService accountService;
    @RequestMapping("")
    public String index(ModelMap modelMap
            , @RequestParam( name="page" , defaultValue = "0") int page
            , @RequestParam ( name="size" , defaultValue = "5") int size) {
        Page<Admin> adminPage=adminService.findAll(page,size);
        for (Admin user:adminPage) {
            user.setPassword(user.getPassword().substring(0,10)+"...");
        }
        modelMap.addAttribute("adminPage", adminPage);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("pages", new int[adminPage.getTotalPages()]);
        return "Admin/index";
    }
    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") String id ,ModelMap modelMap,ModelMap model){
        try {
            adminService.delete(id);
            Page<Admin> adminPage=adminService.findAll(0,5);
            modelMap.addAttribute("adminPage", adminPage);
            model.addAttribute("successMessage", "User Deleted successfully!");
        } catch (Exception e) {
            Page<Admin> adminPage=adminService.findAll(0,5);
            modelMap.addAttribute("adminPage", adminPage);
            model.addAttribute("errorMessage", "Failed to delete user: " + e.getMessage());
        }
        return "Admin/index";
    }
    @RequestMapping("/save")
    public String save(@ModelAttribute Admin admin,ModelMap model){
        try {
            System.out.println(admin.getUsername());
            List<Role> roleList = new ArrayList<>();
            Role role =new Role("ADMIN");
            roleList.add(role);
            admin.setRoles(roleList);
            adminService.save(admin);
            Page<Admin> adminPage=adminService.findAll(0,5);
            model.addAttribute("adminPage", adminPage);
            model.addAttribute("successMessage", "User Created successfully!");
        } catch (Exception e) {
            Page<Admin> adminPage=adminService.findAll(0,5);
            model.addAttribute("adminPage", adminPage);
            model.addAttribute("errorMessage", "Failed to create user: " + e.getMessage());
        }
        return "Admin/index";
    }
}
