<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en-US">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link rel="stylesheet" href="../css/code/style.css" type="text/css"> 
<link rel="stylesheet" href="../css/code/home.css" type="text/css"> 
<link href="../css/Lobster/Lobster-Regular.ttf" rel="stylesheet" type="text/css">	
<title>Avalon ~ where u belong</title>
</head>
<body>
<script src="../js/jquery3-2-1.js"></script>
<script src="../js/home.js" ></script>
<script src="../js/vue.js" ></script>
<script src="../js/general.js" ></script>


<!-- <input type ="hidden" name="windowSizeX" id="windowSizeX">
<input type ="hidden" name="windowSizeY" id="windowSizeY"> -->
	<div class="profileImage"></div>
	<nav> <!-- navigation bar -->
		<br />
		<a href="home.jsp">Home&emsp;|</a>
		<a href="about.jsp">About&emsp;|</a>
		<a href="avalon.jsp">Avalon&emsp;|</a>
		<a href="contact.jsp">Contact&emsp;|</a>
	</nav>
	
	<div id="popbar" >
	<h2><span id="symBar">>></span></h2>
		<table id="poptable">
			<tr><td class="popbarRow"><a href="#">Account</a></td></tr>
			<tr><td class="popbarRow"><a href="#">Message</a></td></tr>
			<tr><td class="popbarRow"><a href="#">Friends</a></td></tr>
			<tr><td class="popbarRow"><a href="#">More</a></td></tr>
		</table>
	</div>
	
	<div id="tweet">
	<p class ="hello" >You are welcome to tweet anthing you like</p>	
	<textarea id="twitter" rows = "4" cols = "140" maxlength = "300"></textarea>
	<br /><br />
	<button onclick="msgPost(document.getElementById('twitter').value)">  post  </button>
	</div>

</body>
</html>