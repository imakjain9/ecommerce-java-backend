<%@ page contentType = "text/html; charset = UTF-8" %>
<html>
<head>
    <title>home</title>
    <link rel="stylesheet" type="text/css"
        			  href="${pageContext.request.contextPath}/resource/css/form.css">
</head>
<body style="background-image:url(${pageContext.request.contextPath}/resource/images/registerFormBackground.jpg);background-size:cover;">

    <div class="form-style">
    		<div class="form-style-heading"><h1>Provide Your Professional Details</h1></div>

    			<form action="${pageContext.request.contextPath}/registerProfessionalDetails" method="post">

                    <label for="email"><span>Email :</span>
                    <input type="text"  class="input-field" name="email" value=${user.email} readonly><br>
    				</label>

                    <label for="fname"><span>First name:</span>
                    <input type="text" class="input-field"  name="firstName" value=${user.firstName} readonly><br>
    				</label>

                    <label for="lname"><span>Last name:</span>
                    <input type="text" class="input-field"  name="lastName" value=${user.lastName} readonly><br><br>
    				</label>

    				<label for="phoneNumber"><span>Phone Number</span>
                    <input type="tel" class="tel-number-field" name="phoneNumber" value=${user.phoneNumber} pattern="[0-9]{10}" maxlength=10 readonly />
                    </label>

                    <label for="targetMilkQuantity"><span>Target Milk Quantity</span>
                    <input type="number" class="input-field" name="targetMilkQuantity" min="0.25" max="3" step="0.25" />
                     </label>

                    <label><span> </span><input type="submit" value="Submit" />
    				</label>

    			</form>
    		</div>
</body>
</html>