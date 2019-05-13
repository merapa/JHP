    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
    <%@ page import="java.sql.*"%>
	<%@ page import="javax.sql.*" %>
	<%@ page import="javax.naming.*" %>
	<%@ page import="java.io.PrintWriter" %>
	
<% 
	String Id =null;
	if(session.getAttribute("Id")!=null){
		Id = (String) session.getAttribute("Id");
	}
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8"> 
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<!-- Basic CSS -->
        <link rel="stylesheet" href="css/basic.css">
		
		<!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        
        <!-- jQuery library -->
        <script src="js/jquery-3.3.1.min.js"></script>
        
        <!-- Latest compiled JavaScript -->
        <script src="js/bootstrap.min.js"></script>
        
		<title>JHP UHMS</title>
        
		<style type="text/css">
			a.no-uline {text-decoration:none}
			::-webkit-scrollbar {display: none;}<!-- = hide scrollbar -->
		</style>
		
		
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
			b {
				color: #ffffff;
			}
			
			/*------------------------------------------- */
			button {

				background-color: #4CAF50;
				color: white;
				padding: 20px 20px;
				margin: 20px 0;
				border: none;
				cursor: pointer;
				width: 100%;
			}
			
			button:hover {
				opacity: 0.8;
			}
			.mypagebtn {
					width: auto;
					padding: 10px 18px;
					background-color: #green;
				}
			.logoutbtn {
					width: auto;
					padding: 10px 18px;
					background-color: #green;
				}
				
			img {
				display: block;
				margin-left: auto;
				margin-right: auto;
				max-width: 100%;
			}
		</style>
	</head>
	
	<body style="background-color:#193441; overflow: auto;"><!-- overflow: auto;= hide scrollbar -->
	
		<!-- container start-->
		<%@ include file="header.jsp"%>
		<!-- container end-->
		
		
		<!-- slideshow-container start-->
		<div>
			<div class="slideshow-container" style="background-color: #000000;">
	
	            <div class="mySlides fade">
	                <div class="numbertext">1 / 3</div>
	                <img src="img/01.jpg">
	                <!--
					<div class="text">
						<h2>WELCOME TO UHMS</h2>
						<p>UHMS는 원하는 조건으로 수족관 환경을 일정하게 유지시켜주는 시스템 입니다. 어종에 따른 다양한 환경요소를 자유롭게 관리 및 유지가 가능합니다.</p>
						<footer>From. JHP together</footer>
					</div>
					-->
	            </div>
	    
	            <div class="mySlides fade">
	                <div class="numbertext">2 / 3</div>
	                <img src="img/02.jpg">
					<!--
	                <div class="text">
						<h2>WELCOME TO UHMS</h2>
						<p>UHMS는 원하는 조건으로 수족관 환경을 일정하게 유지시켜주는 시스템 입니다. 어종에 따른 다양한 환경요소를 자유롭게 관리 및 유지가 가능합니다.</p>
						<footer>From. JHP together</footer>
					</div>
					-->
	            </div>
	    
	            <div class="mySlides fade">
	                <div class="numbertext">3 / 3</div>
	                <img src="img/03.jpg">
					<!--
	                <div class="text">
						<h2>WELCOME TO UHMS</h2>
						<p>UHMS는 원하는 조건으로 수족관 환경을 일정하게 유지시켜주는 시스템 입니다. 어종에 따른 다양한 환경요소를 자유롭게 관리 및 유지가 가능합니다.</p>
						<footer>From. JHP together</footer>
					</div>
					-->
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
