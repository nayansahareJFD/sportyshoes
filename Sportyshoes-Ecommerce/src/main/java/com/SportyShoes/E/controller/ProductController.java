package com.SportyShoes.E.controller;

import java.io.File;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.SportyShoes.E.ProductEntity.Shoes;
import com.SportyShoes.E.ShoesRepo.ShoesRepository;

@Controller
public class ProductController {

	private final ShoesRepository shoesRepository;

	@Value("${shoes.picture.upload.directory}")
	private String pictureUploadDirectory;

	@Autowired
	public ProductController(ShoesRepository shoesRepository) {
		this.shoesRepository = shoesRepository;
	}

	// Adding Product
	@GetMapping("/add-product")
	public String showAddProductForm(Model model) {
		model.addAttribute("shoes", new Shoes());
		return "Add-Product";
	}

	@PostMapping("/admin/add-product")
	public String processAddProductForm(@ModelAttribute("shoes") Shoes shoes, Model model,
			@RequestParam("picture") MultipartFile pictureFile) throws IOException {
		// Save the shoe's picture
		if (!pictureFile.isEmpty()) {
			String pictureFileName = pictureFile.getOriginalFilename();
			String pictureFilePath = pictureUploadDirectory + File.separator + pictureFileName;

			pictureFile.transferTo(new File(pictureFilePath));
			shoes.setPictureUrl(pictureFilePath);
		}

		// Save the new product to the database
		shoesRepository.save(shoes);

		model.addAttribute("successMessage", "Product added successfully");
		model.addAttribute("warningMessage", "DO NOT REFRESH UNTIL YOU ADD DETAILS OF NEW PRODUCT");
		model.addAttribute("shoes", new Shoes()); // Reset the form fields

		return "Add-Product";
	}

	// Deleting Product
	@GetMapping("/delete-product")
	public String showDeleteProductForm(Model model) {
		model.addAttribute("shoes", new Shoes());
		return "Delete-Product";
	}

	@PostMapping("/delete-product")
	public String deleteProduct(@RequestParam("productId") Long productId, Model model) {
		// Find the product by ID
		Optional<Shoes> optionalShoes = shoesRepository.findById(productId);

		if (optionalShoes.isPresent()) {
			Shoes shoes = optionalShoes.get();

			// Delete the associated picture file
			if (shoes.getPictureUrl() != null) {
				File pictureFile = new File(shoes.getPictureUrl());
				pictureFile.delete();
			}

			// Delete the product from the database
			shoesRepository.delete(shoes);

			model.addAttribute("successMessage", "Product deleted successfully");
		} else {
			model.addAttribute("errorMessage", "Product not found");
		}

		return "Delete-Product";
	}

	// Updating Product
	@GetMapping("/retrieve-and-update-product")
	public String showUpdateProductForm(Model model) {
		model.addAttribute("productId", null);
		return "Retrieve-Product";
	}

	@PostMapping("/retrieve-product")
	public String retrieveProductDetails(@RequestParam("productId") Long productId, Model model) {
		Optional<Shoes> optionalShoes = shoesRepository.findById(productId);

		if (optionalShoes.isPresent()) {
			Shoes shoes = optionalShoes.get();
			model.addAttribute("shoes", shoes);
			model.addAttribute("productId", productId);
			return "Update-Product";
		} else {
			model.addAttribute("errorMessage", "Product not found");
			return "Retrieve-Product";
		}
	}

	@PostMapping("/update-product")
	public String updateProduct(@ModelAttribute("shoes") Shoes updatedShoes, @RequestParam("productId") Long productId,
			@RequestParam("picture") MultipartFile pictureFile, Model model) throws IOException {
		Optional<Shoes> optionalShoes = shoesRepository.findById(productId);

		if (optionalShoes.isPresent()) {
			Shoes existingShoes = optionalShoes.get();

			existingShoes.setName(updatedShoes.getName());
			existingShoes.setBrand(updatedShoes.getBrand());
			existingShoes.setPrice(updatedShoes.getPrice());
			existingShoes.setColor(updatedShoes.getColor());
			existingShoes.setSize(updatedShoes.getSize());
			existingShoes.setQuantity(updatedShoes.getQuantity());

			if (!pictureFile.isEmpty()) {
				String pictureFileName = pictureFile.getOriginalFilename();
				String pictureFilePath = pictureUploadDirectory + File.separator + pictureFileName;

				pictureFile.transferTo(new File(pictureFilePath));
				existingShoes.setPictureUrl(pictureFilePath);
			}

			shoesRepository.save(existingShoes);

			model.addAttribute("successMessage", "Product updated successfully");
			return "Update-Product";
		} else {
			model.addAttribute("errorMessage", "Product not found");
			return "Update-Product";
		}
	}
	
	 @GetMapping("/retrieve-all-products")
	    public ResponseEntity<List<Shoes>> retrieveAllProducts() {
	        List<Shoes> allShoes = shoesRepository.findAll();
	        return new ResponseEntity<>(allShoes, HttpStatus.OK);
	    }
	  // Retrieve all products
	  
		/*
		 * @GetMapping("/retrieve-all-products") public String retrieveAllProducts(Model
		 * model) { List<Shoes> allShoes = shoesRepository.findAll();
		 * model.addAttribute("shoesList", allShoes); return "All-Products"; }
		 */
	  
	 
}