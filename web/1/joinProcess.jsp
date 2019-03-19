<!-- 회원가입 실제 처리 페이지 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	
	String id=request.getParameter("id");
	String pass=request.getParameter("pass");
	String contact=request.getParameter("contact");
	String email=request.getParameter("email");
	
/* 	System.out.println(id);
	System.out.println(pass);
	System.out.println(contact);
	System.out.println(email); */
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	
	
	try {
  		Context init = new InitialContext();
  		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/jhp");  // 서버.xml 네임 뒤쪽 에 맞춰야할 부분
  		conn = ds.getConnection();
  		
  		pstmt=conn.prepareStatement("INSERT INTO member VALUES (?,?,?,?)");
  		pstmt.setString(1,id);
  		pstmt.setString(2,pass);
  		pstmt.setString(3,contact);
  		pstmt.setString(4,email);
  		int result=pstmt.executeUpdate();
  		
  		
  		if(result!=0){  			
  			out.println("<script>");
  		  	out.println("location.href='loginForm.jsp'");
  		  	out.println("</script>");
  		}else{
  			out.println("<script>");
  	  		out.println("location.href='joinForm.jsp'");
  	  		out.println("</script>");
  		}
	}catch(Exception e){
		e.printStackTrace();
 	}finally{
 		try{
 			pstmt.close();
 			conn.close();
 		}
 		catch(Exception e){
 			e.printStackTrace();
 		}
 	}
%>
