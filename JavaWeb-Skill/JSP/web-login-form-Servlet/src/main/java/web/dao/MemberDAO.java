package web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import web.vo.MemberVO;

/**
 * 
 * @author hi
 * Member Database Access Object
 * 
 * �ڹ����� �ٷ�� ��� p.239
 * <Resource name="jdbc/mariadb"
    		  auth="Container"
    		  type="javax.sql.DataSource"
    		  driverClassName="org.mariadb.jdbc.Driver"
    		  url="jdbc:mariadb://localhost:3306/mars"
    		  username="mars"
    		  password="p@ss00"
    		  maxActive="50"
    		  maxWait="-1"/>
 */
public class MemberDAO {
	
	private DataSource dataFactory;
	
	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource)envContext.lookup("jdbc/mariadb");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * generic ǥ���
	 * ���� ���ϴ� ��ü�� ����Ʈ�� �������� Ȯ������ ���� ���
	 * ȸ���� ����� �������� �Լ�
	 * @return
	 */
	public List<MemberVO> member_list(){
		List<MemberVO> list = new ArrayList<MemberVO>();
		Connection con = null; // database ������ ���� ��ü
		PreparedStatement pstmt = null; // SQL ���� ������ ������ ���� ��ü
		ResultSet rs = null; // SQL�� �����ϰ� ����� ��� ���� ��ü
		try {
			con = dataFactory.getConnection();
			//---------- member�� select�ؼ� MemberVO ��ü�� �����͸� ���� �� List�� �ϳ��� �߰��Ѵ�.
			String query = "select * from member";
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVO memberVO = new MemberVO();
				
				memberVO.setM_idx(rs.getInt("m_idx"));
				memberVO.setM_name(rs.getString("m_name"));
				memberVO.setM_id(rs.getString("m_id"));
				memberVO.setM_pw(rs.getString("m_pw"));
				memberVO.setM_email(rs.getString("m_email"));
				memberVO.setM_phone(rs.getString("m_phone"));
				memberVO.setM_mdfydate(rs.getTimestamp("m_mdfydate"));
				memberVO.setM_rgstdate(rs.getTimestamp("m_rgstdate"));
				
				list.add(memberVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	/**
	 * ȸ�� �������� �ش��ϴ� ȸ�� ������ �ϳ� �������� �Լ�
	 * @return
	 */
	public MemberVO member_view(int m_idx){
		Connection con = null; // database ������ ���� ��ü
		PreparedStatement pstmt = null; // SQL ���� ������ ������ ���� ��ü
		ResultSet rs = null; // SQL�� �����ϰ� ����� ��� ���� ��ü
		
		MemberVO memberVO = new MemberVO();
		
		try {
			//-- connection ó��
			con = dataFactory.getConnection();
			
			//-- ����� ����
			String query = "select * from member where m_idx=?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, m_idx);
			rs = pstmt.executeQuery(); // ������ �����ϰ� ����� ResultSet�� ����
			
			if(rs.next()) {
				memberVO.setM_idx(rs.getInt("m_idx"));
				memberVO.setM_id(rs.getString("m_id"));
				memberVO.setM_name(rs.getString("m_name"));
				memberVO.setM_email(rs.getString("m_email"));
				memberVO.setM_phone(rs.getString("m_phone"));
				memberVO.setM_mdfydate(rs.getTimestamp("m_mdfydate"));
				memberVO.setM_rgstdate(rs.getTimestamp("m_rgstdate"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return memberVO;
	}
}
