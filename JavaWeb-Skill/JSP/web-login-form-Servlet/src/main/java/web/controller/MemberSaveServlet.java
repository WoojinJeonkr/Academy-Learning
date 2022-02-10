package web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dao.MemberDAO;
import web.vo.MemberVO;

/**
 * @author hi
 * 
 * ȸ������ ������ �����ϴ� Action
 */
@WebServlet("/memberSave")
public class MemberSaveServlet extends HttpServlet {

	private static final long serialVersionUID = -1760578662237200178L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		MemberDAO memberDAO = new MemberDAO();
		
		//--- Parameter �Ѿ�� ȸ������ ������ MemberVO Ŭ������ ����
		MemberVO memberVO = new MemberVO();
		memberVO.setM_id((String)request.getParameter("m_id"));
		memberVO.setM_pw((String)request.getParameter("m_pw"));
		memberVO.setM_name((String)request.getParameter("m_name"));
		memberVO.setM_email((String)request.getParameter("m_email"));
		memberVO.setM_phone((String)request.getParameter("m_phone"));
		
		//--- ȸ������ ������ DB�� ����
		memberDAO.member_save(memberVO);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<script>");
		out.println("alert('"+memberVO.getM_name()+"���� ȸ�����ԵǾ����ϴ�.')");
		out.println("location= '"+request.getContextPath()+"'");
		out.println("</script>");
	}

}
