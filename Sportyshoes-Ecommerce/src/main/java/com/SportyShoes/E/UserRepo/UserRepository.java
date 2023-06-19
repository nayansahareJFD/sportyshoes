package com.SportyShoes.E.UserRepo;


import org.springframework.data.jpa.repository.JpaRepository;
import com.SportyShoes.E.UserEntity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    
 // Additional custom methods if needed

}
