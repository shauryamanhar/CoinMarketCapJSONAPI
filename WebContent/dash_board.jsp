<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
p{
	font:30px;
	color:red;
}
</style>
<body onload="loadDoc()">
	<p id="print"></p>
	<button onclick="coin()">hey</button>
	<script>
		function coin(){
			loadDoc();
			var i=0
				setInterval(function(){ loadDoc(); }, 10000);
				console.log(i++);
		}
		function loadDoc() {
			var xhttp = new XMLHttpRequest();
			xhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					/* document.getElementById("print").innerHTML = this.responseText; */
					var res = this.responseText;
					var resArray=res.split(":");
					console.log(resArray);
					for(var i=0;i<15;i++){
						document.getElementById(i).innerHTML=resArray[i];
					}
				}
			};
			xhttp.open("GET", "GetCoinDetails", true);
			xhttp.send();
		}
	</script>
	<div class="coin">
	id=<p id="0"></p><br>
	name=<p id="1"></p><br>
	symbol=<p id="2"></p><br>
	rank=<p id="3"></p><br>
	price usd=<p id="4"></p><br>
	price bcd=<p id="5"></p><br>
	24 hour vol usd=<p id="6"></p><br>
	market cap usd=<p id="7"></p><br>
	available supply=<p id="8"></p><br>
	total supply=<p id="9"></p><br>
	max supply=<p id="10"></p><br>
	percent change 1 Hour=<p id="11"></p><br>
	percent change 24 Hour=<p id="12"></p><br>
	percent change 7 Days=<p id="13"></p><br>
	last update=<p id="14"></p><br>
	</div>
</body>
</html>