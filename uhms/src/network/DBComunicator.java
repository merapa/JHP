package network;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.concurrent.Callable;

import uhms.Monitor;

public class DBComunicator implements Callable<String[]>{
	
	private Monitor mo = null;
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String message = null;
	private String temp = null;
	private String level = null;
	
	public DBComunicator(Monitor mo) {
		this.mo = mo;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.con = DriverManager.getConnection("jdbc:mysql://iotmit.iptime.org:3308/JHP?useSSL=false&verifyServerCertificate=false","raspberrypi","1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public String[] getOperateData() throws SQLException {
		String temp[] = null;
		String sql = "select * from control";
		this.pstmt = this.con.prepareStatement(sql);
		this.rs = this.pstmt.executeQuery();
		ResultSetMetaData rsmd = this.rs.getMetaData();
		temp = new String[rsmd.getColumnCount()];
		this.rs.next();
		for(int i=1; i<temp.length; i++) {
			temp[i] = this.rs.getString(i);
		}
		return temp;
	}
	
	public void upToDataInDatabase() throws SQLException {
		String sql = "insert into data(datetime, temp, water) values(?,?,?)";
		this.pstmt = this.con.prepareStatement(sql);
		this.pstmt.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
		this.pstmt.setString(2, this.temp);
		this.pstmt.setString(3, this.level);
		System.out.println(this.temp+" "+this.level);
		int i = this.pstmt.executeUpdate();
		System.out.println(i);
	}

	@Override
	public String[] call() throws Exception {
		String[] result = null;
		if(this.message.equals("upToData")) {
			this.upToDataInDatabase();
			System.out.println("out");
		} else if(this.message.equals("getOperateData")) {
			result = this.getOperateData();
		}

		this.message = null;
		return result;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public void shutdown() {
		try {
			if(this.rs!=null) {
				this.rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(this.pstmt!=null) {
				this.pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(this.con!= null) {
				this.con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
