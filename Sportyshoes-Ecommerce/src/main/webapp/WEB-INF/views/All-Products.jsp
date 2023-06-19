<%@page import="com.SportyShoes.E.ProductEntity.Shoes"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All Products</title>
</head>
<body>
    <h2>All Products</h2>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Brand</th>
                <th>Price</th>
                <th>Color</th>
                <th>Size</th>
                <th>Quantity</th>
                <th>Picture</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${shoesList}" var="shoes">
            <tr>
                <td>${shoes.id}</td>
                <td>${shoes.name}</td>
                <td>${shoes.brand}</td>
                <td>${shoes.price}</td>
                <td>${shoes.color}</td>
                <td>${shoes.size}</td>
                <td>${shoes.quantity}</td>
                <td>
                    <img src="${shoes.pictureUrl}" alt="Product Picture" width="100" height="100">
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
