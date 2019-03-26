<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
    
    <%@ page import="java.sql.*"%>
	<%@ page import="javax.sql.*" %>
	<%@ page import="javax.naming.*" %>

<% 
	request.setCharacterEncoding("UTF-8");
	String id=request.getParameter("id");
	String pass=request.getParameter("pass");
	String name=request.getParameter("name");
	String cotact=request.getParameter("contact");
	String email=request.getParameter("email");

try
    {	
	Context init = new InitialContext();
	DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/jhp");

	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sql = "SELECT * FROM MEMBER WHERE ID = ?";
	 
    pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,id);
	rs = pstmt.executeQuery();
%>   
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>수정 화면</title>
<script type="text/javascript">
    function Delete_Action() {
        document.update_Form.action="Delete_Action.jsp";
        document.update_Form.submit();
 }
</script>
</head>
<body>
    <%if(id == null) { 
        response.sendRedirect("Update_Member.jsp");
    }
    else {
    %> 
    <form name="Update_Member_Action" action="Update_Member_Action.jsp">
        <table border="1">
            <%while(rs.next()) { %>
            <tr>
                <td>아이디</td>
                 <td><%=rs.getString("id") %></td>
            </tr>
            <tr>
                <td>패스워드</td>
                <td><input type="password" name="pass" value="<%=rs.getString("pass")%>"></td>
            </tr>
            <tr>
                <td>이름</td>
                <td><input type="text" name="name" value="<%=rs.getString("name")%>"></td>
            </tr>
            <tr>
                <td>이메일</td>
                <td><input type="text" name="email" value="<%=rs.getString("email")%>"></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="변경">
                    <input type="button" value="회원 탈퇴" onclick="location.href='Delete_Member.jsp'">
                    <input type="button" value="돌아가기" onclick="location.href='Boardinfo.jsp'"></td>
            </tr>
            <%} %>
        </table>
    </form>
 <%} %>
 <%}catch(Exception e) {}%>
</body>
</html>