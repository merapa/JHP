<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="java.sql.*"%>
	<%@ page import="javax.sql.*" %>
	<%@ page import="javax.naming.*" %>
<%
    //¼¼¼ÇÁ¤º¸ °¡Á®¿À±â
    
    String id = (String) session.getAttribute("id");
try {
	Context init = new InitialContext();
	DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/jhp");
    Connection conn = ds.getConnection(); 
    PreparedStatement pstmt = null;
    String sql = "DELETE FROM member WHERE id = ?";
 
    pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, id);
    int rs = pstmt.executeUpdate();
 
    if(rs > 0) {
        out.println("<script language='javascript'>");
        out.println("alert('Å»Åð ¼º°ø')");
        out.println("location.href='loginform.jsp'");
        out.println("</script>");
    }
    else {
        out.println("<script language='javascript'>");
        out.println("alert('Å»Åð ºÒ°¡´É')");
        out.println("location.href='Update_Member.jsp'");
        out.println("</script>");
    }
%>
<%}catch(Exception e) {}%>