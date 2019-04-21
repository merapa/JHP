<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%!
		
		Connection connection;
		Statement statement;
		ResultSet resultSet;
		
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/JHP";
		String uid = "jhp";
		String upass = "01230123";
		

	%>
	
<%
	request.setCharacterEncoding("UTF-8");
	String id=request.getParameter("id");
	String pass=request.getParameter("pass");
	String name=request.getParameter("name");
	String contact=request.getParameter("contact");
	String email=request.getParameter("email");
	String question=request.getParameter("question");
	String answer=request.getParameter("answer");
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	
	try {
  		Class.forName(driver);
		connection = DriverManager.getConnection(url, uid, upass);
		statement = connection.createStatement();
							
		System.out.println("1");
  		
		pstmt=conn.prepareStatement("INSERT INTO user VALUES (?,?,?,?,?,?,?)");
  		pstmt.setString(1,id);
  		pstmt.setString(2,pass);
  		pstmt.setString(3,name);
  		pstmt.setString(4,email);
		pstmt.setString(5,contact);
		pstmt.setString(6,question);
		pstmt.setString(7,answer);
  		int result=pstmt.executeUpdate();
		System.out.println("2");
  		
  		if(result!=0){  			
  			out.println("<script>");
  		  	out.println("location.href='loginForm.jsp'");
  		  	out.println("</script>");
			System.out.println("3");
  		}else{
			System.out.println("4");
  			out.println("<script>");
  	  		out.println("location.href='joinForm.jsp'");
  	  		out.println("</script>");	
  		}
		System.out.println("5");
			out.println("<script>");
			out.println("location.href='joinForm.jsp'");
			out.println("</script>");
		
	}catch(Exception e){
		e.printStackTrace();
		System.out.println("6");
 	}finally{
 		try{
			System.out.println("7");
 			pstmt.close();
 			conn.close();
 		}
 		catch(Exception e){
			System.out.println("8");
 			e.printStackTrace();
 		}
 	}
%>
