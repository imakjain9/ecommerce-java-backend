<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType = "text/html; charset = UTF-8" %>

<html >
<head>

	<title>custmer-form</title>
    <link rel="stylesheet" type="text/css"
            			  href="${pageContext.request.contextPath}/resource/css/form.css">
  </head>
<body style="background-image:url(${pageContext.request.contextPath}/resource/images/addCustomerFormBackground.jpg);">

	<div class="form-style">
<div class="form-style-heading"><h1>Provide Customer's information </h1></div>

<form action="${pageContext.request.contextPath}/addCustomerSubmit" method="post">

<label for="field1"><span>Name <span class="required">*</span></span>
<input type="text" class="input-field" name="customer_name"  /></label>

<label for="field2"><span>Email <span class="required">*</span></span>
<input type="email" class="input-field" name="customer_email"  /></label>

<label><span>Telephone</span>
<input type="tel" class="tel-number-field" name="customer_phone" pattern="[0-9]{10}" maxlength=10 /></label>

 <label for="field5"><span>Address <span class="required">*</span></span>
<!--  <textarea name="field5" class="textarea-field"></textarea> -->
<input type="text" class="input-field" name="customer_address"  /></label>
 

<label for="user"><span>Under Registration <span class="required">*</span></span>
<select name="registered_user" class="select-field" required>Registered User
     <c:forEach var="user" items="${userList}">
<option value=${user.id}>${user.firstName}</option>
    </c:forEach>
</select>
</label>

<label><span>custmer_type</span>
<input type="radio" value="regular" name="customer_type"/>Regular
		<input type="radio" value="irregular" name="customer_type"/>Irregular
	</label>
	


<label><span> </span><input type="submit" value="Submit" /></label>
</form>

</div>
</body>
</html>

