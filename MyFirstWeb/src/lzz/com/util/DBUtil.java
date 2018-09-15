package lzz.com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtil {
	
	private final static DBUtil util = new DBUtil();
	
	private String name = "root";
	private String pass = "root";
	private String url = "jdbc:mysql://localhost:3306/myustb";
	
	private Connection conn; 
	private String className = "com.mysql.jdbc.Driver";
	
	private DBUtil() {
		
	}
	
	public static DBUtil getInstance() {
		return util;
	}
	
	public Connection getConnection(){
		try {
			Class.forName(className);
			conn = DriverManager.getConnection(url,name,pass);
			//System.out.println("获得数据库连接");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	
}
