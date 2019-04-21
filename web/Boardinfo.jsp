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
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
			@media screen and (max-width: 500px) {
				span.psw {
					display: block;
					float: none;
				}
				.form {
					width: 100%;
				}
			}
			form {
				border: 10px solid #12252F;
				background-color: #12252E;
				width: 65%;
				display: block;
				margin-left: auto;
				margin-right: auto;
				padding-left: 20px;
				padding-right: 20px;
				padding-bottom: 50px;
				
			}

			input[type=text], input[type=password] {
				width: 100%;
				padding: 12px 20px;
				margin: 8px 0;
				display: inline-block;
				border: 1px solid #ccc;
				box-sizing: border-box;
			  
			  
			}

			button {
				background-color: #4CAF50;
				color: white;
				padding: 20px 20px;
				margin: 20px 0;
				margin-right: 3px;
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

			.joinbtn {
				width: auto;
				padding: 10px 18px;
				background-color: #f44336;
			}

			.imgcontainer {
				text-align: center;
				margin: 24px 0 12px 0;
			}

			img.avatar {
				width: 35%;
				border-radius: 50%;
			}

			.login_container {
				padding: 20px;
				width: 100%;
			}

			span.psw {
				float: right;
				padding-top: 16px;
			}

			/* Change styles for span and join button on extra small screens */
			@media screen and (max-width: 500px) {
				span.psw {
					display: block;
					float: none;
				}
				.joinbtn {
					width: 100%;
				}
			}
				
				
				
		</style>
	</head>
	<body style="background-color:#193441; overflow: auto;"><!-- overflow: auto;= hide scrollbar -->

		<!-- container start-->
		<div class="container">
			<img src="img/logo_white.png" style="width:140px; padding:20px;" align="right"><br><br>
			<a href="index_login.jsp" class="no-uline" ><h1>UHMS<small> Underwater Homeostatic Maintenance System </small></h1></a>
			<h3>수중생태 항상성 유지 시스템</h3>
			
			<!-- board form start-->
			<form action="loginProcess.jsp" class="form" method="post">
				<div class="imgcontainer">
					<h3 class="a" align="left">My Page</h3>
					<img src="img/avatar.png" alt="Avatar" class="avatar">
				</div>

				<div>
					<h4 align="left"><%=id%> 님 정보.</h4>	
					<button type="button" class="mypagebtn" onclick="location.href='Update_Member.jsp'" style="float: right;">정보 수정</button>
					<button type="button" class="mypagebtn" onclick="location.href='javascript:history.back();'" style="float: right;">돌아가기</button>
					<button type="button" class="mypagebtn" onclick="location.href='loginForm.jsp'" style="float: right;">로그아웃</button>
					
					<br><br><br><br>
					<%
						try{
							Class.forName(driver);
							connection = DriverManager.getConnection(url, uid, upass);
							statement = connection.createStatement();
							
							String query = "select * from user where id='"+id+"'";
							resultSet = statement.executeQuery(query);
							
							while(resultSet.next()){
								Integer dno = resultSet.getInt("no");
								String did = resultSet.getString("id");
								String dpass = resultSet.getString("pass");
								String dname = resultSet.getString("name");
								String demail = resultSet.getString("email");
								String dcontact = resultSet.getString("contact");
								String dquestion = resultSet.getString("question");
								String danswer = resultSet.getString("answer");
								
								out.println("<h4 align=\"left\">ID : " + did + "</h4>");
								out.println("<h4 align=\"left\">Name : " + dname + "</h4>");
								out.println("<h4 align=\"left\">Email : " + demail + "</h4>");
								out.println("<h4 align=\"left\">Contact : " + dcontact + "</h4>");
								out.println("<h4 align=\"left\">Question : " + dquestion + "</h4>");
								out.println("<h4 align=\"left\">Answer : " + danswer + "</h4>");
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
				</div>
			</form>
			<!-- board form end-->
		</div>
		<!-- container end-->
			
		
	</body>
</html>
