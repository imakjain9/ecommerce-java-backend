<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType = "text/html; charset = UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<style>
*{
  box-sizing:border-box;
  -moz-box-sizing:border-box;
}
body {
	background: url(//subtlepatterns.com/patterns/scribble_light.png);
  font-family: Calluna, Arial, sans-serif;
  min-height: 1000px;
}
#wrap{
	width: 90%;
	max-width: 1100px;
	margin: 50px auto;
}
.columns_2 figure{
   width:49%;
   margin-right:1%;
}
.columns_2 figure:nth-child(2){
	margin-right: 0;
}
.columns_3 figure{
   width:32%;
   margin-right:1%;
}
.columns_3 figure:nth-child(3){
	margin-right: 0;
}
.columns_4 figure{
   width:24%;
   margin-right:1%;
}
.columns_4 figure:nth-child(4){
	margin-right: 0;
}
.columns_5 figure{
   width:19%;
   margin-right:1%;
}
.columns_5 figure:nth-child(5){
	margin-right: 0;
}
#columns figure:hover{
	-webkit-transform: scale(1.1);
	-moz-transform:scale(1.1);
	transform: scale(1.1);

}
#columns:hover figure:not(:hover) {
	opacity: 0.4;
}
div#columns figure {
	display: inline-block;
	background: #FEFEFE;
	border: 2px solid #FAFAFA;
	box-shadow: 0 1px 2px rgba(34, 25, 25, 0.4);
	margin: 0 0px 15px;
	-webkit-column-break-inside: avoid;
	-moz-column-break-inside: avoid;
	column-break-inside: avoid;
	padding: 15px;
	padding-bottom: 5px;
	background: -webkit-linear-gradient(45deg, #FFF, #F9F9F9);
	opacity: 1;
	-webkit-transition: all .3s ease;
	-moz-transition: all .3s ease;
	-o-transition: all .3s ease;
	transition: all .3s ease;
}

div#columns figure img {
	width: 100%;
	height:280px;
	border-bottom: 1px solid #ccc;
	padding-bottom: 15px;
	margin-bottom: 5px;
}

div#columns figure figcaption {
  font-size: .9rem;
  color: #444;
  line-height: 1.5;
  height:60px;
  font-weight:600;
  text-overflow:ellipsis;
}

.button{
	 border: none;
  padding:10px;
  background:salmon;
  margin:10pxs;
  display:block;
  text-align:center;
  color:#fff;
  transition:all 1s linear;
  text-decoration:none;
  text-shadow:1px 1px 3px rgba(0,0,0,0.3);
  border-radius:3px;
  border-bottom:3px solid #ff6536;
  box-shadow:1px 1px 3px rgba(0,0,0,0.3);
}
.button:hover{
  background:#ff6536;
  border-bottom:3px solid salmon;
  color:#f1f2f3;
}
@media screen and (max-width: 960px) {
  #columns figure { width: 24%; }
}
@media screen and (max-width: 767px) {
  #columns figure { width:32%;}
}
@media screen and (max-width: 600px) {
  #columns figure { width: 49%;}
}
@media screen and (max-width: 500px) {
  #columns figure { width: 100%;}
}
</style>
</head>

<!--Changing the number in the column_# class changes the number of columns-->
<body>
	<div id="wrap">
	<div id="columns" class="columns_4">
	<c:forEach var="item" items="${items}">
  <figure>
  <form action="${pageContext.request.contextPath}/subscription/submitCustomerSubscription?userId=${userId}&customerId=${customerId}" method="post">

  <img src="${item.url}">.
	<figcaption>${item.name}</figcaption>
    <span class="price">Rs. ${item.price}</span>
	<input type="text" name="quantity">
    <Button id="button_${item.name}" name="itemId" value="${item.id}" type="submit"  hidden ></Button>
	<label for="button_${item.name}" class="button">Subscribe</label>
	</form>
	</figure>
	 </c:forEach>
</div>


</body>
</html>