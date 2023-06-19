# to make database


# to make  tables
 
CREATE DATABASE sportyshoes;

USE sportyshoes;

CREATE TABLE user (
  id INT PRIMARY KEY,
  email VARCHAR(255),
  name VARCHAR(255),
  password VARCHAR(255)
);

CREATE TABLE admin (
  id INT PRIMARY KEY,
  email VARCHAR(255),
  password VARCHAR(255)
);


CREATE TABLE shoes (
  id INT PRIMARY KEY,
  name VARCHAR(255),
  brand VARCHAR(255),
  color VARCHAR(255),
  picture_url VARCHAR(255),
  price DECIMAL(10, 2),
  quantity INT,
  size INT
);


INSERT INTO your_table_name (id, name, brand, color, picture_url, price, quantity, size)
VALUES
  (1, 'RayRun M Running Shoes For Men  (Black)', 'Adidas', 'Black', 'C:\\Users\\sahyog\\Desktop\\Sportyshoes-Ecommerce\\src\\main\\resources\\ShoesPictures\\Black Adidas.jpg', 5000, 11, 11),
  (2, 'Ultra Boost 21 Running Shoes For Men (Blue)', 'Adidas', 'Blue', 'C:\\Users\\sahyog\\Desktop\\Sportyshoes-Ecommerce\\src\\main\\resources\\ShoesPictures\\Blue Adidas.jpg', 5500, 8, 10),
  (3, 'Nano X1 Cross Training Shoes For Men (White)', 'Reebok', 'White', 'C:\\Users\\sahyog\\Desktop\\Sportyshoes-Ecommerce\\src\\main\\resources\\ShoesPictures\\White Reebok.jpg', 4800, 4, 9),
  (4, 'Ignite Flash EvoKnit Running Shoes For Men (Red)', 'Puma', 'Red', 'C:\\Users\\sahyog\\Desktop\\Sportyshoes-Ecommerce\\src\\main\\resources\\ShoesPictures\\Red Puma.jpg', 4200, 10, 12),
  (5, 'Flex Experience RN 10 Running Shoes (Grey)', 'Nike', 'Grey', 'C:\\Users\\sahyog\\Desktop\\Sportyshoes-Ecommerce\\src\\main\\resources\\ShoesPictures\\Grey Nike.jpg', 3900, 6, 9),
  (6, 'Gel-Kayano 28 Running Shoes For Men (Green)', 'ASICS', 'Green', 'C:\\Users\\sahyog\\Desktop\\Sportyshoes-Ecommerce\\src\\main\\resources\\ShoesPictures\\Green ASICS.jpg', 5800, 12, 12);
