<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType = "text/html; charset = UTF-8" %>
<html>
<head>
	<style>
		.form-style{
	max-width: 500px;
	padding: 30px 30px 10px 100px;
	margin-left:30%;
	font: 13px Arial, Helvetica, sans-serif;
	}
	.form-style-heading{
	font-weight: bold;
	font-style: italic;
	border-bottom: 2px solid #ddd;
	margin-bottom: 20px;
	font-size: 15px;
	padding-bottom: 3px;
}
.form-style-heading .addItem{
	background-color:red;
	border:none;
	
}
.form-style input[type=submit],
.form-style input[type=button]{
	border: none;
	padding: 8px 15px 8px 15px; 
	background: #FF8500;
	color: #fff;
	box-shadow: 1px 1px 4px #DADADA;
	-moz-box-shadow: 1px 1px 4px #DADADA;
	-webkit-box-shadow: 1px 1px 4px #DADADA;
	border-radius: 3px;
	-webkit-border-radius: 3px;
	-moz-border-radius: 3px;
}
.form-style input[type=submit]:hover,
.form-style input[type=button]:hover{
	background: #EA7B00;
	color: #fff;
}
select{
	box-sizing: border-box;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	border: 1px solid #C2C2C2;
	box-shadow: 1px 1px 4px #EBEBEB;
	-moz-box-shadow: 1px 1px 4px #EBEBEB;
	-webkit-box-shadow: 1px 1px 4px #EBEBEB;
	border-radius: 3px;
	-webkit-border-radius: 3px;
	-moz-border-radius: 3px;
	padding: 7px;
	outline: none;
	border: 1px solid #0C0;
	width:48%;
}
		body{
			font-family:helvetica;
		}
		.image_block{
			border:1px solid #ccc;
			border-radius:3px;
			padding:8px;
			width:200px;
			float:left;
			margin:15px;
		}
		.image_block_inner{
			position:relative;
			margin-bottom:5px;
		}
		img{
			width:200px;
			height:200px;
		}
		.checkbox_class{
			position:absolute;
			z-index:2;
			background:white;
			padding:2px;
			border-bottom-right-radius:3px;
			box-shadow:1px 1px rgba(0,0,0,.2);
		}
		.title{
			color:black;
            background-color:white;
           padding: 2px 3px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            border:solid 1px;
            font-size:10px;
		}
		.date{
            display: flex;
            justify-content: space-between;
			margin-top:8px;
			font-size:20px;
			font-weight:bold;

		}
		input[type=checkbox]:checked {
          height: 50px;
          width: 50px;
        }
        input[type=checkbox]:checked .image_block{
            border:3px solid red;
        }
	</style>
	<script>
    
    function selected() {
        document.getElementById("image_block").style.border="3px solid red";
    }
</script>
</head>
<body>
	<div class="form-style">
<div class="form-style-heading">
Add Subsscription for ${item.name} </div>
<form action="${pageContext.request.contextPath}/submitCustomerSubscription?userId=${userId}&customerId=${customerId}&itemId=${itemId}" method="post">
	<div  id="select-field">

	</div>

	<div class="image_block" id="image_block">
		<div class="image_block_inner">
            <div class="checkbox_class" id="checkbox_class"><input type="checkbox" name="itemId"  /></div>
                <a class="image" href=""><img src="${item.url}" /></a>
		 </div>
		 <div class="date">
		    <div >${item.name}</div>
		    <div >${item.price}/liter</div>
        </div>
        <div>
            <label for="quantity">Quantity: </label>
            <input type="number" id="quantity" name="quantity" min="0.25" max="3" step="0.25">
        </div>
	</div>

	<br>
	<label><span> </span><input type="submit" value="Subscribe" /></label>
</form>
</div>
</body>
</html>