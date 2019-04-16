package dao;

import java.sql.*;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.Member;


public class MemberDAO {
	
	private MemberDAO() {}

	private static MemberDAO instance = new MemberDAO();
	
	// static 통해서 생성할 수 있도록 만들기
	static public MemberDAO getInstance() {
		return instance;
	}
	
	//dbcp 만들기
	public Connection getConnection() {
		Connection con = null;
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("java:comp/env/jdbc/jhp");
			con = ds.getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	// -----------------------------------------------------------------
	
	// 아이디 중복 확인
	public int confirm(String id) {
		String sql = "select id from jhp where id=?";
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		int result = -1;
		
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				result = 1;
			}
		}catch(Exception e) {
			
		}finally {
			try {
				if(rs !=null) rs.close();
				if(ps !=null) ps.close();
				if(con !=null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
// -----------------------------------------------------------------
	// 멤버 수정
	
	public int updateMember(Member vo) {
		int result = -1;
		String sql = "update user set pass=?,email=?,email1=?,contact=?,question=?,answer=? where id=?";
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con=getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getpass());
			ps.setString(2, vo.getemail());
			ps.setString(3, vo.getemail());
			ps.setString(4, vo.getcontact());
			ps.setString(5, vo.getquestion());
			ps.setString(6, vo.getanswer());
			result = ps.executeUpdate();
		}catch(Exception e) {
		}finally {
			try {
				if(ps !=null)ps.close();
				if(con !=null)con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
// -----------------------------------------------------------------
		// 아이디 중복 검사
	public int idCheck(Connection con, String id) throws Exception{
		  PreparedStatement ps = null; 
		  ResultSet rs = null;
		  String sql = "select id from member where id=?";
		  
		  try{
		   ps = con.prepareStatement(sql);
		   ps.setString(1, id);
		   rs = ps.executeQuery();
		   if (rs.next()) {
				return 1;
			} else { // 아이디 없으면 0 반환
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 오류 발생 시 -1 반환
		return -1;
	}
	// -----------------------------------------------------------------
			// 
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public List<Member> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Member selectOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void insertMember(Member member) {
		// TODO Auto-generated method stub
		
	}
	
	
	

	
}
