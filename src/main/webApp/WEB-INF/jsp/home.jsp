<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType = "text/html; charset = UTF-8" %>
<html>
<head>
<title>home</title>

     <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:400,600" />

    <link rel="stylesheet" type="text/css"
    			  href="${pageContext.request.contextPath}/resource/css/home.css">

   <link rel="stylesheet" type="text/css"
       			  href="${pageContext.request.contextPath}/resource/css/all.min.css">

     <link rel="stylesheet" type="text/css"
                 href="${pageContext.request.contextPath}/resource/css/bootstrap.min.css">

      <link rel="stylesheet" type="text/css"
                    href="${pageContext.request.contextPath}/resource/css/templatemo-style.css">

    <script type="text/javascript" src=
    			"${pageContext.request.contextPath}/resource/js/home.js">
    </script>
</head>
<body>
<header >
    <div  class="container" id="containerContent">
        <span style="font-size:30px;cursor:pointer;margin-right:10px;display:inline-block;color:#111;" onclick="openNav()"><b>&#9776;</b></span>
            <h1  id="logo"><img height="80px"  src="${pageContext.request.contextPath}/resource/images/logo-solid.png"></h1>
                <nav>
                    <ul>

                        <li>
                        <a href="${pageContext.request.contextPath}/getlogin?role=admin"><b>Admin</b></a>

                        </li>
                        <li><a href="${pageContext.request.contextPath}/getlogin?role=user"><b>User</b></a>
                        </li>
                    </ul>
    </div>
 </header>

<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <a href="#">About</a>
  <a href="${pageContext.request.contextPath}/registerForm">Register</a>

  <a href="#">Contact</a>
    <hr>
  <h3 style="color:#a6a6a6;font-size:21px;margin-bottom:10px;">Admin</h3>
      <c:forEach var="user" items="${userList}">
        <a href="${pageContext.request.contextPath}/userProfile?userId=${user.id}">${user.firstName}</a>
       </c:forEach>
</div>

