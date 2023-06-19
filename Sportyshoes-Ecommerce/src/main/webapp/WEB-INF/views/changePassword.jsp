<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Change Admin Password</title>
</head>
<body>
    <h2>Change Admin Password</h2>
    <form action="${pageContext.request.contextPath}/admin/change-password" method="post">
        <input type="text" name="email" placeholder="Email" required><br><br>
        <input type="password" name="oldPassword" placeholder="Old Password" required><br><br>
        <input type="password" name="newPassword" placeholder="New Password" required><br><br>
        <button type="submit">Change Password</button>
    </form>
    <p style="color: red">${errorMessage}</p>
    <p style="color: green">${successMessage}</p>
</body>
</html>
