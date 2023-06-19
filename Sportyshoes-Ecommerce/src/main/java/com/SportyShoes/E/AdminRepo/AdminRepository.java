package com.SportyShoes.E.AdminRepo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.SportyShoes.E.AdminEntity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByEmail(String email);
 // Additional custom methods if needed
	

}
