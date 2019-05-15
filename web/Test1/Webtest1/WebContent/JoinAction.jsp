<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
     <%@ page import="dao.MemberDAO" %>
    <%@ page import="java.io.PrintWriter" %>
     <% request.setCharcterEncoding("UTF-8"); %>
    <jsp:useBean id="user" class="dto.MemberDTO" scope="page"/>
    <jsp:setProperty name="user" property="Id" />
    <jsp:setProperty name="user" property="Pass" />
    <jsp:setProperty name="user" property="Name" />
    <jsp:setProperty name="user" property="Email" />
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

	if(user.getid() == null || user.getpass() == null 
	|| user.getName() == null || user.getEmail() == null){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('입력이 안 된 사항이 있습니다.')");
		script.println("history.back()");
		script.println("</script>");
	}else {
		MemberDAO dao = new MemberDAO();
	int result = dao.join(user); // 자바 jsp:bean 쪽 user 네임 따오는거임 
	if (result == 1){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('이미 존재하는 아이디 입니다.')");
		script.println("history.back()");
		script.println("</script>");
	}
	else if (result == 0 ){ // 가입 성공
		session.setAttribute("Id",user.getId());
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("location.href ='loginFrom.jsp'");
		script.println("</script>");
	}
}

	


%>

</body>
</html>
