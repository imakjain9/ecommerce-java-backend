<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType = "text/html; charset = UTF-8" %>

<html>
<head>
	<style>
		/* fonts  */
@import url('https://fonts.googleapis.com/css?family=Abel|Aguafina+Script|Artifika|Athiti|Condiment|Dosis|Droid+Serif|Farsan|Gurajada|Josefin+Sans|Lato|Lora|Merriweather|Noto+Serif|Open+Sans+Condensed:300|Playfair+Display|Rasa|Sahitya|Share+Tech|Text+Me+One|Titillium+Web');

body {
/* 	background-image: linear-gradient(to top, #cd9cf2 0%, #f6f3ff 100%); */
	background: url(https://static.pexels.com/photos/5782/nature-flowers-vintage-plant.jpg);
	background-attachment: fixed;
	background-size:cover;
	margin: 0;
}


#container{
	background-image: linear-gradient(to top, rgba(205, 156, 242, 0.40) 0%, rgba(246, 255, 255, 0.71) 100%);
	box-shadow: 0 15px 30px 1px rgba(128, 128, 128, 0.31);
	text-align: center;
	border-radius: 5px;
	margin: 3em auto;
	background: rgba(255, 255, 255, 0.95);
	height: 300px;
	width: 480px;
	padding: 1em;
	
	position: fixed;
	bottom: 0;
	right: 0;
	left: 0;
	top: 0;	
	
	
}

#container h2 {
	background: url(https://static.pexels.com/photos/5782/nature-flowers-vintage-plant.jpg);
    -webkit-text-fill-color: transparent;
    -webkit-background-clip: text;
/* 	background-image: linear-gradient(to top, #cd9cf2 0%, #f6f3ff 100%); */
	font-family: 'Playfair Display', serif;
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size:cover;
	letter-spacing: 2px;
	font-size: 3.5em;
	margin: 0;

	
	
}
#container p {
	font-family: 'Farsan', cursive;
	margin: 3px 0 1.5em 0;
	font-size: 1.3em;
	color: #7d7d7d;
}
#container #subscriptionName .subscriptionOption,
#container #subscriptionName,
#container input {
/* 	background: rgba(255, 13, 254, 0.90); */
	width: 210px;
	display: inline-block;
	text-align: center;
	border-radius: 7px;
	background: #eee;
	padding: 1em 2em;
	outline: none;
	border: none;
	color: #222;
	transition: 0.3s linear;
}
::placeholder{color: #999;}
#container input:focus {background: rgba(0, 0, 333, 0.10);}

#container button {
	background-image: linear-gradient(to left, rgba(255, 146, 202, 0.75) 0%, rgba(145, 149, 251, 0.86) 100%);
	box-shadow: 0 9px 25px -5px #df91fb;
	font-family: 'Abel', sans-serif;
	padding: 0.5em 1.9em;
	margin: 2.3em 0 0 0;
	border-radius: 7px;
	font-size: 1.4em;
	cursor: pointer;
	color: #FFFFFF;
	font-size: 1em;
	outline: none;
	border: none;
	transition: 0.3s linear;

}
#container button:hover{transform: translatey(2px);}
#container button:active{transform: translatey(5px);}
	</style>
</head>
<body>
	<div id="container"><h2>FOR</h2>
    	<form action="${pageContext.request.contextPath}/addAnomalies?customerId=${customerId}" method="post">
      <select id="subscriptionName" placeholder="something" name="subscription_id">
        <c:forEach var="subscription" items="${customerSubscriptionList}">
    	<option class="subscriptionOption" name="subscription_id" value=${subscription.id}> ${subscription.subscriptionName} </option>
         </c:forEach>
    	</select>
    	<p>fill <input type="date" name="date" /> anomalies</p>
    	<input type="number" id="quantity" name="quantity" min="0.25" max="3" step="0.25" placeholder="0.00" required>
    			<br>
    		<button type="submit">SAVE</button>
    	</form>
    </div>
</body>
</html>