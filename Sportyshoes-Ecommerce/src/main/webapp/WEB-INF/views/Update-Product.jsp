<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Product</title>
</head>
<body>
    <h2>Update Product</h2>
    <form action="${pageContext.request.contextPath}/update-product" method="post" enctype="multipart/form-data">
        <input type="hidden" name="productId" value="${shoes.id}">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${shoes.name}" required><br><br>
        <label for="brand">Brand:</label>
        <input type="text" id="brand" name="brand" value="${shoes.brand}" required><br><br>
        <label for="price">Price:</label>
        <input type="text" id="price" name="price" value="${shoes.price}" required><br><br>
        <label for="color">Color:</label>
        <input type="text" id="color" name="color" value="${shoes.color}" required><br><br>
        <label for="size">Size:</label>
        <input type="number" id="size" name="size" value="${shoes.size}" required><br><br>
        <label for="quantity">Quantity:</label>
        <input type="number" id="quantity" name="quantity" value="${shoes.quantity}" required><br><br>
        <label for="picture">Picture:</label>
        <input type="file" id="picture" name="picture"><br><br>
        <img src="${shoes.pictureUrl}" alt="Product Picture"><br>
        <span>${shoes.pictureUrl}</span><br><br>
        <button type="submit">Update Product</button>
    </form>
    
    <div>
        <h3>${successMessage}</h3>
        <h3>${errorMessage}</h3>
    </div>
</body>
</html>
