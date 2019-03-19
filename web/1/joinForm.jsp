<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style type="text/css" >

	a.no-uline {text-decoration:none}

	table{
		margin : auto;
		width : 400px;
		border : 1px solid gray;
		text-align: center;
	}
	.td_title{
		font-weight: bold;
		font-size: x-large;
	}
	
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

<!-- <Script type="text/javaScript">
function check_onclick(){
	theForm=document.frm1;

if(theForm.id.value==""||theForm.pass.Value==""||theForm.name.Value==""||theForm.age.Value==""||theForm.email.Value==""){
	alert("빈공간 을 확인해주세요");
}else{
	alert("회원 가입 성공")
	}
}
</Script> -->
<body>


<form action="joinProcess.jsp" method="post">
<table border=1>
	<tr>
		<td colspan="2" class = "td_title">
			회원가입 페이지
		</td>
	</tr>
	<tr>
		<td><label for = "id">아이디 : </label></td>
		<td><input type="text" name="id" id = "id"/>

	</tr>
	<tr>
		<td><label for = "pass">비밀번호 : </label></td>
		<td><input type="password" name="pass" id = "pass" />
	</tr>
	<tr>
		<td><label for = "contact">전화 번호 : </label></td>
		<td><input type="text" name="contact" id = "contact" />
		</td>
	</tr>
	<tr>
		<td><label for = "email">이메일 주소 : </label></td>
		<td><input type="text" name="email" id = "email"/>
	</tr>
	<tr>
	<td colspan=2> 
		<input type="submit" value="회원 가입" >&nbsp;
		<input type="button" value="다시 작성"  onclick="location.href='joinForm.jsp'">&nbsp;
		<input type="button" value="돌아가기"  onclick="location.href='loginForm.jsp'">&nbsp;
	</td>
	</tr>
</table>
</form>
</head>
<body>


</body>
</html>
