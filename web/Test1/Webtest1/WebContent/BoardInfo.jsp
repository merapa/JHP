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
		<a class="navbar-brand" href="index_login"> �Խ��� �� ���� Ȯ�� ������ ȭ�� </a>  <% // �ٲ���� �Ұ� %>
	</div>
	</div>
	</nav>
	<div class="container">
	<div class="row">
		<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
			<thead>
				<tr>
					<th style="background-color: #eeeeee; text-align: center;">��ȣ</th>
					<th style="background-color: #eeeeee; text-align: center;">����</th>
					<th style="background-color: #eeeeee; text-align: center;">�ۼ���</th>
					<th style="background-color: #eeeeee; text-align: center;">�ۼ���</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>��ȣ</td>
					<td>����</td>
					<td>�ۼ���</td>
					<td>�ۼ���</td>
			</tbody>
		</table>
		<a href="write.jsp" class="btn btn-primary pull-right">�۾���</a>
	</div>
	</div>
	<script src ="https://code.jquery.com/jquery-3.1.1min.js"></script>
	<script src ="js/bootstrap.js"></script>
	
</body>
</html>