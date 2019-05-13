<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http=equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content ="width=devicd-width", initial-scale="1">
<link rel="stylesheet" href="css/bootstrap.css">
<title> Q&A </title>
</head>
<body>

<nav Class="navbar navbar-default">
	<div Class=navbar-header">
		<button type="button" class="navbar-toggle collapsed"
		data-toggle ="colapse" data-target="#bs-example-navbar-collapse-1"
		aria-expanded="false">
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="index_login">제목 바꿔줘야 할곳 </a>  <% // 바꿔줘야 할곳 %>
	</div>
	</div>
	</nav>
	<div class="container">
	<div class="col-lg-4"></div>
	<div class="col-lg-4">
		<div class="jumbotron" style="paddiong-top: 20px;">
			<form method="post" action="loginAction.jsp">
				<h3 style="text-align: center;">로그인화면</h3>
				<input type="text" class="form-control" placeholder="아이디" name ="Id" maxlegth="20"">
			</form>
			<input type="submit" class="btn btn-primory form-control" value="로그인">
			
	</div>
	</div>
	<script src ="https://code.jquery.com/jquery-3.1.1min.js"></script>
	<script src ="js/bootstrap.js"></script>
	
</body>
</html>