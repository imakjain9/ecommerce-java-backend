<%@ page contentType = "text/html; charset = UTF-8" %>
<html>
<head>
    <title>home</title>
    <link rel="stylesheet" type="text/css"
        			  href="${pageContext.request.contextPath}/resource/css/form.css">
</head>
<body style="background-image:url(${pageContext.request.contextPath}/resource/images/registerFormBackground.jpg);background-size:cover;">

    <div class="form-style">
    		<div class="form-style-heading"><h1>Provide Your information</h1></div>

    			<form action="http://localhost:8081/ecommerce/registerSubmit" method="post">

                    <label for="email"><span>Email :</span>
                    <input type="text"  class="input-field" name="email" placeholder="John"><br>
    				</label>

                    <label for="fname"><span>First name:</span>
                    <input type="text" class="input-field"  name="firstName" placeholder="John"><br>
    				</label>

                    <label for="lname"><span>Last name:</span>
                    <input type="text" class="input-field"  name="lastName" placeholder="Doe"><br><br>
    				</label>

                    <label><span> </span><input type="submit" value="Submit" />
    				</label>

    			</form>
    		</div>
</body>
</html>