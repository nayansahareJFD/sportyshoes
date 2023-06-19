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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.SportyShoes.E.AdminEntity.Admin;
import com.SportyShoes.E.UserEntity.User;
import com.SportyShoes.E.UserRepo.UserRepository;

@Controller

public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

	///////////////////(LOGIN User PROCESS)//////////////////////////////////////
    
    @GetMapping("/Userlogin")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        System.out.println("Login Page");
        return "LoginPage";
    }

    @PostMapping("/user/login")
    public String processLoginForm(@ModelAttribute("user") User user, Model model) {
        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser == null || !existingUser.getPassword().equals(user.getPassword())) {
            model.addAttribute("errorMessage", "Invalid email or password");
            return "LoginPage";
        }
        return "user-dashboard";
    }

    
   /////////////////////(REGISTER User PROCESS)/////////////////////////////////////////
    @GetMapping("/UserRegister")
    public String showRegistrationForm(Model model) {
    	System.out.println("showRegistrationForm");
        model.addAttribute("user", new User());
        return "RegisterPage";
    }

    @PostMapping("/register")
    public String processRegistrationForm(@ModelAttribute("user") User user, Model model) {
        // Check if email already exists in the database
        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser != null) {
            // Email already exists, show error message
            model.addAttribute("errorMessage", "Email already exists. Please use another email.");
            System.out.println("email already exists");
            return "RegisterPage";
        }
        
        // Email does not exist, save the user
        userRepository.save(user);
        return "success";
    }
         
    
    @GetMapping("/retrieve-all-users")
    public ResponseEntity<List<User>> retrieveAllUsers() {
        List<User> allUsers = userRepository.findAll();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }
    
    @GetMapping("/change-User-password")
    public String showChangePasswordForm(Model model) {
        model.addAttribute("user", new User());
        return "changeUserPassword";
        }

    @PostMapping("/change-User-password")
    public String changePassword(
    		@RequestParam("email") String email,
            @RequestParam("oldPassword") String oldPassword,
            @RequestParam("newPassword") String newPassword,
            Model model)
    {
        // Retrieve the user based on the provided email
        User user = userRepository.findByEmail(email);
        if (user == null) {
            model.addAttribute("errorMessage", "User not found");
            return "changeUserPassword";
        }
        
        // Check if the old password matches
        if (!user.getPassword().equals(oldPassword)) {
            model.addAttribute("errorMessage", "Invalid old password");
            return "changeUserPassword";
        }
        
        // Update the user's password
        user.setPassword(newPassword);
        userRepository.save(user);
        
        model.addAttribute("successMessage", "Password changed successfully");
        return "user-dashboard";
    }

	    
    
   
}

