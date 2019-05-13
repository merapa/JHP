package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dto.ControlDTO;
import util.DatabaseUtil;
import dao.ControlDAO;

@WebServlet("/controlAction")

@SuppressWarnings("serial")
public class ControlActionServlet extends HttpServlet
{
	ControlDTO dto = new ControlDTO();	
	ControlDAO dao = new ControlDAO();
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
		response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        
        request.setCharacterEncoding("UTF-8");
        
        System.out.println("1");

        dto.setLight_on(request.getParameter("light_on"));
        dto.setLight_off(request.getParameter("light_off"));
        dto.setHeater_on(request.getParameter("heater_on"));
        dto.setHeater_off(request.getParameter("heater_off"));
        dto.setCooler_on(request.getParameter("cooler_on"));
        dto.setCooler_off(request.getParameter("cooler_off"));
        dto.setWater_on(request.getParameter("water_on"));
        dto.setWater_off(request.getParameter("water_off"));
        dto.setFeed1(request.getParameter("feed1"));
        dto.setFeed2(request.getParameter("feed2"));
        
        
      

		HttpSession session  = request.getSession();	
		
 
        
        System.out.println(dto.getLight_on());
        System.out.println(dto.getLight_off());
        System.out.println(dto.getHeater_on());
        System.out.println(dto.getHeater_off());
        System.out.println(dto.getCooler_on());
        System.out.println(dto.getCooler_off());
        System.out.println(dto.getWater_on());
        System.out.println(dto.getWater_off());
        System.out.println(dto.getFeed1());
        System.out.println(dto.getFeed2());
        
// -----------------------------------------------------------------------------
        // 조명
        
        if(dto.getLight_on() != null){
            PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("alert('적용 완료')");
            script.println("location.href = 'light.jsp'");
            script.println("</script>");  
        }else if(dto.getLight_off() != null){
        	PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("alert('적용 완료')");
            script.println("location.href = 'light.jsp'");
            script.println("</script>"); 
        }else{
			int result = dao.light(dto);
			if(result == -1) {
				PrintWriter script = response.getWriter();
				DatabaseUtil.getConnection();
				script.println("<script>");
				script.print("alert(' X ');");
				script.print("history.back();");
				script.print("<script>");
			}
 // ---------------------------------------------------------------------------------------------------
        // 히터
        
        if(dto.getHeater_on() != null){
            PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("alert('적용 완료')");
            script.println("location.href = 'heater.jsp'");
            script.println("</script>");  
        }else if(dto.getHeater_off() != null){
        	PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("alert('적용 완료')");
            script.println("location.href = 'heater.jsp'");
            script.println("</script>"); 
        }
        
        // ---------------------------------------------------------------------------------------------------
        // 쿨러
        
        if(dto.getCooler_on() != null){
            PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("alert('적용 완료')");
            script.println("location.href = 'cooler.jsp'");
            script.println("</script>");  
        }else if(dto.getCooler_off() != null){
        	PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("alert('적용 완료')");
            script.println("location.href = 'cooler.jsp'");
            script.println("</script>"); 
        }
        // ---------------------------------------------------------------------------------------------------
        // 워터
        
        if(dto.getWater_on() != null){
            PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("alert('적용 완료')");
            script.println("location.href = 'water.jsp'");
            script.println("</script>");  
        }else if(dto.getWater_off() != null){
        	PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("alert('적용 완료')");
            script.println("location.href = 'water.jsp'");
            script.println("</script>"); 
        }
        // ---------------------------------------------------------------------------------------------------
        // 피드
        
        if(dto.getFeed1() != null){
            PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("alert('적용 완료')");
            script.println("location.href = 'feed.jsp'");
            script.println("</script>");  
        }else if(dto.getFeed2() != null){
        	PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("alert('적용 완료')");
            script.println("location.href = 'feed.jsp'");
            script.println("</script>"); 
        }
        // ---------------------------------------------------------------------------------------------------	
	    	
    }  
}
}