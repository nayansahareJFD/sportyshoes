<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Add Product</title>
    <script>
        // Function to hide the success message after a certain time interval
        function hideSuccessMessage() {
            var successMessage = document.getElementById('successMessage');
            successMessage.style.display = 'none';
        }

        // Delay the hiding of the success message
        setTimeout(hideSuccessMessage, 10000); // 10000 milliseconds = 10 seconds
    </script>
</head>
<body>

    <h2>Add Product</h2>
    <form action="${pageContext.request.contextPath}/admin/add-product" method="post" enctype="multipart/form-data">
        <input type="text" name="name" placeholder="Name" required><br><br>
        <input type="text" name="brand" placeholder="Brand" required><br><br>
        <input type="text" name="price" placeholder="Price" required><br><br>
        <input type="text" name="color" placeholder="Color" required><br><br>
        <input type="number" name="size" placeholder="Size" required><br><br>
        <input type="number" name="quantity" placeholder="Quantity" required><br><br> <!-- Added input field for quantity -->
        <input type="file" name="picture" required><br><br>
        <button type="submit">Add Product</button>
    </form>

    <div id="successMessage" style="color: green">
        <h3>${successMessage}</h3>
    </div>
    <div id="warningMessage" style="color: red">
        <h3>${warningMessage}</h3>
    </div>
</body>
</html>
