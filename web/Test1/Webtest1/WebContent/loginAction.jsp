<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="dao.MemberDAO" %>
    <%@ page import="java.io.PrintWriter" %>
  <% request.setCharcterEncoding("UTF-8"); %>
    <jsp:useBean id="user" class="dto.MemberDTO" scope="page"/>
    <jsp:setProperty name="user" property="Id" />
    <jsp:setProperty name="user" property="Pass" />
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String Id= null;
	if(session.getAttribute("Id") != null){
		Id = (String) session.getAttribute("Id");
	} if (Id != null){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('이미 로그인이 되어있습니다.')");
		script.println("location.href = 'index_login'");
		script.println("</script>");
	}
	MemberDAO dao = new MemberDAO();
	int result = dao.login(user.getId(),user.getPass());
	if (result == 1){
		session.setAttribute("Id",user.getId());
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("location.href = 'index_login'");
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