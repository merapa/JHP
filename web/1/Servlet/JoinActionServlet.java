package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.MemberDTO;
import util.DatabaseUtil;
import dao.MemberDAO;

@WebServlet("/joinAction")

@SuppressWarnings("serial")
public class JoinActionServlet extends HttpServlet
{
	MemberDTO dto = new MemberDTO();	
	MemberDAO dao = new MemberDAO();
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
		response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        
        request.setCharacterEncoding("UTF-8");
        
        System.out.println("1");

        dto.setId(request.getParameter("userId"));
        dto.setPass(request.getParameter("userPass"));
        dto.setName(request.getParameter("userName"));
        dto.setContact(request.getParameter("userContact"));
        dto.setEmail(request.getParameter("userEmail"));
        dto.setQuestion(request.getParameter("userQuestion"));
        dto.setAnswer(request.getParameter("userAnswer"));

		HttpSession session  = request.getSession();	
		
        if(session.getAttribute("userId") != null ){
            dto.setId ((String) session.getAttribute("userId"));

        }
        
        System.out.println(dto.getId());
        System.out.println(dto.getPass());
        System.out.println(dto.getName());
        System.out.println(dto.getContact());
        System.out.println(dto.getEmail());
        System.out.println(dto.getQuestion());
        System.out.println(dto.getAnswer());
        
        if(dto.getId() != null){
            PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("alert('성공 ')");
            script.println("location.href = 'loginForm.jsp'");
            script.println("</script>");  
        }

	    if (dto.getId() == null || dto.getPass() == null || dto.getName() == null || dto.getEmail() == null) {
	    	PrintWriter script = response.getWriter();
			script.println("<script>");
			script.print("alert('입력 안 된 사항이 있습니다');");
			script.print("history.back();");
			script.print("<script>"); 
			System.out.println("2");
		} else{
			int result = dao.join(dto);
			if(result == -1) {
				PrintWriter script = response.getWriter();
				DatabaseUtil.getConnection();
				script.println("<script>");
				script.print("alert('이미 존재하는 아이디 입니다.');");
				script.print("history.back();");
				script.print("<script>");
				System.out.println("3");
			}else {
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.print("location.href='loginForm.jsp'");
				script.print("<script>");
				script.close();
				System.out.println("4");
			}
	    }	
    }

}
