<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType = "text/html; charset = UTF-8" %>
<html>
<head>
	<style>
		@import url("https://fonts.googleapis.com/css2?family=Lato:wght@400;700;900&display=swap");
:root {
  --primary: #323232;
  --light-bg: #f4f4f4;
  --border: #eee;
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
		.image_block_inner img{
			width:200px;
			height:200px;
			padding-right:20px;
			margin:inherit;
		}

		.title{
			color:black;

           padding: 2px 3px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            border:solid 1px;
            font-size:10px;
			font-weight:bold;
		}
		.date{
            display: flex;
            justify-content: space-between;
			margin-top:8px;
			font-size:20px;
			font-weight:bold;}
* {
  margin: 0;
  padding: 0;
  -webkit-box-sizing: border-box;
          box-sizing: border-box;
  -webkit-tap-highlight-color: rgba(0, 0, 0, 0);
  font-family: Lato;
}

body {
  background-color: #323232;
  min-height: 100vh;
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-pack: center;
      -ms-flex-pack: center;
          justify-content: center;
  -webkit-box-align: center;
      -ms-flex-align: center;
          align-items: center;
  color: var(--primary);
}

.card {
  width: 70%;
  max-width: 1100px;
  background-color: #fff;
  padding: 3rem;
}

.card__header {
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-align: center;
      -ms-flex-align: center;
          align-items: center;
  margin-top: -15px;
}

.card__profile img {
  border-radius: 50%;
  height: 5rem;
  width: 5rem;
  -o-object-fit: cover;
     object-fit: cover;
}

.card__name {
  margin-left: 1.25rem;
}

.card__handle {
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-align: center;
      -ms-flex-align: center;
          align-items: center;
  margin-top: 3px;
}

.card__button svg {
  height: 1.05rem;
  width: 1.05rem;
  margin-right: 5px;
}

.card__button {
  margin-left: auto;
}

.card__button button {
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-align: center;
      -ms-flex-align: center;
          align-items: center;
  font-size: 1.05rem;
  background-color: var(--primary);
  color: white;
  font-weight: bold;
  border: none;
  height: 40px;
  width: 130px;
  -webkit-box-pack: center;
      -ms-flex-pack: center;
          justify-content: center;
  cursor: pointer;
}

.card__button button:active {
  -webkit-transform: scale(0.96);
          transform: scale(0.96);
}
.border {
  border-radius: 5px;
  height: 2px;
  background-color: var(--border);
  border: none;
  margin: 1.25rem 0;
}
.navlinks {
  list-style: none;
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  margin-bottom: 1.25rem;
}

.navlinks li {
  opacity: 0.5;
  -webkit-transition: opacity 200ms ease-in-out;
  transition: opacity 200ms ease-in-out;
  cursor: pointer;
}

.navlinks li:first-child {
  opacity: 1;
  font-weight: bold;
}
@media (max-width: 740px) {
  .card {
    width: 90%;
  }
  .navlinks {
    display: none;
  }
}

@media (max-width: 545px) {
  .card__button button {
    width: 40px;
    -webkit-box-pack: center;
        -ms-flex-pack: center;
            justify-content: center;
  }
  .card__button button span {
    display: none;
  }
  .card__button button svg {
    margin-right: 0;
  }
}

@media (max-width: 475px) {
  .card__button {
    display: none;
  }
}
	</style>
</head>
<body>
	<div class="card">
      <div class="card__header">
        <div class="card__profile">
          <img
            src="https://randomuser.me/api/portraits/men/52.jpg"
            alt="A man smiling"
          />
        </div>
        <div class="card__name">
          <h2>Admin</h2>

        </div>
        <div class="card__button">
          <button>
            <svg
              xmlns="http://www.w3.org/2000/svg"
              width="24"
              height="24"
              viewBox="0 0 24 24"
              fill="none"
              stroke="#fff"
              stroke-width="2"
              stroke-linecap="round"
              stroke-linejoin="round"
              class="feather feather-edit"
            >
              <path
                d="M11 4H4a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h14a2 2 0 0 0 2-2v-7"
              ></path>
              <path
                d="M18.5 2.5a2.121 2.121 0 0 1 3 3L12 15l-4 1 1-4 9.5-9.5z"
              ></path>
            </svg>
				<a href="${pageContext.request.contextPath}/items/new" style="text-decoration:none;color:white;">Add Items</a>
          </button>
        </div>
      </div>
      <hr class="border" />
      <nav>
        <ul class="navlinks">
          <li class="link__item">Available Items</li>
        </ul>
      </nav>
      <c:forEach var="item" items="${itemList}">
     <div class="image_block" id="image_block">
		<div class="image_block_inner">
		<img src="${item.url}" />
		 </div>
		 <a style="background-color:yellow;" class="title" href="${pageContext.request.contextPath}/itemedit?itemId=${item.id}">edit</a>
		 <a style="background-color:red;" class="title" href="${pageContext.request.contextPath}/itemdelete?itemId=${item.id}">delete</a>

        <div class="date">
		    <div >${item.name}</div>
		    <div >${item.price}/liter</div>
        </div>
    </div>
    </c:forEach>
</div>

</body>
</html>