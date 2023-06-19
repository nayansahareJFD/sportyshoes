<!-- changePassword.jsp -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Change Password</title>
</head>
<body>
    <h1>Change Password</h1>

    <%-- Display error message if present --%>
    
        <p style="color: red">${errorMessage}</p>
    

    <%-- Display success message if present --%>
    
        <p style="color: green">${successMessage}</p>
    

    <form action="${pageContext.request.contextPath}/change-User-password" method="post">
        <label for="email">Email:</label>
        <input type="text" id="email" name="email" required/><br/><br/>

        <label for="oldPassword">Old Password:</label>
        <input type="password" id="oldPassword" name="oldPassword" required/><br/><br/>

        <label for="newPassword">New Password:</label>
        <input type="password" id="newPassword" name="newPassword" required/><br/><br/>

        <input type="submit" value="Change Password"/>
    </form>
</body>
</html>
