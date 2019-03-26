<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    <%@ page import="java.sql.*"%>
	<%@ page import="javax.sql.*" %>
	<%@ page import="javax.naming.*" %>
<% 
	request.setCharacterEncoding("UTF-8");
	String id =(String)session.getAttribute("id");
	String pass=request.getParameter("pass");
	String name=request.getParameter("name");
	String contact=request.getParameter("contact");
	String email=request.getParameter("email");
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	/* ResultSet rs=null; */
	pstmt.setString(1,id);
	
%>   
<%
try {
	Context init = new InitialContext();
	DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/jhp");
	conn = ds.getConnection();
	
	String sql = "UPDATE MEMBER SET PW = ?, NAME = ?, EMAIL = ? WHERE ID = ?";
    pstmt = conn.prepareStatement(sql);
    
	pstmt.setString(1,pass);
	pstmt.setString(2,name);
	pstmt.setString(3,email);
	pstmt.setString(4,contact);
	pstmt.setString(5,id);
	
	int rs = pstmt.executeUpdate();
%>

<%
 if(rs > 0) {
        out.println("<script language='javascript'>");
        out.println("alert('정보수정 성공')");
        out.println("location.href='Boardinfo.jsp'");
        out.println("</script>");
    }
    else { 
        out.println("<script language='javascript'>");
        out.println("alert('정보수정 실패')");
        out.println("location.href='Update_Member.jsp'");
        out.println("</script>");
    }
%>
<%}catch(Exception e) {}%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>