<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
  <style type="text/css">
	a.no-uline {text-decoration:none}
  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
        
        
<style>

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
<html>
<body>


<div class="container">
			<a href="index_login.jsp" class="no-uline" ><h1>UHMS<small> Underwater Homeostatic Maintenance System </small></h1></a>
			<h3>수중생태 항상성 유지 시스템</h3>
</div>

<% String id =(String)session.getAttribute("id");
%>
<%=id %>님 로그인 하셨습니다. <br> <br>

<a href="index_login.jsp" > 서버 접속 </a> &nbsp;&nbsp;&nbsp;
<a href="index.html"> 나가기 </a> <br>
<br>
	
<% if(id.equals("aaa")){
%>
관리자님 로그인 하신것을 환영합니다 <br><br>
<%}%>

<br></br>


<ol>
<h2 id="C1"> </h2>

   <li><a href="#" class="no-uline"> 테스트1</a></li>
  
  <li><a href="#" class="no-uline"> 테스트2</a></li>
  
  <li><a href="#" class="no-uline"> 테스트3</a>
</ol> 

<style>


.cities {
  background-color: black;
  color: white;
  margin: 1px;
  padding: 1px;
} 



table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
<body>

<br></br>


<table>
  <tr>
    <th>Company</th>
    <th>Contact</th>
    <th>Country</th>
  </tr>
  <tr>
    <td>w3schools</td>
    <td>w3schools1</td>
    <td>w3schools2</td>
  </tr>
    <tr>
    <td>w3schools</td>
    <td>w3schools1</td>
    <td>w3schools2</td>
  </tr>
    <tr>
    <td>w3schools</td>
    <td>w3schools1</td>
    <td><a href="https://www.w3schools.com/html/tryit.asp?filename=tryhtml_attributes_img_src"></a></td>
  </tr>
<h2 id="C2"> </h2>

</body>
</html>
