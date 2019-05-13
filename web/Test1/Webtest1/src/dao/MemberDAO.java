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
		} // mysql ���� ���ִ� �κ�
	}
	
// -------------------------------------------------------------------------
	// �α��� 
	public int login(String Id, String Pass) { // ID SQL ���� Ȯ�� �ϱ�
		String SQL = "select pass from user where = ID = ?";
	try {
		ps = con.prepareStatement(SQL);
		ps.setString(1,Id);
		rs = ps.executeQuery();
		if(rs.next()) {
			if(rs.getString(1).equals(Pass)) 
				return 1; // �α��� ����
			else
					return 0; // ��й�ȣ ����ġ
			}
		return -1; // ���̵� ������
	}catch(Exception e) {
		e.printStackTrace();
	}
	return -2; // �����ͺ��̽� ����
}


// -------------------------------------------------------------------------
	// ȸ������
	
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
		return -1; // ������ ����
	}
	
	
// -------------------------------------------------------------------------
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}