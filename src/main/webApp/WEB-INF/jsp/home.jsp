<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType = "text/html; charset = UTF-8" %>
<html>
<head>
<title>home</title>
    <link rel="stylesheet" type="text/css"
    			  href="${pageContext.request.contextPath}/resource/css/home.css">

    <script type="text/javascript" src=
    			"${pageContext.request.contextPath}/resource/js/home.js">
    </script>
</head>
<body>
<header>
    <div class="container" id="containerContent">
        <span style="font-size:30px;cursor:pointer;margin-right:10px;display:inline-block;color:#111;" onclick="openNav()">&#9776;</span>
            <h1  id="logo">${title}</h1>
                <nav>
                    <ul>
                        <li><a href="#">signin</li>
                        <li><a href="#">login</li>
                    </ul>
    </div>
 </header>

<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <a href="#">About</a>
  <a href="http://localhost:8081/ecommerce/registerForm">Register</a>

  <a href="#">Contact</a>
    <hr>
  <h3 style="color:#a6a6a6;font-size:21px;margin-bottom:10px;">Admin</h3>
      <c:forEach var="user" items="${userList}">
        <a href="http://localhost:8081/ecommerce/userProfile?userId="+user.id>${user.firstName}</a>
       </c:forEach>
</div>

<div id="main">
</div>



</body>
</html>