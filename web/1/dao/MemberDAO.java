package dao;
import java.sql.*;
import util.*;

import dto.MemberDTO;



public class MemberDAO {
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

// ---------------------------------------------------------------------------------
	// 로그인
	
	public int login(String id,String pass) throws SQLException {
		Connection con = DatabaseUtil.getConnection();
		ps = con.prepareStatement("select * from user where id=?");
		try {
			con = DatabaseUtil.getConnection();
			ps = con.prepareStatement(id);
			ps.setString(1, id);

			rs=ps.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(pass)) {
					return 1; // 로그인 성공
				}
				else {
					return 0; // 비밀번호 틀림
				}
			}
			return -1; // 아이디 없을때
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return -2;
		
	}
	
	
	
// ---------------------------------------------------------------------------------
	// 회원 가입 
	public int join(MemberDTO dto) {
		try {
			Connection con = DatabaseUtil.getConnection();
			ps = con.prepareStatement("INSERT INTO user VALUES (?,?,?,?,?,?,?,?)");
		
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPass());
			ps.setString(3, dto.getName());
			ps.setString(4, dto.getContact());
			ps.setString(5, dto.getEmail());
			ps.setString(6, dto.getQuestion());
			ps.setString(7, dto.getAnswer());
			return ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return -1; // 회원가입 실패
	}
// ---------------------------------------------------------------------------------
	// 아이디 체크
		public boolean idCheck(MemberDTO dto) {
			try {
				Connection con = DatabaseUtil.getConnection();
				ps = con.prepareStatement("select id from user where id =?");
				ps.setString(1, dto.getId());
				rs = ps.executeQuery();
				if(rs.next()) {
					return rs.getBoolean(1);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
				try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
				try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
			}
			return false; // 회원체크 실패
		}
	
// ---------------------------------------------------------------------------------
		// 회원 수정 
	
		public int modify(MemberDTO dto) {
			try {
				Connection con = DatabaseUtil.getConnection();
				ps = con.prepareStatement("update user set user VALUES (?,?,?,?,?,?,?,?)");
				ps.setString(1, dto.getId());
				ps.setString(2, dto.getPass());
				ps.setString(3, dto.getContact());
				ps.setString(4, dto.getEmail());
				ps.setString(5, dto.getQuestion());
				ps.setString(6, dto.getAnswer());
				return ps.executeUpdate();
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
				try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
				try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
			}
			return -1; // 회원수정 실패
		}
	
// ---------------------------------------------------------------------------------
		// 아이디 찾기 
			public int Forget_id(MemberDTO dto) {
				try {
					Connection con = DatabaseUtil.getConnection();
					ps = con.prepareStatement("select id from user where id =?");
					ps.setString(1, dto.getName());
					ps.setString(2, dto.getContact());
					ps.setString(3, dto.getEmail());
					return ps.executeUpdate();
					
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
					try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
					try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
				}
				return -1; // 회원찾기 실패
			}
// ---------------------------------------------------------------------------------
		// 비밀번호 찾기 
				public int Forget_pass(MemberDTO dto) {
					try {
						Connection con = DatabaseUtil.getConnection();
						ps = con.prepareStatement("select pass from user where pass =?");
						ps.setString(1, dto.getId());
						ps.setString(2, dto.getName());
						ps.setString(3, dto.getContact());
						ps.setString(4, dto.getEmail());
						ps.setString(5, dto.getQuestion());
						ps.setString(6, dto.getAnswer());
						return ps.executeUpdate();
						
					}catch(Exception e) {
						e.printStackTrace();
					}finally {
						try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
						try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
						try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
					}
					return -1; // 비밀번호 찾기 실패
				}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
