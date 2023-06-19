<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Retrieve Product</title>
</head>
<body>
    <h2>Retrieve Product To Update</h2>
    <form action="${pageContext.request.contextPath}/retrieve-product" method="post">
        <label for="productId">Product ID:</label>
        <input type="text" id="productId" name="productId" required><br><br>
        <button type="submit">Retrieve Product</button>
    </form>
    
    <div>
        <h3>${errorMessage}</h3>
    </div>
</body>
</html>
