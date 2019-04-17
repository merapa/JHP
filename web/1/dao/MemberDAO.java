package dao;
import java.sql.*;
import java.util.*;
import javax.naming.*;
import javax.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import model.Member;



public class MemberDAO {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	Member member = new Member();
	private int result;
	
	//dbcp 만들기
	public MemberDAO() {
		
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/jhp");
			con = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void dbClose() {
		if(con != null)
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	// -----------------------------------------------------------------
	
	// 회원 가입
	public void MemberInsert(Member member) {
		result = 0;
		try {
			ps = con.prepareStatement("insert into user value (?, ?, ?, ?, ?, ?, ?)");

			member.setid(rs.getString("id"));
			member.setpass(rs.getString("pass"));
			member.setname(rs.getString("name"));
			member.setemail(rs.getString("email"));
			member.setcontact(rs.getString("contact"));
			member.setquestion(rs.getString("question"));
			member.setanswer(rs.getString("answer"));
	  		
	  		result = ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close();} catch (Exception e) {e.printStackTrace();}
			if (ps != null) try { ps.close(); } catch (Exception e) {e.printStackTrace();}
		}
		
		return;
		
	}
	
	
	
	
	
	
	// -----------------------------------------------------------------
	
	// 아이디 중복 확인
	public boolean confirm(String id) throws SQLException {
		con = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		
		
		try {
			con.prepareStatement("select id from jhp where id=?");
			con = getQuestion();
			ps = con.prepareStatement(id);
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
		return false;
	}
	
// -----------------------------------------------------------------
	// 멤버 수정
	
	private Connection getQuestion() {
		return null;
		}

	public int updateMember(Member vo) throws SQLException {
		int result = 0;
		try {
			ps=con.prepareStatement("update user set pass=?,email=?,email1=?,contact=?,"
					+ "question=?,answer=? where id=?");
	
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
	public int idCheck(Connection con, String id) throws Exception,SQLException{
		  PreparedStatement ps = null; 
		  ResultSet rs = null;
		  ps=con.prepareStatement("select id from member where id=?");
		  
		  try{
		   ps = con.prepareStatement(id);
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
			// 회원 가입
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public List<Member> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Member selectOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void insertMember(Member member) {

		
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public PreparedStatement getPs() {
		return ps;
	}

	public void setPs(PreparedStatement ps) {
		this.ps = ps;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
	
	
	

	
}
