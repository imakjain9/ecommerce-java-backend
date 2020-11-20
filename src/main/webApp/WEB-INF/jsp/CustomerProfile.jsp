<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType = "text/html; charset = UTF-8" %>

<html>
<head>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
<style>
	@import url('https://fonts.googleapis.com/css?family=PT+serif');
body{
    background-image: linear-gradient(to right, #8490ff 0%, #62bdfc 48%, #8490ff 100%);
     padding:0;
      margin:1;
}
i{
    color:#0f97f9;
}
h2{
    color:#4a90e2;
     line-height:5px;
      font-family: 'PT Mono', monospace;
}
h5{
    color:#aaa;
     font-family: 'PT Mono', monospace;
}
#lastName{
    color:orange;
}
#title{
    line-height:5px;
}
li{
    display:inline-block  ;
    margin:6px;
}
.cardContainer{ 
  padding-top:30px;    
}
.profileImg{
 z-index:3;
  position:relative;
   border-radius:100%;
    width:120px;
     height:120px;
      border:4px solid #0f9ff9;
       overflow:hidden ;
        position:;
        /*transform:translateY(20%);*/
         margin:0 auto;
          text-align:center;     
           box-shadow: 0 15px 20px rgba(0, 0, 0, 0.3);      
              -webkit-transform: translatey(0px);
    -webkit-animation: float 6s ease-in-out infinite; 
}



.profileCard{
    width:90%;
     height:400px;
      background:#f2f2f2;
       margin:0 auto ;
        border-radius:10px;
         position:;
          transform:translateY(-60px);
           z-index:;
            box-shadow: 0 15px 20px rgba(0, 0, 0, 0.4); 
            
       
}

.profileHead{
    padding-top:90px;
     margin:0 auto ;
      text-align:center;
}

hr{
    width:50%;
}

.profileBody{
  text-align:center;
   padding-top:20px;
}

#readM{
    color:#aaa;
}
.profileBody p{
    color:#aaa;
    line-height:5px;
}

.Txt{
    width:100%;
     overflow:hidden ;
      margin:20px;
}
.contains-Txt{
    width:33.3%;
     float:left;
      text-align:center;
      
}

button{
  padding: 0px 42px;
   width:50%;
   line-height: 40px;
    background-image: linear-gradient(to right, #8490ff 0%, #62bdfc 48%, #8490ff 100%);
    border:0px;
     background-size: 200% auto;
      color: #fff;
       border-radius: 5px;
        font-size: 13px;
         font-weight: 500;
          transition: all 300ms linear 0s; 
           -webkit-transform:rotateX(0deg);
            outline:none;
}
button:hover {
    background-position: right center;
     color: #fff;
      }
.profileFooter{
    padding-top:20px;
}
.fab{
    font-size:25px;
     padding:10px;
}
.fab:hover{
    background:#0f97f9;
     color:#202020;
      width:20px;
       height:20px;
        padding:10px;
         border-radius:100%;
          transition:0.4s;
}
@-webkit-keyframes rotate{
  from{-webkit-transform:rotateX(0deg);}
  to{-webkit-transform:rotateX(360deg);}
}
@-webkit-keyframes rotateD{
 from{-webkit-transform:rotateX(360deg);}
  to{-webkit-transform:rotateX(0deg);}
}
@keyframes rotatex{
    from{-webkit-transform:rotateY(0deg);}
  to{-webkit-transform:rotateY(180deg);}
}
@keyframes float {
    0% {
        box-shadow: 0 5px 15px 0px rgba(0,0,0,0.6);
        transform: translatey(0px);
    }
    50% {
        box-shadow: 0 25px 15px 0px rgba(0,0,0,0.2);
        transform: translatey(-15px);
    }
    100% {
        box-shadow: 0 5px 15px 0px rgba(0,0,0,0.6);
        transform: translatey(0px);
    }
}

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>

<body>

<div class="cardContainer">
<div class="imgBorder">
<div class="profileImg"><a href="https://www.sololearn.com/Profile/14832357"><img src="${pageContext.request.contextPath}/resource/images/mom.jpg" width=150px >
<!-- src="https://lh3.googleusercontent.com/NN4I9CY3sLNq6Gpr9rxbWsKFTaa3XGiBzrCRLA4SoTvhmsHqqxUxGpshBdsyRGKdGepKgNiWXgKSquS9gdzjWL6hmbzxdDcSLebJPDoEaTugXk3AHa8f8Q4hZd3clxu5nQCQBsdGdg=w2400" 
--> 
</a>    
</div>
</div>
 <div class="profileCard"> 
   <div class="profileHead">
    <h2>${customerId.customer_name}<span id="lastName">Name</span></h2>
    <h5><i class="far fa-envelope"></i>@${customerId.customer_email}</h5>
    <h5>${customerId.customer_phone}</h5>
    <h5><i class="fas fa-map-marker-alt"></i>${customerId.customer_address}</h5>
    <p id="title">Registered User</p>
    </div>
    <hr color="#aaa">
    <div class="profileBody">
        <div class="contains-Txt">
           <!-- <i class="fas fa-users"></i> -->
			Subscribed Item<p id="followerCount">Milk</p>
							<p id="followerCount">Milk</p>
        </div>        
         <div class="contains-Txt">
            <i class="far fa-edit"></i>Quantity<p>1 liter</p>
											<p>6 liter</p>
        </div>
        <div class="contains-Txt">
		<!--	<i class="fas fa-code"></i> -->
			Start Date<p>11 Jan 2020</p>
					<p>11 Jan 2020</p>
        </div>                
  <div>
     <button id="btn_change"><a href="${pageContext.request.contextPath}/getPayment?customerId=${customerId.id}">Payment</a></button>
     <div class="profileFooter">
         <div class="contains-Txt">
             <i class="fab fa-facebook-f"></i>
             </div>
             <div class="contains-Txt">
             <img class="fab" src="https://2.bp.blogspot.com/-B9EEw0IxwuA/XE9rkxCSdII/AAAAAAAAJ-c/KU59wCCF6i8WVTogzDxQAIAShYtERP8HACLcBGAs/s1600/1548708645758.png" width="25px">
         </div>
         <div class="contains-Txt">
            <i class="fab fa-instagram"></i>
             </div>
     </div>
  </div>
      </div>
   </div>  
  </div>    
</div>
<script>                                      window.flag=false;
    function changeFollow() {
    var textToChange=document.getElementById("btn_change");
    var followerAdd=document.getElementById("followerCount");
    window.flag=!window.flag;
        if (window.flag) {
            textToChange.innerHTML= "following"
            textToChange.style.webkitAnimation="rotate 1s linear 0s";
            followerAdd.innerHTML =+35 + +1;
            }
        else{
            textToChange.innerHTML= "Follow Me!"
           textToChange.style.webkitAnimation="rotateD 1s linear 0s";
           followerAdd.innerHTML =35 - 1;
        }
    }; 
</script>
</body>
</html>