<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<% 
	request.setCharacterEncoding("UTF-8");
	String id =(String)session.getAttribute("id");
	String pass=request.getParameter("pass");
	String email =(String)session.getAttribute("email");
	%>
    <%!
		
		Connection connection;
		Statement statement;
		ResultSet resultSet;
		
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/JHP";
		String uid = "jhp";
		String upass = "01230123";
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
			
			table {
				font-family: arial, sans-serif;
				border-collapse: collapse;
				width: 100%;
			}
			th {
				background-color: #122522;
			}
			td, th {
				border: 1px solid #000000;
				text-align: left;
				padding: 8px;
				color: #ffffff;
			}

			tr:nth-child(even) {
				background-color: #12252E;
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
			<h3 class="a">수조목록</h3>
			<p class="a"> 수조관리 상태를 종합적으로 확인할수 있습니다. </p>
		</div>
		
		<div align="center" style="padding: 50px;">
			<div class="list" align="center" style="width:100%; background-color:#3E606F;">
				<p align="left" style="padding: 2px;"><b>수조 환경 설정 내용</b></p>
				
				<section>
				<div class="listleft" style="width:100%; padding: 5px;" align="left"><!-- background-color:blue; -->
					<%
						try{
							Class.forName(driver);
							connection = DriverManager.getConnection(url, uid, upass);
							statement = connection.createStatement();
							
							String query = "select * from control";
							resultSet = statement.executeQuery(query);
							
							while(resultSet.next()){
								String light_on = resultSet.getString("light_on");
								String light_off = resultSet.getString("light_off");
								String heater_on = resultSet.getString("heater_on");
								String heater_off = resultSet.getString("heater_off");
								String cooler_on = resultSet.getString("cooler_on");
								String cooler_off = resultSet.getString("cooler_off");
								String water_on = resultSet.getString("water_on");
								String water_off = resultSet.getString("water_off");
								String feed1 = resultSet.getString("feed1");
								String feed2 = resultSet.getString("feed2");
								
								out.println("<table>");
								out.println("<tr><th>항목</th><th>값 1</th><th>값 2</th></tr>");
								out.println("<tr><td>Light</td><td>ON : " + light_on + " </td><td>OFF : " + light_off + " </td></tr>");
								out.println("<tr><td>Heater</td><td>ON : " + heater_on + " </td><td>OFF : " + heater_off + " </td></tr>");
								out.println("<tr><td>Cooler</td><td>ON : " + cooler_on + " </td><td>OFF : " + cooler_off + " </td></tr>");
								out.println("<tr><td>Water</td><td>ON : " + water_on + " </td><td>OFF : " + water_off + " </td></tr>");
								out.println("<tr><td>Feed</td><td>Time 1 : " + feed1 + " </td><td>Time 2 : " + feed2 + " </td></tr>");
								out.println("</table><br>");
							}
							
							
						}catch(Exception e){
							e.printStackTrace();
						}finally{
							try{
								if(resultSet != null) resultSet.close();
								if(statement != null) statement.close();
								if(connection != null) connection.close();
							}catch(Exception e2){
								e2.printStackTrace();
							}
						}
					%>
				</section>
			</div>
		</div>
		
		<div align="center" style="padding: 50px;">
			<div class="list" align="center" style="width:100%; background-color:#3E606F;">
				<p align="left" style="padding: 2px;"><b>수조내 센싱 정보</b></p>
				
				<section>
				<div class="listleft" style="width:100%; padding: 5px;" align="left"><!-- background-color:blue; -->
					<%
						try{
							Class.forName(driver);
							connection = DriverManager.getConnection(url, uid, upass);
							statement = connection.createStatement();
							
							String query = "select * from data";
							resultSet = statement.executeQuery(query);
							
							out.println("<table>");
							out.println("<tr><th>일시</th><th>온도</th><th>수위</th></tr>");
							
							while(resultSet.next()){
								String datetime = resultSet.getString("datetime");
								String temp = resultSet.getString("temp");
								String water = resultSet.getString("water");
								
								out.println("<tr><td>" + datetime + "</td><td>" + temp + "</td><td>" + water + "</td></tr>");
								
							}
							out.println("</table><br>");
							
						}catch(Exception e){
							e.printStackTrace();
						}finally{
							try{
								if(resultSet != null) resultSet.close();
								if(statement != null) statement.close();
								if(connection != null) connection.close();
							}catch(Exception e2){
								e2.printStackTrace();
							}
						}
					%>
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
