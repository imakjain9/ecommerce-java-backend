function openNav() {
  document.getElementById("mySidenav").style.width = "250px";
  document.getElementById("main").style.marginLeft = "250px";
document.getElementById("containerContent").style.paddingLeft = "250px";
document.getElementById("containerContent").style.width = "75%";
  document.body.style.backgroundColor = "rgba(0,0,0,0.4)";
}

function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
  document.getElementById("main").style.marginLeft= "0";
     document.getElementById("containerContent").style.paddingLeft= "0px";
     document.getElementById("containerContent").style.width = "90%";
  document.body.style.backgroundColor = "white";
}