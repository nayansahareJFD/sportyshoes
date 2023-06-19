package com.SportyShoes.E.ProductEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Shoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String brand;
    private double price;
    private String color;
    private int size;
    private String pictureUrl;
    private int quantity;

    // Constructors, getters, and setters

    public Shoes() {
    }

    public Shoes(String name, String brand, double price, String color, int size, String pictureUrl, int quantity) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.color = color;
        this.size = size;
        this.pictureUrl = pictureUrl;
        this.quantity = quantity;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

	@Override
	public String toString() {
		return "Shoes [id=" + id + ", name=" + name + ", brand=" + brand + ", price=" + price + ", color=" + color
				+ ", size=" + size + ", pictureUrl=" + pictureUrl + ", quantity=" + quantity + "]";
	}
    
}
