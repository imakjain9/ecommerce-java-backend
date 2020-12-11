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

      <div class="card__insights">
        <div class="card__heading">
          <div class="heading">My Customers</div>
          <div class="date">
          <a href="${pageContext.request.contextPath}/addCustomerForm?userId=${user.id}"> Add new Customer </a>
          </div> 
        </div>
        <div class="insights">
		<c:forEach var="customer" items="${userCustomersList}">
		<div class="dropdown" style="float:left;">
                  <div class="insight">
                   <div class="number">
                      ${customer.customer_name}
                   </div>
                  </div>
        		  <div class="dropdown-content">
        			<div class="item-dropdown">
        			<a href="#" class="ancher droplink">Add Subscription</a>
        				<div class="item-dropdown-content" style="margin-left:180px;margin-top:-43px;">
        				<c:forEach var="item" items="${itemList}">
        					<a href="${pageContext.request.contextPath}/addCustomerSubscription?userId=${user.id}&customerId=${customer.id}&itemId=${item.id}">${item.name}</a>
        					</c:forEach>
        				</div>
        			</div>
        			<a href="${pageContext.request.contextPath}/getAnomalies?customerId=${customer.id}" class="ancher">Add Anomilies</a>
        			<a href="${pageContext.request.contextPath}/customerProfile?customerId=${customer.id}" class="ancher">Visit Profie</a>
        			<a href="${pageContext.request.contextPath}/getBill?customerId=${customer.id}" class="ancher">Genrate Bill</a>
        			<a href="${pageContext.request.contextPath}/getAllPayments?customerId=${customer.id}" class="ancher">Payment HISTORY</a>
        			</div>
            </div>
		</c:forEach>
		</div>
      </div>
    </div>

</body>
</html>