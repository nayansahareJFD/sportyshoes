package com.SportyShoes.E.ShoesRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SportyShoes.E.ProductEntity.Shoes;

public interface ShoesRepository extends JpaRepository<Shoes, Long>{ 

	
	// Additional custom methods for shoe repository if needed

}
