/**
 * Copyright(C) 2019 Luvina JSC
 * BaseDatabase.java, Sep 25, 2019, HangHT
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author HangHT
 *
 */
public class BaseDatabase {
	public static final String URL = "jdbc:mysql://localhost/user_hoangthuhang";
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String USER = "root";
	public static final String PASS = "0000";
	protected Connection con;
	
	public BaseDatabase() throws ClassNotFoundException {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			throw new ClassNotFoundException("Loi lien ket database");
		}
	}
	
	protected void openConnection() throws SQLException {
		try {
			con = DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException("Loi cau lenh SQL");
		}
	}
	
	protected void closeConnection() throws SQLException {
		try {
			if(con != null || !con.isClosed()) {
				con.close();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}
}
