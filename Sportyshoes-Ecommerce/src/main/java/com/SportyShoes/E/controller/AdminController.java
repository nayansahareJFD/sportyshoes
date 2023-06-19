package com.SportyShoes.E.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.SportyShoes.E.AdminEntity.Admin;
import com.SportyShoes.E.AdminRepo.AdminRepository;
import com.SportyShoes.E.UserEntity.User;
import com.SportyShoes.E.UserRepo.UserRepository;

@Controller
public class AdminController {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminController(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }
    
    
/////////////////////////(Admin Login)//////////////////////////////////
    @GetMapping("/admin-login")
    public String showLoginForm(Model model) {
        model.addAttribute("admin", new Admin());
        return "adminLogin";
    }

    @PostMapping("/admin/login")
    public String processLoginForm(@ModelAttribute("admin") Admin admin, Model model) {
        Admin existingAdmin = adminRepository.findByEmail(admin.getEmail());
        if (existingAdmin == null || !existingAdmin.getPassword().equals(admin.getPassword())) {
            model.addAttribute("errorMessage", "Invalid email or password");
            return "adminLogin";
        }
        return "admin-dashboard";
    }
    
    ///////////////////////(change admin password)///////////////////////////////////
    
    @GetMapping("/change-password")
    public String showChangePasswordForm(Model model) {
        model.addAttribute("admin", new Admin());
        return "changePassword";  
        }

    @PostMapping("/admin/change-password")
    public String processChangePasswordForm(
    		@RequestParam("email") String email,
            @RequestParam("oldPassword") String oldPassword,
            @RequestParam("newPassword") String newPassword, Model model)
    {
        Admin existingAdmin = adminRepository.findByEmail(email);
        if (existingAdmin == null || !existingAdmin.getPassword().equals(oldPassword)) {
            model.addAttribute("errorMessage", "Invalid email or old password");
            return "changePassword";
        }

        // Update the admin's password
        existingAdmin.setPassword(newPassword);
        adminRepository.save(existingAdmin);

        model.addAttribute("successMessage", "Password changed successfully");
        return "admin-dashboard";
    }

    
///////////////////////////////////////////////////////////////////////////

}

