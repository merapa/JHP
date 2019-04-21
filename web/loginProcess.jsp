<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.sql.*"%>
	<%@ page import="javax.sql.*" %>
	<%@ page import="javax.naming.*"%>
    
<% 
	request.setCharacterEncoding("UTF-8");
	String id=request.getParameter("id");
	String pass=request.getParameter("pass");
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;

	try {
  		Context init = new InitialContext();
  		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/jhp");
  		conn = ds.getConnection();
		pstmt=conn.prepareStatement("select * from user where id=?");
		pstmt.setString(1,id);
  		rs=pstmt.executeQuery();
  		System.out.println("1");
		
  		if(rs.next()){
  			if(pass.equals(rs.getString("pass"))){
  			//회원 로그인 성공-세션
  				System.out.println("로그인");
  				session.setAttribute("id",id);
  				out.println("<script>");
  				out.println("alert('로그인 성공')");
  				out.println("location.href='index_login.jsp'");
  				out.println("</script>");
  			}else{
  				//회원 로그인 실패
  				System.out.println("실패");
  				out.println("<script>");
  				out.println("alert('아이디 및 비밀번호가 틀렸습니다 ')");
  				out.println("</script>");
  			}
  		}
  		// 아이디 비밀번호 틀렸을 경우 바로 오는곳
			out.println("<script>");
			out.println("location.href='loginForm.jsp'");
			out.println("</script>");
  		
		}catch(Exception e){
  			e.printStackTrace();
  		}finally{
  			try{
  			conn.close();
  			pstmt.close();
  			rs.close();
  		}
  		catch(Exception e){
  			e.printStackTrace();
  		}
	}
			
%>
