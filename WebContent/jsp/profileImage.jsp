<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en-US">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
	<link rel="stylesheet" href="../css/code/profileImage.css" type="text/css" /> 
    <link rel="stylesheet" href="../css/code/home.css" type="text/css" />  
	<link rel="stylesheet" href="../css/code/style.css" type="text/css" /> 
	<link rel="stylesheet" href="../css/Lobster/Lobster-Regular.ttf" type="text/css" />
	<link rel="stylesheet" href="../cropper/scss/ng-img-crop.scss" type="text/css" />
	
<title>Avalon ~ where u belong</title>

</head>
<body ng-app="app" ng-controller="Ctrl">
<script src="http://apps.bdimg.com/libs/angular.js/1.4.6/angular.min.js"></script>
<script src="../cropper/js/ng-img-crop.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="../js/general.js" ></script>
<script src="../js/profileImage.js" ></script>
	<nav> <!-- navigation bar -->
		<br />
		<a href="home.jsp">Home&emsp;|</a>
		<a href="about.jsp">About&emsp;|</a>
		<a href="avalon.jsp">Avalon&emsp;|</a>
		<a href="contact.jsp">Contact&emsp;|</a>
	</nav>

	<div class="accountQuery">
		<ul>
 		 <li><a href="#">Profile&nbsp;Figure</a></li>
 		 <li><a href="#">Personal&nbsp;Info</a></li>
 		 <li><a href="#">Signature</a></li>
  		 <li><a href="#">Settings</a></li>
  		 <li><a href="#">Background</a></li>
		</ul>
	</div>


  <div id="top">Select profile image: <input type="file" id="fileInput" /></div>
  <div class="cropArea">
    <img-crop image="myImage" result-image="myCroppedImage"></img-crop>
  </div>
  
  <div hidden><img ng-src="{{myCroppedImage}}" id="cropped"/></div>
  <button onclick="uploadImg()">upload</button>
  
		
	
	<!-- <form method="post" id ="uploadImageForm" enctype="multipart/form-data">
		<p id="uploadImageTitle">Upload&nbsp;Your&nbsp;Image</p>
		<br /><br />
		<input type="file" name="uploadImageFile" id="uploadImageFile">
		<br /><br /><br />
		<a href="#" type="button" id="uploadImageSubmit" onclick="uploadFile()">Submit</a>
	</form> 
	 -->
</body>
</html>