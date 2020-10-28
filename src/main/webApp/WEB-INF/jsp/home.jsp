<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType = "text/html; charset = UTF-8" %>
<html>
<head>
<title>home</title>
</head>
<body>
<h1>${title}</h1>
<a href="http://localhost:8080/ecommerce/registerForm">register</a>

<h1>Employees List</h1>
<table border="2" width="70%" cellpadding="2">
<tr><th>email</th><th>firstName</th><th>lastName</th></tr>
   <c:forEach var="user" items="${userList}">
   <tr>
   <td>${user.email}</td>
   <td>${user.firstName}</td>
   <td>${user.lastName}</td>
   </tr>
   </c:forEach>
   </table>
</body>
</html>