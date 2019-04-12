package dao;

import java.sql.*;
import java.util.*;
import model.*;
 
public class MemberDAO {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String url;
	private String user;
	private String pw;
	
	public MemberDAO() {
		try{
			Class.forName("org.mariadb.jdbc.Driver");
			con=null;
			ps=null;
			rs=null;
			url="jdbc:mariadb://127.0.0.1:3307/jhp";
			user="zerock";
			pw="1234";
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	// 현재 회원 확인
	public boolean checkMember(String id,String email) throws SQLException{
		try {
			String sql="select * from user where id =?";
			con = DriverManager.getConnection(url, user, pw);
			ps = con.prepareStatement(sql);
			ps.setString(1,id);
			ps.setString(2,email);
			rs=ps.executeQuery();
			// rs에 아무것도 안뜨면 회원이 아니다
			boolean isExist=rs.next();
			return isExist;
		}finally {
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(con!=null) con.close();
		}
	}
//    dao 패키지에 있는 DTO 꺼 가져와서 쓰기
//    회원정보셋 데이터 추가하기
    public int insertMember(MemberDTO dto) throws SQLException{
    	try {
        	String sql = "insert into member values (?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, dto.getid());
            ps.setString(2, dto.getpass());
            ps.setString(3, dto.getname());
            ps.setString(4, dto.getcontact());
            ps.setString(5, dto.getemail());
            ps.setString(6, dto.getquestion());
            ps.setString(7, dto.getanswer());
            java.util.Date date = new java.util.Date();
            int n=ps.executeUpdate();
            return n;
    }finally{
    	if(ps!=null) ps.close();
    	if(con!=null) con.close();
    }
    
  }
    
    public void updateMember(MemberDTO dto)
    {
        String sql = "update user set pass=?, name=?, email=?,contact =? where id=?";
        PreparedStatement pstmt = null;
 
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, dto.getid());
            pstmt.setString(2, dto.getpass());
            pstmt.setString(3, dto.getname());
            pstmt.setString(4, dto.getemail());
            pstmt.setString(5, dto.getcontact());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null && !pstmt.isClosed())
                    pstmt.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
//    id에 해당하는 멤버 조회하기
    public Member selectOne(String id)
    {
        String sql = "select * from user where id = ?";
//        구문객체, 리턴할 객체, 결과셋 참조변수들 준비
        PreparedStatement pstmt = null;
        Member member = null;//리턴할 객체참조변수
        ResultSet rs = null;//결과셋 참조변수들 준비
        
        try {
//            구문객체획득
            pstmt = con.prepareStatement(sql);
//            구문완성
            pstmt.setString(1, id);
//            구문 날리고 result set 획득
            rs = pstmt.executeQuery();
//            Resultset 탐색
            if( rs.next() )
            {
                member = new Member();
                member.setid( rs.getString("id"));
                member.setpass(rs.getString("pass"));
                member.setname( rs.getString("name"));
                member.setemail(rs.getString("email"));
                member.setcontact(rs.getString("contact"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally{
            try{
                if( pstmt != null && !pstmt.isClosed())
                    pstmt.close();
                if( rs != null && !rs.isClosed())
                    pstmt.close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }
        return member;
    }
    
//    member의 테이블정보 전체조회하기
    public List<Member> selectAll() {
        String sql = "select * from member";
        PreparedStatement pstmt = null;
//        결과값 탐색
        ResultSet rs = null;
        List<Member> memberList = new ArrayList<Member>();
        
        try {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while( rs.next() )
            {
                Member member = new Member();
                member.setid( rs.getString("id") );
                member.setpass(rs.getString("pw"));
                member.setname(rs.getString("name"));
                member.setemail(rs.getString("email"));
                member.setcontact(rs.getString("contact"));
                memberList.add(member);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//        구문객체와 Resultset객체 닫아주기
        finally{
            try{
                if( pstmt != null && !pstmt.isClosed())
                    pstmt.close();
                if( rs != null && !rs.isClosed())
                    pstmt.close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }
        return memberList;
        
    }
}
