<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.sql.*"%>
	<%@ page import="javax.sql.*" %>
	<%@ page import="javax.naming.*" %>



<% 
	request.setCharacterEncoding("UTF-8");
	String id =(String)session.getAttribute("id");
	String pass=request.getParameter("pass");
%>
    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
 	<form action="index_login.jsp" method="post">
		<h4 align="right"><%=id%> 님 정보.</h4>				
		<input type="button" onclick="location.href='index_login.jsp'" value="돌아가기">
	</form>
	
	
	
 	
</body>
</html>
