package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.MemberDTO;


public class MemberDAO {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public MemberDAO() {
		try {
			String dbURL ="jdbc:mysql://localhost:3307/jhp";
			String dbID = "zerock";
			String dbPass ="1234";
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dbURL,dbID,dbPass);
		} catch (Exception e) {
			e.printStackTrace();
		} // mysql 접속 해주는 부분
	}
	
// -------------------------------------------------------------------------
	// 로그인 
	public int login(String id, String pass) throws SQLException { // ID SQL 보고 확인 하기
		String SQL = "select pass from user where ID = ?";
	try {
		ps = con.prepareStatement(SQL);
		ps.setString(1,id);
		rs = ps.executeQuery();
		if(rs.next()) {
			if(rs.getString(1).equals(pass)) 
				return 1; // 로그인 성공
			else
					return 0; // 비밀번호 불일치
			}
		return -1; // 아이디 없을때
	}catch(Exception e) {
		e.printStackTrace();
	}
	return -2; // 데이터베이스 오류
}


// -------------------------------------------------------------------------
	// 회원가입
	
	public int join(MemberDTO dto) {
		String SQL= "insert into user values (?,?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(SQL);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPass());
			ps.setString(3, dto.getName());
			ps.setString(4, dto.getContact());
			ps.setString(5, dto.getEmail());
			ps.setString(6, dto.getQuestion());
			ps.setString(7, dto.getAnswer());
			System.out.print(ps.toString());
			return ps.executeUpdate();
		}catch(Exception e) {
				e.printStackTrace();
		}
		return -1; // 데이터 오류
	}
	
	
// -------------------------------------------------------------------------
			// 회원 수정 
		
			public int modify(MemberDTO dto) {
				try {
					ps = con.prepareStatement("update user set user VALUES (?,?,?,?,?,?)");
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
