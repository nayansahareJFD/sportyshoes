<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
    <meta charset="ISO-8859-1">

    <title>Delete Product</title>
</head>
<body>
    <h2>Delete Product</h2>
    <form action="${pageContext.request.contextPath}/delete-product" method="post">
        <label for="productId">Product ID:</label>
        <input type="number" id="productId" name="productId" required><br><br>
        <button type="submit">Delete Product</button>
    </form>

    <div>
        <h3>${successMessage}</h3>
        <h3>${errorMessage}</h3>
    </div>
</body>
</html>
