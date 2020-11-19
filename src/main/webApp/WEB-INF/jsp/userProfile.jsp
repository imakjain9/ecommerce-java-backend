<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType = "text/html; charset = UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
	 <title>User profile</title>
        <link rel="stylesheet" type="text/css"
            			  href="${pageContext.request.contextPath}/resource/css/profile.css">
</head>
<body>
	<div class="card">
      <div class="card__header">
        <div class="card__profile">
          <img src="${pageContext.request.contextPath}/resource/images/mom.jpg" alt="A man smiling" />
        </div>
        <div class="card__name">
          <h2>${user.firstName}</h2>
          <div class="card__handle">
            <span class="handle">${user.email}</span>
            <span class="circle"></span>
            <span class="category">${user.phoneNumber}</span>
          </div>
        </div>
      </div>
      <hr class="border" />
      <nav>
        <ul class="navlinks">
          <li class="link__item">Home</li>
          <li class="link__item"><a href="${pageContext.request.contextPath}/items/new">Add a Item</a></li>
        </ul>
      </nav>
      <div class="card__insights">
        <div class="card__heading">
          <div class="heading">My Customers</div>
          <div class="date">
          <a href="${pageContext.request.contextPath}/addCustomerForm"> Add new Customer </a>
          </div> 
        </div>
        <div class="insights">
		<c:forEach var="customer" items="${userCustomersList}">
		<div class="dropdown">
          <div class="insight">
           <div class="number">
              ${customer.customer_name}
           </div>
          </div>
		  <div class="dropdown-content">
			<a href="${pageContext.request.contextPath}/getAnomalies?customerId=${customer.id}">Add Anomilies</a>
			<a href="${pageContext.request.contextPath}/addCustomerSubscription">Add Subscription</a>
			<a href="${pageContext.request.contextPath}/customerProfile?customerId=${customer.id}">Visit Profie</a>
			<a href="${pageContext.request.contextPath}/getBill?customerId=${customer.id}">Genrate Bill</a>
			<a href="${pageContext.request.contextPath}/getAllPayments?customerId=${customer.id}">Payment HISTORY</a>
			</div>
		</div>
		</c:forEach>
		</div>
      </div>
    </div>

</body>
</html>