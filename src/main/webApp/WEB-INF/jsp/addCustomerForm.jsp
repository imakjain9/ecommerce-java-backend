<!doctype html>

<html lang="en">
<head>
  <meta charset="utf-8">
	<title>custmer-form</title>
    <link rel="stylesheet" type="text/css"
            			  href="${pageContext.request.contextPath}/resource/css/form.css">
  </head>
<body>

	<div class="form-style">
<div class="form-style-heading"><h1>Provide Custmer's information </h1></div>

<form action="http://localhost:8081/ecommerce/addCustomerSubmit" method="post">

<label for="field1"><span>Name <span class="required">*</span></span>
<input type="text" class="input-field" name="customer_name" value="" /></label>

<label for="field2"><span>Email <span class="required">*</span></span>
<input type="email" class="input-field" name="customer_email" value="" /></label>

<label><span>Telephone</span>
<input type="tel" class="tel-number-field" name="customer_number" pattern="[0-9]{10}" maxlength=10 /></label>

 <label for="field5"><span>Address <span class="required">*</span></span>
<!--  <textarea name="field5" class="textarea-field"></textarea> -->
<input type="text" class="input-field" name="customer_address" value="" /></label>
 

<label for="user"><span>Under Registration <span class="required">*</span></span>
<select name="registered_user" class="select-field">
<option value="General Question">User1</option>
<option value="Advertise">User2</option>
</select>
</label>

<label><span>custmer_type</span>
<input type="radio" value="regular" name="custmer_type"/>Regular
		<input type="radio" value="irregular" name="custmer_type"/>Irregular
	</label>
	


<label><span> </span><input type="submit" value="Submit" /></label>
</form>

</div>
</body>
</html>

