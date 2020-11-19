package com.ubot.application.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;

import java.util.logging.Logger;

import com.ubot.application.exception.MSGException;

/**
 * @author Jenny
 *
 * @Description 
 */

public class RDBConnection {
	
	private static final String driver, url, user, dbPwd;
	static {
		//動態取得 
		driver = System.getProperty("driver", "com.ibm.db2.jcc.DB2Driver");
		url = System.getProperty("url", "jdbc:db2://172.16.45.243:50000/APDATA");
		user = System.getProperty("user", "ibkinst");
		dbPwd = System.getProperty("pwd", "ibkinst");
	}

	static Connection getConnection() throws MSGException {
		try {
			Class.forName(driver); // 1.載入JDBC Driver
			try {
				Connection connection = DriverManager.getConnection(url, user, dbPwd);// 2.建立連線
				return connection;
			} catch (SQLException e) {
				throw new MSGException("建立資料庫連線失敗", e);
			}
		} catch (ClassNotFoundException e) {
			throw new MSGException("載入JDBC Driver失敗");
		}
	}

	public static void main(String[] args) {

		try (Connection c = getConnection();) {
			System.out.println(c.getMetaData().getUserName());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (MSGException e) {
			Logger.getLogger("RDBConnection.main").log(Level.SEVERE, e.getMessage());
		} catch (Exception e) {
			Logger.getLogger("RDBConnection.main").log(Level.SEVERE, "發生非預期錯誤", e.getMessage());
		}
	}
}
