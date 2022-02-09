package project05;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sess")
public class SessionTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		out.println("세션 아이디: " + session.getId()+"<br/>");
		out.println("최초 세션 생성 시간: " + new Date(session.getCreationTime())+"<br/>");
		out.println("최초 세션 접근 시간: " + new Date(session.getLastAccessedTime())+"<br/>");
		out.println("세션 유효 시간 : " + session.getMaxInactiveInterval()+"<br/>");
		// session 유효시간 변경 : 초단위
		session.setMaxInactiveInterval(10);
		out.println("세션 유효 시간 : " + session.getMaxInactiveInterval()+"<br/>");
		if(session.isNew()) {
			out.println("새 세션이 만들어졌습니다.");
		}
		
		// session.invalidate(); // session 삭제(로그아웃시 사용)
	}

}
