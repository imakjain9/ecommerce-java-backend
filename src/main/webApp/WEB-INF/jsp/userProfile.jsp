<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType = "text/html; charset = UTF-8" %>

<html>
<head><title>user-profile</title></head>
<link rel="stylesheet" type="text/css"
            			  href="${pageContext.request.contextPath}/resource/css/profile.css">
<body>
<section>
<LSection>
	<ul>
		<li><a href="http://localhost:8081/ecommerce/addCustomerForm">Add a Customer</a></li>
      <li><a href="http://localhost:8081/ecommerce/addItem">Add a Item</a></li>
      <li><a href="http://localhost:8081/ecommerce/addCustomerSubscription">Subscribe a item</a></li>
	</ul>
</LSection>
<MSection>
<div class="container">
  <h1>Name</h1>
  <h3>999635272</h3>
  <a href="https://imgbb.com/">
  <img src="mom.jpg" alt="profile-picture" border="0" /></a>
 <h4>Products I Deal</h4>
  <div class="listFlex">
    <div>
  <ul>
    <li>Milk</li>
    <li>Ghee</li>
    <li>Paneer</li>
  </ul>
    </div>
 <div>
  <ul>
    <li>Curd</li>
    <li>Lasii</li>
    <li>Khoya</li>
  </ul>
    </div>
  </div>
      <h4>Social Media</h4> 
  You can mail me- <a href="#">@gmil.com</a>
</div>

</MSection>
<RSection>
	<h2>My Customers</h2>
	<ul>
		<li><a href="">Rahul</a></li>
		<li><a href="">Sandeep</a></li>
		<li></li>
		<li></li>
	</ul>
</RSection>
</section> 
</body>
</html>