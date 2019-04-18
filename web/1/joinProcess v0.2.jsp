<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.Member"%>
    <%@ page import="java.sql.*"%>
	<%@ page import="javax.sql.*" %>
	<%@ page import="javax.naming.*" %>
	<%@ page import="dao.*" %>
	<%@ page import="model.*" %>
	<%@ page import="java.io.PrintWriter" %>
	
	<jsp:useBean id="user" class="dto.MemberDTO" scope="page"/>
	<jsp:setProperty name="user" property="id"/>
	<jsp:setProperty name="user" property="pass"/>
	<jsp:setProperty name="user" property="name"/>
	<jsp:setProperty name="user" property="contact"/>
	<jsp:setProperty name="user" property="email"/>
	<jsp:setProperty name="user" property="question"/>
	<jsp:setProperty name="user" property="answer"/>

	<%request.setCharacterEncoding("UTF-8");	
	
	if(user.getId() == null || user.getPass() == null || user.getName() == null || user.getEmail() == null ){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.print("alert('입력 안 된 사항이 있습니다');");
		script.print("history.back();");
		script.print("<script>");
		script.close();
		return;
	}
	MemberDAO dao = new MemberDAO();
	int result = dao.join(user);
	if(result == 1){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.print("alert('회원 가입 성공');");
		script.print("location.href='loginForm.jsp'");
		script.print("<script>");
		script.close();
		return;
		
	}
	
	
	%>  




	
	
