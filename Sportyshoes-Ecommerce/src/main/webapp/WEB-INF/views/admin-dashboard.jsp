<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin dashboard</title>
<script>
    // Function to hide the success message after a certain time interval
    function hideSuccessMessage() {
        var successMessage = document.getElementById('successMessage');
        successMessage.style.display = 'none';
    }

    // Delay the hiding of the success message
    setTimeout(hideSuccessMessage, 5000); // 5000 milliseconds = 5 seconds
</script>
</head>
<body>
<h1>Admin dashboard</h1>
<div id="successMessage" style="color: green">
    <%-- Display the success message for 5 seconds --%>
    <h3>${successMessage}</h3>
</div>
<a href="${pageContext.request.contextPath}/change-password">Change Password</a>
<br>
<a href="${pageContext.request.contextPath}/add-product">Add Product</a>
<br>
<a href="${pageContext.request.contextPath}/delete-product">Delete Product</a>
<br>
<a href="${pageContext.request.contextPath}/retrieve-and-update-product">Retrieve-and-Update-Product</a>
<br>
<a href="${pageContext.request.contextPath}/retrieve-all-products">retrieve-all-products</a>
<br>
<a href="${pageContext.request.contextPath}/retrieve-all-users">retrieve-all-users</a>

</body>
</html>
