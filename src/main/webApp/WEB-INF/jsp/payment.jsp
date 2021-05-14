<html>
<head>
	<style>
		@import url('https://rsms.me/inter/inter-ui.css');
body {
  align-items: center;
  background: linear-gradient(-45deg, #210242, #9198e5);
  display: flex;
  font-family: 'Inter UI', sans-serif;
  height: 100vh;
  justify-content: center;
  margin: 0;
  width: 100vw;
}
.card {
  background: white;
  border-radius: 12px;
  box-shadow: 0 14px 28px rgba(0,0,0,0.25), 0 10px 10px rgba(0,0,0,0.22);
  height: 200px;
  overflow: hidden;
  padding: 20px;
  position: relative;
  width: 300px;
}
.title {
  font-size: 1.5em;
  height: 29px;
  margin-bottom: 0;
}
.text {
  color: #667;
  font-size: 1em;
  height: 38px;
  margin: 5px 0 0;
}
.line {
  left: 0;
  position: absolute;
  width: 340px;
}
.line path {
  fill: none;
  stroke: black;
  stroke-width: 2;
  stroke-dasharray: 300 1903;
}
.card.saving .line path {
  stroke-dashoffset: -472;
  stroke-dasharray: 153 1903;
  transition: stroke-dasharray 500ms, stroke-dashoffset 500ms;
}
.card.done .line path {
  stroke-dashoffset: -762;
  stroke-dasharray: 1095 1903;
  transition: stroke-dasharray 1500ms, stroke-dashoffset 1500ms;
}
.card .closebtn {
  position: absolute;
  top: 0;
  text-decoration:none;
  text-color:black;
  visibility: hidden;
  right: 25px;
  font-size: 36px;
  margin-left: 50px;
}
.line2 {
  height: 52px;
  left: 150px;
  opacity: 0;
  position: absolute;
  stroke-dasharray: 6 48;
  stroke-dashoffset: -42;
  top: 158px;
  transform-origin: 50%;
  width: 50px;
}
.card.saving .line2 {
  animation: 4s 500ms Rotate forwards;
}
.card.done .line2 {
  animation: 500ms ScaleDown forwards;
}
.form {
  transform-origin: 0 50%;
  transition: transform 500ms, opacity 500ms;
}
.card.saving .form {
  transform: translateY(-16px) scale(.8);
}
.card.done .form {
  transform: translateY(-16px) scale(.8);
  opacity: 0;
}
.input {
  background: transparent;
  border: 0;
  box-sizing: border-box;
  font-size: 20px;
  height: 40px;
  margin-top: 20px;
  outline: none !important;
  position: relative;
  width: 300px;
}
@keyframes Rotate {
  0% { transform: rotate(0); opacity: 1; }
  25% { transform: rotate(360deg); opacity: 1; }
  50% { transform: rotate(720deg); opacity: 1; }
  75% { transform: rotate(1080deg); opacity: 1; stroke-dasharray: 6 48; stroke-dashoffset: -42;}
  100% { transform: rotate(1080deg); opacity: 1; stroke-dashoffset: 0; stroke-dasharray: 36 48;}
}
@keyframes ScaleDown {
  0% { transform: scale(1); }
  100% { transform: scale(0);}
}

	</style>
	
</head>
<body>
	<div class="card">
	<a href="javascript:void(0)" class="closebtn" onclick="submitForm();" >&times;</a>
  <h2 class="title">SAVE</h2>
  <p class="text">payment on ${date}  and press enter</p>
  <svg class="line" viewBox="0 0 340 110">
    <path d="m 20,62 h 300 c 5.07319,0 8,1.670904 8,7 0,5.329096 -2.73823,7 -8,7 -24.40669,0 -93.75,-28.499714 -145,-28.499714 -13.29554,0 -24.13778,10.98399 -24.13778,24.285714 0,13.301723 10.44743,24.237614 23.78064,24.285714 13.33321,0.0481 24.42131,-10.813044 24.42131,-24.071428 0,-13.258384 -10.82413,-24.5 -24.06417,-24.5 -46.6329,0 -128.373847,2.554751 -134.142712,-0.714429 -6.526479,-3.774256 26.308057,-20.255082 34.999996,-9.643143 4.903867,7.581481 -24.727058,37.748285 -20.714286,41.071429 5.780539,4.585834 41.58559,-45.698305 42.857143,-44.285714 1.788869,2.052458 -26.042394,35.843635 -22.946429,38.125 1.087036,0.763507 10.593224,-22.190977 18.660715,-15.982143 2.161943,1.842808 -9.534575,14.127851 -5.357143,17.5 1.588146,1.140006 10.876171,-3.735915 12.142856,-6.785715 4.42342,-9.489522 20.62535,-12.439397 19.28571,-14.285714 -2.58964,-1.846317 -18.17185,8.21922 -19.64285,13.571429 -0.667432,2.762923 0.003,7.475416 2.94643,8.214285 8.14685,2.711358 14.2347,-20.563532 17.03825,-18.181019 1.15308,0.952082 -9.13954,14.501641 -5.34183,17.823876 2.19057,1.447235 9.43338,-3.42711 12.5,-6.785714 3.06662,-3.090747 5.78766,-12.398459 8.21429,-10.714286 1.47961,1.226912 -10.72645,15.162377 -8.83929,16.964286 1.05558,0.891874 7.64823,-23.58045 18.69629,-17.321714 3.66503,2.357086 -9.07288,14.177268 -5.57129,17.143143 1.5373,1.537304 5.32487,0.597632 11.78572,-4.910715 6.46085,-5.508346 21.19805,-33.351382 23.30357,-32.053571 1.48053,1.208524 -25.5179,35.835564 -23.92858,37.589286 1.58933,1.843006 16.25079,-25.121326 22.76786,-19.107143 7.23135,7.353468 -15.77045,11.573353 -15.71428,13.839286 0.0562,2.53379 4.17316,5.462985 7.67857,5.803571 3.50541,0.340586 2.8953,-2.53583 9.82143,-6.517857 6.92613,-3.982027 30.53313,-16.352772 32.5,-14.642857 0.97719,0.939557 -22.54277,16.133127 -9.28571,18.928571 4.90102,0.88702 18.14747,-15.862165 19.28571,-15 1.11657,0.829669 -20.39244,29.235854 -16.42857,32.142857 1.05257,0.88407 8.21065,-16.928914 15.99374,-23.200825 7.7831,-6.271911 19.42199,-11.35048 18.64912,-12.51346 -1.83981,-2.419325 -12.6417,6.752679 -13.57143,11.428571 -0.92973,4.675892 0.64137,9.149855 5,9.642857 4.35863,0.493002 7.78601,-9.507611 8.76532,-12.843682 0.97931,-3.336071 3.34127,-6.934435 1.21487,-7.266498 -1.76926,-0.242777 -3.15302,6.045268 -2.95091,8.311776 0.20211,2.266508 0.10348,6.38561 3.43432,6.756934 2.88441,0.371324 11.99135,-16.657801 14.89354,-14.95853 1.31485,0.967808 -14.93493,13.219228 -8.21429,17.678572 6.72064,4.459344 20.01106,-20.369503 21.25,-19.196429 2.81731,2.873219 -15.21778,16.979645 -9.46428,20.803571 9.94993,6.770354 35.49608,-39.767387 37.85714,-37.5 3.2143,2.809447 -16.97303,19.144321 -16.42857,24.642858 0.54446,5.498537 2.14464,-0.117739 2.5,2.5 0.35536,2.617739 -3.91382,11.36668 -6.07143,10.714285 -2.06832,-0.384538 -0.81191,-3.639808 -0.0893,-4.910715 0.72263,-1.270907 1.69643,3.571429 1.69643,3.571429" />
  </svg>
  <svg class="line2" viewBox="0 0 50 52">
    <path style="fill:none;stroke:#000000;stroke-width:2" d="m 38.391765,17.110953 -16.66751,16.667516 -7.81073,-7.201053 c -2.56639,-2.366065 -3.80148,-3.574166 -6.56097,-5.722314 l -4.6426304,-1.736535"/>
  </svg>
  <form class="form" action="${pageContext.request.contextPath}/payment/add?customer=${customer}" method="post">
    
	 <input type="txt" class="input" name="amount"  placeholder="0.00" required>
  </form>
</div>
<script>

		const card = document.querySelector('.card'),
      input = document.querySelector('.input'),
       btn=document.querySelector('.closebtn'),
        line2 = document.querySelector('.line2');
document.querySelector('.form').addEventListener('submit', function(e) {

  input.blur();
  card.classList.add('saving');
e.preventDefault();
e.stopPropagation();
});
line2.addEventListener('animationend', function(e) {
  setTimeout(() => {
    card.classList.add('done');
  }, 1000);
btn.style.visibility="initial";
});
function submitForm(){
	 document.querySelector('.form').submit();
}

	</script>
</body>
</html>