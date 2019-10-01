/**
 * Copyright(C) 2019 Luvina JSC
 * BaseDatabase.java, Sep 25, 2019, HangHT
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class đóng và mở kết nối với database
 * 
 * @author HangHT
 *
 */
public class BaseDatabase {
	public static final String URL = "jdbc:mysql://localhost/user_hoangthuhang";
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String USER = "root";
	public static final String PASS = "0000";
	protected Connection con;

	/**
	 * Phương thức khởi tạo DRIVER
	 * 
	 * @throws ClassNotFoundException
	 */
	public BaseDatabase() throws ClassNotFoundException {
		try {
			Class.forName(DRIVER);
			System.out.println("Constructor BaseDB");
		} catch (ClassNotFoundException e) {
			System.out.println("==========BaseDatabase===========");
			System.out.println("ten lop ten phuong thuc" + e.getMessage());
			throw new ClassNotFoundException("Loi lien ket database");
		}
	}

	/**
	 * Mở kết nối
	 * 
	 * @throws SQLException
	 */
	protected void openConnection() throws SQLException {
		try {
			con = DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException("Loi cau lenh SQL");
		}
	}

	/**
	 * Đóng kết nối
	 * 
	 * @throws SQLException
	 */
	protected void closeConnection() throws SQLException {
		try {
			if (con == null || con.isClosed()) {
				return;
			}
			con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException("Loi cu phap SQL");
		}
	}
}
