    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.sql.*"%>
	<%@ page import="javax.sql.*" %>
	<%@ page import="javax.naming.*" %>
	
<% 
	request.setCharacterEncoding("UTF-8");
	String id =(String)session.getAttribute("id");
	String pass=request.getParameter("pass");
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<!-- Basic CSS -->
        <link rel="stylesheet" href="css/basic.css">
		
		<!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        
        <!-- jQuery library -->
        <script src="js/jquery-3.3.1.min.js"></script>
        
        <!-- Latest compiled JavaScript -->
        <script src="js/bootstrap.min.js"></script>
		
		
		
		<style type="text/css">
		a.no-uline {text-decoration:none}>
			h1 {
			color: #ffffff;
			}
			h2 {
				color: #ECF7D5;
			}
			h3 {
				color: #91AA9D;
			}
			h3.a {
				color: #ECF7D5;
			}
			h5 {
				color: #ffffff;
				height: 35px;
				/*Basically, the H-tag has a margin and padding */
				margin: 0;
	  			padding: 0;
	  			vertical-align: middle; /*middle centred*/
	  			display:table-cell; /*acts like a table cell*/
			}
			p {
				color: #D3E0E0;
				font-size: 18px;
			}
			p.a {
				color: #D3E0E0;
				font-size: 14px;
			}
		</style>

</head>
	<body style="background-color:#193441">
		<!-- container start-->
		<div class="container">
			<a href="index_login.html" class="no-uline" ><h1>UHMS<small> Underwater Homeostatic Maintenance System </small></h1></a>
			<h3>수중생태 항상성 유지 시스템</h3>
			
			<!-- login form start-->
			<div class="topnav">
				<div class="login-container">
				<%=id %>님의 설정 화면 <br> <br>
				<h4 align="right"><input type="button" onclick="location.href='Boardinfo.jsp'" value="내 정보" ></h4>
				<h4 align="right"><input type="button" onclick="location.href='loginForm.jsp'" value="로그아웃"></h4>
				</div>
			</div>
			<!-- login form end-->
			
			<div class="row" align="center">
				<div class="col-sm-2" style="background-color:#3E606F"><a href="light.jsp"><h5>조명</h5></a></div>
				<div class="col-sm-2" style="background-color:#12252E"><a href="heat.jsp"><h5>히터</h5></a></div>
				<div class="col-sm-2" style="background-color:#3E606F"><a href="cooling.jsp"><h5>쿨러</h5></a></div>
				<div class="col-sm-2" style="background-color:#12252E"><a href="waterlevel.jsp"><h5>수위보충</h5></a></div>
				<div class="col-sm-2" style="background-color:#3E606F"><a href="feed.jsp"><h5>먹이자동급여</h5></a></div>
				<div class="col-sm-2" style="background-color:#12252E"><a href="list.jsp"><h5>수조목록</h5></a></div>
			
			
			</div>
		</div>
		<!-- container end-->
		
		<br>
		<br>
		<br>
		
		<!-- list start-->
		<div class="container" style="background-color:#12252E">
			<h3 class="a">조명</h3>
			<p class="a"> 조명의 점등/소등 시간을 설정할 수 있습니다. </p>
		</div>
		
		<div style="height: 890px">
			<br>
		</div>
		<!-- list end-->
		
		<br>
		<br>
		<br>
		

</body>
</html>