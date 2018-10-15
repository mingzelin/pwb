<!-- local & linux difference (before Export)
1:@index.jsp line 9
 -->
 

<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8" 
    import="servlet.ImageHtmlOutput" import="java.io.File"%>
<%ImageHtmlOutput iho = new ImageHtmlOutput(); 
	/*
	"/var/lib/apache-tomcat-7.0.88/webapps/pwb/image/"
	
	"/Users/elin/Documents/workspace/pwb/WebContent/image/"
	
	*/
  int len = iho.countFile("/Users/elin/Documents/workspace/pwb/WebContent/image/");%>
 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>

<%
response.setHeader("Cache-Control", "no-cache"); 
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>



<html lang="en-US">
<head lang="en">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
	<title>Somewhere One Belong</title>
	<link rel="stylesheet" href="../css/code/style.css" type="text/css"> 
	<link href="../css/Lobster/Lobster-Regular.ttf" rel="stylesheet" type="text/css">	
	<style type="text/css">
		<% out.println(iho.ImageCssForm(len));%>	/* java print css 4 images  */
	</style>
</head>
<body>
<script src="../js/jquery3-2-1.js"></script>
<script src="../js/index.js" ></script>
<script src="../js/general.js" ></script>
	<nav> <!-- navigation bar -->
		<br />
		<a href="home.jsp">Home&emsp;|</a>
		<a href="about.jsp">About&emsp;|</a>
		<a href="avalon.jsp">Avalon&emsp;|</a>
		<a href="contact.jsp">Contact&emsp;|</a>
	</nav>
	<div id="popup">
	<h2><span id="symBar">>></span></h2>
		<br /><br /><br />
		
		<h1 style="position:absolute; left: 38%">Welcome to Avalon</h1>
		<br /><br />
		<form method="post" id="loginForm">
			<table>
				<tr>	<td>Username&emsp;</td>										
						<td><input type="text" name ="loginUsrname" id ="loginUsrname" class="loginInput"></td>		</tr>
				<tr>	<td>Password&emsp;</td>
						<td><input type="password" name ="loginPwd" id ="loginPwd" class="loginInput"></td>			</tr>
				<tr>	<td><br /></td></tr>
				<tr>	<td ><a href="#" style="color:#ffffa0; text-decoration:none; padding-right:10%;" onclick="formSwitch()">Join&nbsp;&nbsp;&nbsp;&nbsp;|</a></td>
						<td ><a href="#" type="button" style="color:#ffffa0; padding-left:40%; text-decoration:none;" onclick="loginCheck()">|&nbsp;&nbsp;&nbsp;&nbsp;Login</a></td>																								    </tr>
				<tr>	<td><br /></td></tr>																			    
			</table>
			<p id="loginMsg" style="font-size:13.5px; color:white; text-align:center; text-decoration:none;"></p>
		</form>
		
		<h1 hidden="hidden">Quick Registration</h1>
		<form action="${pageContext.request.contextPath}/RegisterBridge" method="post" hidden="hidden" id="registerForm">
			<table>	
				<tr>	<td>Username&emsp;</td>
						<td><input type="text" name ="usrname" id ="usrname" class="registerInput"></td>		</tr>
				<tr>	<td>Password&emsp;</td>
						<td><input type="password" name ="pwd" id ="pwd" class="registerInput"></td>			</tr>
				<tr>	<td>Re-enter Password&emsp;</td>
						<td><input type="password" name ="repwd" id ="repwd" class="registerInput"></td>		</tr>
				<tr>	<td>Email&emsp;</td>
						<td><input type="text" name ="email" id ="email" class="registerInput"></td>			</tr>
				<tr>	<td><br /></td>													</tr>
				<tr><td>	</td>
					<td><a href="#" type="button" style="color:#ffffa0; text-decoration:none;" onclick="checkForm()">Submit</a></td>	
																						</tr>
			</table>
			<p id="msg" style="font-size:13.5px; color:white; text-decoration:none;"></p>
		</form>
	</div>
	<% out.println(iho.ImageHtmlForm(len));%>	<!-- java print html 4 images -->
</body>
<HEAD> 
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
</html>