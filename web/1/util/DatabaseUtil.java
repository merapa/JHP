package util;

import java.sql.*;

public class DatabaseUtil {

	
	public static Connection getConnection() {
		try {
			String dburl ="jdbc:mariadb://localhost:3308/jhp";
			String dbid = "root";
			String dbpass = "01230123";
			Class.forName("org.mariadb.jdbc.Driver");
			return DriverManager.getConnection(dburl,dbid,dbpass);			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
