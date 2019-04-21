<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head><title>아이디 찾기</title></head>

<%
	  request.setCharacterEncoding("UTF-8");
      String name = request.getParameter("name");
      String email = request.getParameter("email");
      String id = request.getParameter("id");
 
   	  Connection conn=null;
  	  PreparedStatement pstmt=null;
  	  ResultSet rs=null;
  	  
      try
      {
    	Context init = new InitialContext();
    	DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/JHP");
    	conn = ds.getConnection();
  		pstmt=conn.prepareStatement("select * from user where name=?");
  		pstmt.setString(1,name);
    	rs=pstmt.executeQuery();
    	
%>

<body>
<center>
<form><%
            if(name != null){%>
                  <%= name %>님의 아이디는 <br><%=id%><br> 입니다.<p>
<%}else{%>
                  이름 또는 이메일이 틀렸습니다.<p>
                  <input type="button" value="돌아가기" onclick=
                	  "location.href='ForgetCheck.html'">
<%}%>
</form>
</center>
		<table border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td height="40" style="padding:0 13px 0 0">
					<div class="bts"><a href="javascript:self.close();"><span style="width:50px">닫기</span></a></div>
				</td>
			</tr>
		</table>
</body>
<%}catch(Exception e) {}%>
</html>
