package com.lover.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class DataBaseUtil {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;

	static {
		Properties pps = new Properties();
		try {
			pps.load(DataBaseUtil.class.getResourceAsStream("db.properties"));
			driver = pps.getProperty("driver");
			url = pps.getProperty("url");
			user = pps.getProperty("user");
			password = pps.getProperty("password");
			Class.forName(driver);
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection conn , Statement stmt , ResultSet rs) { 
		if(conn !=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 测试数据库连接函数
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(DataBaseUtil.getConnection());
	}
	
}
