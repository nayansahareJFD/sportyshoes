<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<meta charset="ISO-8859-1">
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Login</title>
   
</head>
<body>
    <h1>Admin Login</h1>
    
    <%-- Display error message if exists --%>
    <c:if test="${not empty errorMessage}">
        <p style="color: red;">${errorMessage}</p>
    </c:if>
    
    <form action="/admin/login" method="post">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required/><br/>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required/>
       
        
        <input type="submit" value="Login"/>
    </form>
</body>
</html>
