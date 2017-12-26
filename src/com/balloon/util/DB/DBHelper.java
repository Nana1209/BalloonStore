package com.balloon.util.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.log4j.Logger;

/**
 * DAO辅助类（数据数据库工具类） 建立数据库连接和关闭数据库连接
 * 
 * @author cfy
 *
 */
public class DBHelper {
	private static Logger logger = Logger.getLogger(Logger.class);// ???
	Connection con = null;
	ResultSet rs = null;
	Statement stmt = null;
	PreparedStatement psmt = null;

	/**
	 * 加载驱动并获取数据库连接
	 */
	public Connection getConnection() {
		/*
		 * 加载驱动
		 */
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			logger.error(e);
			e.printStackTrace();
		}
		/*
		 * 建立连接
		 */
		try {
			Thread.sleep(100);
		} catch (InterruptedException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		try {
			//con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\cfy\\Desktop\\java\\database\\balloon.db");
			 con = DriverManager.getConnection("jdbc:sqlite:e:\\database\\balloon.db");
			System.out.println("建立连接成功！");
		} catch (SQLException e) {
			logger.error(e);
			e.printStackTrace();
		}
		return con;
	}

	/**
	 * 关闭数据库连接
	 */
	public void Close() {
		try {
			if (con != null) {
				con.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			System.out.println("关闭连接成功！");
		} catch (SQLException e) {
			logger.error(e);
			e.printStackTrace();
		}
	}
}
