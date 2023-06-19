package com.SportyShoes.E;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SportyShoes.E.UserEntity.User;
import com.SportyShoes.E.UserRepo.UserRepository;

@SpringBootApplication
public class SportyshoesEcommerceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SportyshoesEcommerceApplication.class, args);

		// to ask a bean from the container
		
		 UserRepository repositoryBean =   context.getBean(UserRepository.class);
		 
		  
		

		
		
	
	}

}
