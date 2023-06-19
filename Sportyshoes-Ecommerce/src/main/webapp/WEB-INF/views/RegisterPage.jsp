<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <title>Registration</title>
</head>
<body>
    <h1>Registration Form</h1>
     
    <%-- Display error message if exists --%>
    <c:if test="${not empty errorMessage}">
        <p style="color: red;">${errorMessage}</p>
    </c:if>
    
    
    
    <form action="/register" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required/><br/>
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required/><br/>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required/><br/>
        
        <input type="submit" value="Register"/>
    </form>
    
    </body>
</html>