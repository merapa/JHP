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
		script.println("alert('�̹� �α����� �Ǿ��ֽ��ϴ�.')");
		script.println("location.href = 'index_login'");
		script.println("</script>");
	}

	if(user.getid() == null || user.getpass() == null 
	|| user.getName() == null || user.getEmail() == null){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('�Է��� �� �� ������ �ֽ��ϴ�.')");
		script.println("history.back()");
		script.println("</script>");
	}else {
		
	}

	MemberDAO dao = new MemberDAO();
	int result = dao.join(user);
	if (result == 1){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('�̹� �����ϴ� ���̵� �Դϴ�.')");
		script.println("history.back()");
		script.println("</script>");
	}
	else if (result == 0 ){ // ���� ����
		session.setAttribute("Id",user.getId());
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("location.href ='loginFrom.jsp'");
		script.println("</script>");
	}


%>

</body>
</html>