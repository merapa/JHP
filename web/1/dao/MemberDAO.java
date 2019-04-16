package dao;

import java.io.IOException;
import java.sql.*;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import model.Member;


public class MemberDAO {

	
	private MemberDAO() {
	}

	private static MemberDAO instance = new MemberDAO();
	private String id;
	private String pass;
	private String name;
	private String email;
	private String question;
	private String contact;
	private String answer;
	private int n;
	private Connection con;
	private PreparedStatement ps;
	private int result;
	
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
	
	// 회원 가입
	protected boolean service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		request.setCharacterEncoding("UTF-8");
		setId(request.getParameter("id"));
		setPass(request.getParameter("pass"));
		setName(request.getParameter("name"));
		setEmail(request.getParameter("email"));
		setContact(request.getParameter("contact"));
		setQuestion(request.getParameter("question"));
		setAnswer(request.getParameter("answer"));
		
		setN(0);
		setPs(null);
		setCon(null);
		
		Connection con = null;
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("java:comp/env/jdbc/jhp");
			con = ds.getConnection();
			ps=con.prepareStatement("INSERT INTO member VALUES (?,?,?,?,?,?)");
	  		ps.setString(1,id);
	  		ps.setString(2,pass);
	  		ps.setString(3,name);
	  		ps.setString(4,email);
	  		ps.setString(5,contact);
	  		ps.setString(6,question);
	  		ps.setString(7,answer);
	  		
	  		setResult(ps.executeUpdate());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	
	
	
	// -----------------------------------------------------------------
	
	// 아이디 중복 확인
	public boolean confirm(String id) throws SQLException {
		con = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		
		
		try {
			con.prepareStatement("select id from jhp where id=?");
			con = getConnection();
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
	
	public int updateMember(Member vo) throws SQLException {
		int result = -1;
		ps=con.prepareStatement("update user set pass=?,email=?,email1=?,contact=?,question=?,answer=? where id=?");
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con=getConnection();
			ps = con.prepareStatement(id);
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
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
