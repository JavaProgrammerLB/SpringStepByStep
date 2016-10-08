package com.yitianyigexiangfa.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectDatabase {

	public ConnectDatabase() {
	
	}
	
	public void connectToAndQueryDatabase(String username, String password) throws SQLException{
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM user");
			while (rs.next()) {
				int index = 1;
				int user_id = rs.getInt(index);
				String name = rs.getString(index ++);
				String email = rs.getString(index ++);
				String pw = rs.getString(index ++);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			rs.close();
			stmt.close();
			con.close();
		}
	}
	
	public static void main(String[] args) {
		ConnectDatabase con = new ConnectDatabase();
		try {
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
