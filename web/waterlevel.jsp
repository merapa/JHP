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
			.loginbtn {
				width: auto;
				padding: 10px 18px;
				background-color: #green;
			}
			
			/* Change styles for span and login button on extra small screens */
			@media screen and (max-width: 500px) {
				span.psw {
					display: block;
					float: none;
				}
				.loginbtn {
					width: 100%;
				}
			}
			
			.list {
				max-width: 600px;
				padding: 10px;
			}
			
			section:after {
				content: "";
				display: table;
				clear: both;
				padding: 5px;
			}
			
			.listleft {
				float: left;
			}
			.listright {
				float: right;
				color: #ffffff;
			}
			select {
				width: 34%;
				margin: 3px 0;
				display: inline-block;
				border: 1px solid #ccc;
				box-sizing: border-box;
			}
			
		</style>

	</head>
	<body style="background-color:#193441; overflow: auto;"><!-- overflow: auto;= hide scrollbar -->
		<!-- container start-->
		<%@ include file="header.jsp"%>
		<!-- container end-->
		
		<br>
		<br>
		<br>
		
		<!-- list start-->
		<div class="container" style="background-color:#12252E;">
			<h3 class="a">수위보충</h3>
			<p class="a"> 수위보충 높이를 설정할 수 있습니다. </p>
		</div>
		
		<div align="center" style="height: 890px; padding: 50px;">
			<div class="list" align="center" style="width:100%; background-color:#3E606F;">
				<p align="left" style="padding: 2px;"><b>수조 1</b></p>
				
				<section>
				<div class="listleft" style="width:79%; height: 100px; padding: 3px;"><!-- background-color:blue; -->
					<b>현재상태 : ON</b><br>
					<b>작동수위 : </b>
					<select class="select">
<%	
						int i;
						for(i=20; i<31; i++){
							out.println("\t\t\t\t\t\t" + "<option value=\"" + i + "cm\">" + i + "cm" + "</option>" + "<br>");
						}
					%>
					</select><br>
					<b>중지수위 : </b>
					<select class="select">
<%	
						for(i=20; i<31; i++){
							out.println("\t\t\t\t\t\t" + "<option value=\"" + i + "cm\">" + i + "cm" + "</option>" + "<br>");
						}
					%>
					</select>
					<br>
				</div>
				<div class="listright" style="width:20%; height: 100px; padding: 5px;"><!-- background-color:red; -->
					<button type="submit"><b>적용</b></button><br>
				</div>
				</section>
			</div>
		</div>
		
		<div>
			
		</div>
		<!-- list end-->
		
		<br>
		<br>
		<br>
		

</body>
</html>
