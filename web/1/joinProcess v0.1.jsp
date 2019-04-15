<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.Member"%>
    <%@ page import="java.sql.*"%>
	<%@ page import="javax.sql.*" %>
	<%@ page import="javax.naming.*" %>
	<%@ page import="dao.*" %>
	<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String contact = request.getParameter("contact");
	String question = request.getParameter("question");
	String answer = request.getParameter("answer");
	%>  
   
   <jsp:useBean id="dto" class="dao.MemberDTO"/>
   <jsp:setProperty property="*" name="dto"/>


<%	
MemberDAO dao = new MemberDAO();
int result = dao.insertMember();
if(result > 0){
%>
	<script type="text/javascript">
		alert("회원 가입 성공")
		location.href="loginForm.jsp";
	</script>
		<%
		}else{
		%>
		<script type="text/javascript">
			alert("회원 가입 실패")
  	  		location.href="JoinForm.jsp";
 		</script>
 		<%
 		}
 		%>
	
	
