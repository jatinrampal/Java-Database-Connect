package testpack;

import java.sql.*;

public class DBAccess {
	private final String driver = "com.mysql.jdbc.Driver";
	private final String url = "jdbc:mysql://localhost:3306/test";
	private final String uname = "root";
	private final String upass = "";
	private Connection con;
	private Statement st;
	
	
	public DBAccess() {
		try {
			Class.forName(driver).newInstance();
			con = DriverManager.getConnection(url, uname, upass);
			st = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
	public void retrieveUser(){
		String sql = "select user() as user, version() as version";
		try {
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}