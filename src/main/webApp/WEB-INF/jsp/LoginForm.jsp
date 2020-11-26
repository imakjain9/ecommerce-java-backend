<html>
<head> <title>Login PAGE</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/login" method="post">
    <label>UserName/email
        <input type="email" for="email" >
    </label>
    <label>Password
            <input type="password" for="password" >
        </label>
     <button type="submit">Login </button>
    </form>
</body>
</html>