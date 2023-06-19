<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<h1>User Dashboard</h1>

<a href="${pageContext.request.contextPath}/change-User-password">Change password</a>

<div id="successMessage" style="color: green">
    <%-- Display the success message for 5 seconds --%>
    <h3>${successMessage}</h3>
</div>


</body>
</html>