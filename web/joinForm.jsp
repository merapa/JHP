<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원관리 시스템 회원가입 페이지</title>

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


<form name="joinform" action="joinProcess.jsp" method="post">
<table border=1>
	<tr>
		<td colspan="2" class = "td_title">
			회원가입 페이지
		</td>
	</tr>
	<tr>
		<td><label for = "id">아이디 : </label></td>
		<td><input type="text" name="id" id = "id"/></td>

	</tr>
	<tr>
		<td><label for = "pass">비밀번호 : </label></td>
		<td><input type="password" name="pass" id = "pass"/></td>
	</tr>

	<tr>
		<td><label for = "name">이름 : </label></td>
		<td><input type="text" name="name" id = "name"/></td>
	</tr>
	<tr>
		<td><label for = "age">나이 : </label></td>
		<td><input type="text" name="age" id = "age"/>
		</td>
	</tr>
	<tr>
		<td><label for = "gender1"></label>성별 : </td>
		<td>
			<input type="radio" name="gender" value="남" checked id = "gender1"/>남자
			<input type="radio" name="gender" value="여" id = "gender2"/>여자
		</td>
	</tr>
	<tr>
		<td><label for = "email">이메일 주소 : </label></td>
		<td><input type="text" name="email" id = "email"/></td>
	</tr>
	<tr>
	<td colspan=2> 
		<input type="button" value="회원 가입"  onclick="location.href='joinProcess.jsp'"> &nbsp;
		<input type="button" value="다시 작성"  onclick="location.href='joinForm.jsp'"> &nbsp;
		<input type="button" value="돌아가기"  onclick="location.href='loginForm.jsp'"> &nbsp;
	</td>
	</tr>
</table>
</form>
</body>
</html>
