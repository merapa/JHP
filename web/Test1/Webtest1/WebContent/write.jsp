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
		<a class="navbar-brand" href="index_login">���� �ٲ���� �Ұ� </a>  <% // �ٲ���� �Ұ� %>
	</div>
	</div>
	</nav>
	<div class="container">
	<div class="col-lg-4"></div>
	<div class="col-lg-4">
		<div class="jumbotron" style="paddiong-top: 20px;">
			<form method="post" action="loginAction.jsp">
				<h3 style="text-align: center;">�α���ȭ��</h3>
				<input type="text" class="form-control" placeholder="���̵�" name ="Id" maxlegth="20"">
			</form>
			<input type="submit" class="btn btn-primory form-control" value="�α���">
			
	</div>
	</div>
	<script src ="https://code.jquery.com/jquery-3.1.1min.js"></script>
	<script src ="js/bootstrap.js"></script>
	
</body>
</html>