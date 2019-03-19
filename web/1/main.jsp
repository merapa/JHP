<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<style type="text/css">
	a.no-uline {text-decoration:none}
</style>

<html>
<body>

<div class="cities">
  <h2>HTML List1</h2>
  <p> test is jiwon.</p>
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
<a href="member_list.jsp">회원 목록 보기</a><br>
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
