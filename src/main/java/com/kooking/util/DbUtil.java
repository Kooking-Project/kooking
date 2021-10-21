package com.kooking.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DbUtil {
	private static DataSource ds;

	static {
		try {
		  Context initContext = new InitialContext();
		  ds = (DataSource)initContext.lookup("java:/comp/env/jdbc/kooking");
		  
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws SQLException{
		return  ds.getConnection();
	}
	
	
	public static void dbClose(AutoCloseable ...acArr) {
		if(acArr == null || acArr.length<=0) {
			return;
		}
		
		for(AutoCloseable ac : acArr) {
			if(ac != null) {
				try {
					ac.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}








