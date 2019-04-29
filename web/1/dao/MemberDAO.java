package dao;
import java.sql.*;
import util.*;

import dto.MemberDTO;



public class MemberDAO {
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public MemberDAO() {
		  try {
	            // 로드
	            Class.forName("com.mysql.jdbc.Driver");
	            // 연결
	            con = DriverManager
	                    .getConnection("jdbc:mysql://localhost:3306/JHP",
	                            "jhp", "01230123");

 
        } catch (ClassNotFoundException e) {
            System.out.println(e + "=> 로드 성공");
        } catch (SQLException e) {
            System.out.println(e + "=> 연결 실패");
        }
    }//생성

	public void dbClose() {
		try {
			if(rs != null) rs.close();
			if(rs != null) ps.close();
		}catch(Exception e) {
			System.out.println(e + " dbClose faile");
		}
		
	} // dbclose


	
// ---------------------------------------------------------------------------------
		// 로그인
	public int login(String id , String pass) throws SQLException {
		String sql = "select pass from user where id=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery(); // 쿼리 실행
			
			if ( rs.next()) {
				if(rs.getString(1).equals(pass)) {
					return 1; // 로그인
				}else {
						return 0; // 비밀번호 틀렸을때
				}
			}
			return -1; // 아이디 없을때
			}catch(SQLException e) {
				System.out.println(e + " 로그인 실패");
			}finally {
				dbClose();
			}
		return -2;  // 오류 일 경우
		} 
// ---------------------------------------------------------------------------------
	// 아이디 중복 여부 확인
	
	public boolean idCheck(String id) throws SQLException {
		boolean result = true;
		try {
			ps = con.prepareStatement("select * from user where id=?");
			ps.setString(1, id);
			rs=ps.executeQuery(); // 쿼리 실행
			
			if(rs.next()) 
				result = false; // 레코드 있으면 false
			}catch(SQLException e) {
				System.out.println(e + " 중복 실패");
			}finally {
				dbClose();
			}
			return result;
		} 
	
	
	
// ---------------------------------------------------------------------------------
	// 회원 가입 
	public int join(MemberDTO dto) {
		
		try {

			ps = con.prepareStatement("INSERT INTO user(id,pass,name,email,contact,question,answer) VALUES (?,?,?,?,?,?,?)");
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPass());
			ps.setString(3, dto.getName());
			ps.setString(4, dto.getEmail());
			ps.setString(5, dto.getContact());
			ps.setString(6, dto.getQuestion());
			ps.setString(7, dto.getAnswer());
			System.out.print(ps.toString());
			return ps.executeUpdate(); // 쿼리 실행
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return -1; // 회원가입 실패
	}
// ---------------------------------------------------------------------------------

	
// ---------------------------------------------------------------------------------
		// 회원 수정 
	
		public int modify(MemberDTO dto) {
			try {
				Connection con = DatabaseUtil.getConnection();
				ps = con.prepareStatement("update user set user VALUES (?,?,?,?,?,?)");
				ps.setString(1, dto.getId());
				ps.setString(2, dto.getPass());
				ps.setString(3, dto.getName());
				ps.setString(4, dto.getEmail());
				ps.setString(5, dto.getContact());
				ps.setString(6, dto.getQuestion());
				ps.setString(7, dto.getAnswer());
				System.out.print(ps.toString());
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
