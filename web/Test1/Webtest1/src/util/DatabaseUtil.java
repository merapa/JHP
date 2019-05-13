package util;

import java.sql.*;

public class DatabaseUtil {

	
	public static Connection getConnection() {
		try {
			String dburl ="jdbc:mysql://localhost:3307/JHP";
			String dbid = "jhp";
			String dbpass = "1234";
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(dburl,dbid,dbpass);			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
