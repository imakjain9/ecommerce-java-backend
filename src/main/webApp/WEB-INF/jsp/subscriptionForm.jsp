<!DOCTYPE HTML>
<html>
<head>
	<style>
/*
  The grid itself needs only 4 CSS declarations:
*/

.myGallery {
  display: grid;
  grid-gap: 40px;
  grid-template-columns: repeat(auto-fit, minmax(250px, 2fr));
}

.myGallery .item .itemImage {
  width: 100%;
	margin-bottom: 0px ;
    height:350px;
}
/*
  And here are some declarations for the image caption.
  Just hover over one of the last 5 images to see it.
*/

.myGallery .item {
  position: relative;
  overflow: hidden;
}

.myGallery .item itemImage {
  vertical-align: middle;
}

.myGallery .caption {
  margin: 0;
  padding: 1em;
  position: absolute;
  z-index: 1;
  bottom: 0;
  left: 0;
  width: 100%;
  max-height: 100%;
  overflow: auto;
  box-sizing: border-box;
  transition: transform 0.5s;
  transform: translateY(100%);
  background: rgba(0, 0, 0, 0.7);
  color: rgb(255, 255, 255);
}

.myGallery .item:hover .caption {
  transform: translateY(0%);
}
.form-style-heading{
	font-weight: bold;
	font-style: italic;
	border-bottom: 2px solid #ddd;
	margin-bottom: 30px;
	font-size: 15px;
	padding-bottom: 1px;
}
.form-style input[type=submit]:hover,
.form-style input[type=button]:hover{
	background: #EA7B00;
	color: #fff;
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
.form-style{
	max-width: 800px;
	padding: 30px 30px 10px 100px;
	margin-left:10%;
	font: 13px Arial, Helvetica, sans-serif;
	
}
	label:before {
  content: url("https://cdn1.iconfinder.com/data/icons/windows8_icons_iconpharm/26/unchecked_checkbox.png");
  position: absolute;
  z-index: 100;
}
:checked+label:before {
  content: url("https://cdn1.iconfinder.com/data/icons/windows8_icons_iconpharm/26/checked_checkbox.png");
}
input[type=checkbox] {
  display: none;
}

</style>

</head>
<body>
<div class="form-style">
<div class="form-style-heading"><h1>Choose Items</h1></div>
<form action="http://localhost:8081/ecommerce/addCustomerSubscriptions" method="post">
<div class="myGallery">
  
  <div class="item">
   <input type="checkbox" id="myCheckbox1" />
<label for="myCheckbox1" ><img src="${pageContext.request.contextPath}/resource/images/milk.jpg" class="itemImage"></label>
	<span class="caption">Milk</span>
  </div>
  
  <div class="item">
    <input type="checkbox" id="myCheckbox2" />
<label for="myCheckbox2" ><img src="${pageContext.request.contextPath}/resource/images/curd.jpg" class="itemImage"></label>
    <span class="caption">Curd</span>
  </div>
  
  <div class="item">
    <input type="checkbox" id="myCheckbox3" />
<label for="myCheckbox3" ><img src="${pageContext.request.contextPath}/resource/images/cream.jpg" class="itemImage"></label>
    <span class="caption">Cream</span>
  </div>
  
  <div class="item">
    <input type="checkbox" id="myCheckbox4" />
<label for="myCheckbox4" ><img src="${pageContext.request.contextPath}/resource/images/Paneer.jpg" class="itemImage"></label>
    <span class="caption">Paneer</span>
  </div>
  
  </div>
  <br>
  
  <label><span> </span><input type="submit" value="Subscribe" />
  
  </form>
  </div>
  
</body>
</html>