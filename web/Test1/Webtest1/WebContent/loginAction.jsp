<%@ page language="java" contentType="text/html; charset=UTF-8"%>
    <%@ page import="dao.MemberDAO" %>
    <%@ page import="java.io.PrintWriter" %>
     <% request.setCharacterEncoding("UTF-8"); %>
    <jsp:useBean id="user" class="dto.MemberDTO" scope="page"/>
    <jsp:setProperty name="user" property="id" />
    <jsp:setProperty name="user" property="pass" />
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<%
	String Id= null;
	if(session.getAttribute("id") != null){
		Id = (String) session.getAttribute("id");
	} if (Id != null){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('이미 로그인이 되어있습니다.')");
		script.println("location.href = 'index_login.jsp'");
		script.println("</script>");
	}
	MemberDAO dao = new MemberDAO();
	
	int result = dao.login(user.getId(),user.getPass());
	if (result == 1){
		session.setAttribute("id",user.getId());
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("location.href = 'index_login.jsp'");
		script.println("</script>");
	}
	else if (result == 0 ){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('비밀번호가 틀렸습니다')");
		script.println("history.back()");
		script.println("</script>");
	}
	else if (result == -1 ){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('존재하지 않는 아이디 입니다.')");
		script.println("history.back()");
		script.println("</script>");
	}
	else if (result == -2 ){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('오류 발생.')");
		script.println("history.back()");
		script.println("</script>");
	}

%>



</body>
</html>
