package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	public int login(String Id, String Pass) { // ID SQL 보고 확인 하기
		String SQL = "select pass from user where ID = ?";
	try {
		ps = con.prepareStatement(SQL);
		ps.setString(1,Id);
		rs = ps.executeQuery();
		if(rs.next()) {
			if(rs.getString(1).equals(Pass)) 
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
		String SQL= "insert into user values (?,?,?,?,?)";
		try {
			ps = con.prepareStatement(SQL);
			ps.setString(1,dto.getId());
			ps.setString(2,dto.getPass());
			ps.setString(3,dto.getName());
			return ps.executeUpdate();
		}catch(Exception e) {
				e.printStackTrace();
		}
		return -1; // 데이터 오류
	}
	
	
// -------------------------------------------------------------------------
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
