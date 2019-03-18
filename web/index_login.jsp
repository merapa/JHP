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


	<head>
		<meta charset="utf-8"> 
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
	<!-- 	 a href 링크 밑줄 없애는거
		<style type="text/css">
		a:link{text-decoration:none:}
		a:visited{text-decoration:none;}
		a:active{text-decoration:none;}
		a:hover{text-decoration:underline;}
		</style> -->
		
		
		<!-- Basic CSS -->
        <link rel="stylesheet" href="css/basic.css">
		
		<!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        
        <!-- jQuery library -->
        <script src="js/jquery-3.3.1.min.js"></script>
        
        <!-- Latest compiled JavaScript -->
        <script src="js/bootstrap.min.js"></script>
		
		
		
		<style>
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
			h4 {
				color: #ffffff;
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
			<a href="index.html" text-decoration:none ><h1>UHMS<small> Underwater Homeostatic Maintenance System </small></h1></a>
			<h3>수중생태 항상성 유지 시스템</h3>
			
			<!-- login form start-->
			<div class="topnav">
				<div class="login-container">
					<form action="loginForm.jsp">
						<h4 align="right"><%=id%> 님 환영합니다.</h4>
						<h4 align="right"><button type="submit" onclick=" " >내 정보</button></h4>
						<h4 align="right"><button type="submit">로그아웃</button></h4>
					</form>
				</div>
			</div>
			<!-- login form end-->
			
			<div class="row" align="center">
				<div class="col-sm-2" style="background-color:#3E606F"><a href="light.html"><h5>조명</h5></a></div>
				<div class="col-sm-2" style="background-color:#12252E"><a href="heat.html"><h5>히터</h5></a></div>
				<div class="col-sm-2" style="background-color:#3E606F"><a href="cooling.html"><h5>쿨러</h5></a></div>
				<div class="col-sm-2" style="background-color:#12252E"><a href="waterlevel.html"><h5>수위보충</h5></a></div>
				<div class="col-sm-2" style="background-color:#3E606F"><a href="feed.html"><h5>먹이자동급여</h5></a></div>
				<div class="col-sm-2" style="background-color:#12252E"><a href="list.html"><h5>수조목록</h5></a></div>
			
			</div>
		</div>
		<!-- container end-->
		
		
		<!-- slideshow-container start-->
		<div style="height: 890px">
			<div class="slideshow-container">
	
	            <div class="mySlides fade">
	                <div class="numbertext">1 / 3</div>
	                <img src="img/01.jpg" style="width:100%">
	                <div class="text">
						<h2>WELCOME TO UHMS</h2>
						<p>UHMS는 원하는 조건으로 수족관 환경을 일정하게 유지시켜주는 시스템 입니다. 어종에 따른 다양한 환경요소를 자유롭게 관리 및 유지가 가능합니다.</p>
						<footer>From. JHP together</footer>
					</div>
	            </div>
	    
	            <div class="mySlides fade">
	                <div class="numbertext">2 / 3</div>
	                <img src="img/02.jpg" style="width:100%">
	                <div class="text">
						<h2>WELCOME TO UHMS</h2>
						<p>UHMS는 원하는 조건으로 수족관 환경을 일정하게 유지시켜주는 시스템 입니다. 어종에 따른 다양한 환경요소를 자유롭게 관리 및 유지가 가능합니다.</p>
						<footer>From. JHP together</footer>
					</div>
	            </div>
	    
	            <div class="mySlides fade">
	                <div class="numbertext">3 / 3</div>
	                <img src="img/03.jpg" style="width:100%">
	                <div class="text">
						<h2>WELCOME TO UHMS</h2>
						<p>UHMS는 원하는 조건으로 수족관 환경을 일정하게 유지시켜주는 시스템 입니다. 어종에 따른 다양한 환경요소를 자유롭게 관리 및 유지가 가능합니다.</p>
						<footer>From. JHP together</footer>
					</div>
	            </div>
	
			</div>
			<br>
	
			<div style="text-align:center">
	            <span class="dot"></span> 
	            <span class="dot"></span> 
	            <span class="dot"></span> 
			</div>
		</div>
		<!-- slideshow-container end-->
		
		
		<!-- slideshow-container JavaScript -->
		<script>
			var slideIndex = 0;
			showSlides();
			
			function showSlides() {
				var i;
				var slides = document.getElementsByClassName("mySlides");
				var dots = document.getElementsByClassName("dot");
				for (i = 0; i < slides.length; i++) {
				slides[i].style.display = "none";  
				}
				slideIndex++;
				if (slideIndex > slides.length) {slideIndex = 1}    
				for (i = 0; i < dots.length; i++) {
				dots[i].className = dots[i].className.replace(" active", "");
				}
				slides[slideIndex-1].style.display = "block";  
				dots[slideIndex-1].className += " active";
				setTimeout(showSlides, 3000); // Change image every 3.000 seconds
			}
		</script>
	
		<br>
		<br>
		<br>
		
	</body>
</html> 