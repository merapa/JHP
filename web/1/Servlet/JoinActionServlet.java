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
import dao.MemberDAO;

@WebServlet(
        name = "JoinActionServlet",
        urlPatterns = {"/joinAction"},
        loadOnStartup = 1
)

@SuppressWarnings("serial")
public class JoinActionServlet extends HttpServlet
{
	MemberDTO dto = new MemberDTO();	
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
		response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        


        dto.setId(request.getParameter("userID"));
        dto.setPass(request.getParameter("userPass"));
        dto.setName(request.getParameter("userName"));
        dto.setContact(request.getParameter("userContact"));
        dto.setEmail(request.getParameter("userEmail"));
/*        dto.setQuestion(request.getParameter("userQuestion"));
        dto.setAnswer(request.getParameter("userAnswer"));*/

		HttpSession session  = request.getSession();
		
		
        String userID = null;
        
        if(session.getAttribute("userID") != null ){
            userID = (String) session.getAttribute("userID");
        }
        
        if(userID != null){
            PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("alert('이미 로그인 되어있습니다.')");
            script.println("location.href = 'main.jsp'");
            script.println("</script>");    
        }

	    if (dto.getId() == null || dto.getPass() == null || dto.getName() == null || dto.getEmail() == null) {
            PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("alert('입력이 안 된 사항이 있습니다.')");
            script.println("history.back()");
            script.println("</script>");
	    } else {
            MemberDAO dao = new MemberDAO(); //인스턴스생성
            int result = dao.join(dto);                

            if(result == -1){ // 아이디가 기본키기. 중복되면 오류.
                PrintWriter script = response.getWriter();
                script.println("<script>");
                script.println("alert('이미 존재하는 아이디 입니다.')");
                script.println("history.back()");
                script.println("</script>");
            }
            //가입성공
            else {
                PrintWriter script = response.getWriter();
                script.println("<script>");
                script.println("alert('회원가입 감사합니다.')");
                script.println("location.href = 'main.jsp'");
                script.println("</script>");
            }
	    }	
    }

}
