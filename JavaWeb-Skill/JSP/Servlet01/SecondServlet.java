package project01;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet{
	
	// �ڹ� ��ü ����ȭ �ĺ���
	private static final long serialVersionUID = 844969363907474930L;

	public void init() throws ServletException{
		LocalDateTime now = LocalDateTime.now();
		System.out.println("("+now+") init �޼��� ȣ��");
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		LocalDateTime now = LocalDateTime.now();
		System.out.println("("+now+") doGet �޼��� ȣ��");
	}
	
	public void destroy() {
		LocalDateTime now = LocalDateTime.now();
		System.out.println("("+now+") destroy �޼��� ȣ��");
	}
}