<div id="main">
   <div class="columns-bg">
         <!-- Logo & Intro -->
         <section id="logoMain" class="tm-section-logo">
           <div class="container-fluid">
             <div class="row">
               <div class="col-sm-12 offset-sm-0 col-md-6 offset-md-6">
                 <div class="tm-site-name-container">
                   <div class="tm-site-name-container-inner">
                     <h1 class="text-uppercase tm-text-primary tm-site-name">
                       Freshness
                     </h1>
                     <p class="tm-text-primary tm-site-description">
                      @doorstep
                     </p>
                   </div>
                 </div>
               </div>
             </div>
           </div>
         </section>

         <!-- Intro -->
         <section id="intro" class="tm-p-1-section-1">
           <div class="container-fluid">
             <div class="row">
               <div class="col-md-6">
                 <div class="tm-section-text-container">
                   <i class="tm-text-white">
                     <p class="mb-0">
                     Why not create a living style where there is not a need of preservatives anymore
                     Why would you When we Freshness@doorstep are here to give you a <b><i>"new way to  live"</i></b>
                      We Freshness@doorstep belive in spreading happiness through providing your house daily utilities in cost friendly and eco friendly manner, at
                      your doorstep . We love to serve customer and welcome sellers who can make the regular customer forget worries of daily utilities.
                      </p>
                   </i>
                 </div>
               </div>
             </div>
           </div>
         </section>

         <!-- Our Place -->
         <section id="our_place">
           <div class="container-fluid">
             <div class="row">
               <div
                 class="col-md-12 col-lg-6 tm-section-image-container tm-img-left-container"
               >
                 <img src="${pageContext.request.contextPath}/resource/images/forty_image_01.jpg" alt="Image" class="img-fluid" />
               </div>
               <div class="col-md-12 col-lg-6">
                 <div class="tm-section-text-container-2">
                   <h2
                     class="tm-text-primary tm-section-title-mb tm-sm-bg-white-alpha"
                   >
                     Milk and its Products
                   </h2>
                   <div class="tm-text-gray">
                     <p class="mb-4">
                     	The cow and buffalow . <a href="index.html">Dairy Milk</a> are best for health
                        and so there self hand made other dairy products. For Milk, Bread, Butter, Lassi etc... you can count on us.
                       </p>
                     <p class="mb-0">
                       We deal with daily diary fresh products, that
                       enrich your health and our goal.
                       we deal 100% pure pure and quality products,
                       from the trusted members of your choice.

                     </p>
                   </div>
                 </div>
               </div>
             </div>
           </div>
         </section>

         <!-- Fusce, Section 4 -->
         <section id="section_4" class="tm-section-4">
           <div class="container-fluid">
             <div class="row flex-column-reverse flex-lg-row">
               <div class="col-md-12 col-lg-6 tm-text-left-container">
                 <div class="tm-section-text-container-3 tm-bg-white-alpha h-100">
                   <h2 class="tm-text-accent tm-section-title-mb">
                     fOR non-Veg frnds
                   </h2>
                   <p class="mb-0">
                     we offer fresh MEAT, FISH, EGGS, etc fresh at
                     your doorstep daily because we know you care
                     for health and
                     hence you are our priority.
                   </p>
                 </div>
               </div>
               <div
                 class="col-md-12 col-lg-6 tm-section-image-container tm-img-right-container"
               >
                 <img
                   src="${pageContext.request.contextPath}/resource/images/forty_image_02.jpg"
                   alt="Image"
                   class="img-fluid tm-img-right"
                 />
               </div>
             </div>
           </div>
         </section>

         <!-- Beautiful Rollovers -->
         <section id="gallery">
           <div class="container-fluid">
             <div class="row">
               <div class="col-12 tm-section-title-mb tm-gallery-title-col">
                 <h2 class="tm-section-title-2">Services</h2>
                 <hr class="tm-section-title-underline" />
               </div>

               <div class="col-12">
                 <div class="grid">
                   <figure class="effect-duke mb-3">
                     <img
                       src="${pageContext.request.contextPath}/resource/images/forty_image_11.jpg"
                       alt="Image"
                       class="img-fluid"
                     />
                     <figcaption>
                       <h2>Customer <span>Care</span></h2>
                       <p>We care of taste, quality and hygine.</p>
                       <a href="#">View more</a>
                     </figcaption>
                   </figure>
                   <figure class="effect-duke">
                     <img
                       src="${pageContext.request.contextPath}/resource/images/forty_image_12.jpg"
                       alt="Image"
                       class="img-fluid"
                     />
                     <figcaption>
                       <h2>Customer <span>Pocket</span></h2>
                       <p>your wish to pay: more or less  how much and when.</p>
                       <a href="page-2.html">View more</a>
                     </figcaption>
                   </figure>
                   <figure class="effect-duke mb-3">
                     <img
                       src="${pageContext.request.contextPath}/resource/images/forty_image_13.jpg"
                       alt="Image"
                       class="img-fluid"
                     />
                     <figcaption>
                       <h2>Mark <span>Anomales</span></h2>
                       <p>Now you do not need to remember because we mark each day.</p>
                       <a href="#">View more</a>
                     </figcaption>
                   </figure>
                   <figure class="effect-duke">
                     <img
                       src="${pageContext.request.contextPath}/resource/images/forty_image_14.jpg"
                       alt="Image"
                       class="img-fluid"
                     />
                     <figcaption>
                       <h2>Automatic <span>Bill</span></h2>
                       <p>Never worry for tough calculations, we do it for you.</p>
                       <a href="#">View more</a>
                     </figcaption>
                   </figure>
                 </div>
               </div>

               <div class="col-md-6 tm-section-col-4">
                 <div class="tm-section-text-container-4">
                   <p class="tm-text-secondary mb-0">
                     If you want to be family of freshness register
                     yourself here. A place which is best for Sellers and Customer
                     nurture relation.
                   </p>
                 </div>
               </div>
             </div>
           </div>
         </section>

         <!-- Contact -->
         <section id="contact" class="tm-section-contact">
           <div class="row tm-contact-section">
             <div class="col-md-6 px-0">
               <div class="tm-bg-white-alpha tm-contact-left">
                 <div class="media mb-5">
                   <a href="#" class="tm-contact-link">
                     <span class="tm-contact-icon-container">
                       <span class="tm-contact-icon-container-inner">
                         <i class="fas fa-phone tm-contact-icon tm-phone-icon"></i>
                       </span>
                     </span>
                     <span class="media-body"> 010-020-0340 </span>
                   </a>
                 </div>
                 <div class="media mb-5">
                   <a href="mailto:" class="tm-contact-link">
                     <span class="tm-contact-icon-container">
                       <span class="tm-contact-icon-container-inner">
                         <i class="fas fa-envelope tm-contact-icon"></i>
                       </span>
                     </span>
                     <span class="media-body"> freshness@doorstep.com </span>
                   </a>
                 </div>
                 <div class="media">
                   <a href="" class="tm-contact-link">
                     <span class="tm-contact-icon-container">
                       <span class="tm-contact-icon-container-inner">
                         <i class="fas fa-map-marker-alt tm-contact-icon"></i>
                       </span>
                     </span>
                     <span class="media-body">
                       6120 Suspendisse ultricies<br />Scelerisque tellus, ID
                       10260<br />Magna aliquet porttitor
                     </span>
                   </a>
                 </div>
               </div>
             </div>
             <div class="col-md-6 px-0">
               <div class="tm-contact-form-container">
                 <form action="index.html" method="POST" class="tm-contact-form">
                   <div class="form-group">
                     <input
                       type="text"
                       id="contact_name"
                       name="contact_name"
                       class="form-control rounded-0 border-top-0 border-right-0 border-left-0"
                       placeholder="Your Name"
                       required
                     />
                   </div>
                   <div class="form-group">
                     <input
                       type="email"
                       id="contact_email"
                       name="contact_email"
                       class="form-control rounded-0 border-top-0 border-right-0 border-left-0"
                       placeholder="Email"
                       required
                     />
                   </div>
                   <div class="form-group">
                     <textarea
                       rows="4"
                       id="contact_message"
                       name="contact_message"
                       class="form-control rounded-0 border-top-0 border-right-0 border-left-0"
                       placeholder="Message"
                       required
                     ></textarea>
                   </div>
                   <div class="text-right">
                     <button type="submit" class="btn tm-btn-submit rounded-0">
                       Send
                     </button>
                   </div>
                 </form>
               </div>
             </div>
           </div>
         </section>

         <section id="outro">
           <div class="container-fluid">
             <div class="row">
               <div class="col-sm-12 col-md-6">
                 <div class="tm-section-text-container-5 tm-text-white">
                   <p>
                     The Tech. lifestyle we live in the modern era
                     is not safe for our health.
                     Adding preservatives is a solution?
                   </p>
                   <i
                     >Why not create a living style where there is not a need of preservatives anymore
                     Why would you When we Freshness@doorstep are here to give you a "new way to  live"</i
                   >
                 </div>
               </div>
               <div class="col-sm-12 col-md-6">
                 <div class="tm-section-text-container-6">
                   <a class="tm-social-icon-container">
                     <span class="tm-social-icon-container-inner">
                       <i class="fab fa-facebook-f"></i>
                     </span>
                   </a>
                   <a class="tm-social-icon-container">
                     <span class="tm-social-icon-container-inner">
                       <i class="fab fa-twitter"></i>
                     </span>
                   </a>
                   <a class="tm-social-icon-container">
                     <span class="tm-social-icon-container-inner">
                       <i class="fab fa-instagram"></i>
                     </span>
                   </a>
                   <a class="tm-social-icon-container">
                     <span class="tm-social-icon-container-inner">
                       <i class="fab fa-google-plus-g"></i>
                     </span>
                   </a>
                 </div>
               </div>
             </div>
             <div class="row">
               <footer class="col-sm-12 col-md-6 offset-md-6 px-md-0">
                 <p class="tm-copyright-text mb-0 tm-text-primary">
                   Copyright &copy;

                   - 1880 : <a rel="nofollow" href="${pageContext.request.contextPath}/">Freshness@doorstep</a>
                 </p>
               </footer>
             </div>
           </div>
         </section>
       </div>

</div>
</body>
</html>