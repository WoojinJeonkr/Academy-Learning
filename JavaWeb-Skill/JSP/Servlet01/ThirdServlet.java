package project01;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/third")
public class ThirdServlet extends HttpServlet{
	// �ڹ� ��ü ����ȭ �Լ�
	private static final long serialVersionUID = 5366607762573709312L;
	
//	public void init() throws ServletException{
//		LocalDateTime now = LocalDateTime.now();
//		System.out.println("("+now+") init �޼��� ȣ��");
//	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		doHandler(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		doHandler(req, resp);
	}
	
	private void doHandler(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		LocalDateTime now = LocalDateTime.now();
		System.out.println("("+now+") doHandle �޼��� ȣ��");
	}
	
//	public void destroy() {
//		LocalDateTime now = LocalDateTime.now();
//		System.out.println("("+now+") destroy �޼��� ȣ��");
//	}
}
