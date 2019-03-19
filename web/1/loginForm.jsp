<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">


</head>
<body>
<form action="loginProcess.jsp" method="post">

	<table>
		<tr>
			<td colspan="2"  class = "td_title"> 
			JHP 로그인 화면 </td>
		</tr>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="pass"></td>
		</tr>
		<td colspan="2">
			<input type="submit" value="로그인"> 
			<input type="button" onclick="location.href='joinForm.jsp'" value="회원가입" >	
			<input type="button" value="돌아가기" onclick="location.href='index.html'">
		</td>

		<!-- <a href = "#"> 적을내용 </a>  이렇게 링크 형식 or 버튼형식으로 바꿀 예정. ( 틀 짜놓고 어느 방향으로 갈지 수정 준비 중 ) -->
		
	</table>

</form>



</body>
</html>