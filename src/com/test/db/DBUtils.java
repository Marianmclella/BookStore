package com.test.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtils {
  
//	数据库的用户名
	private static final String user = "root";
//	数据库的密码
	private static final String password ="";
//	要访问的数据库的地址
	private static final String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&amp;characterEncoding=utf-8";
//	数据库的驱动信息
	private static final String driver = "com.mysql.jdbc.Driver";
//	定义数据库的连接
	private static Connection conn;
//	定义一个Statement对象
	private static Statement statement;
//	定义查询返回的结果集
	private static ResultSet rs;
	
	public DBUtils(){
		try{
			Class.forName(driver);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
//	获取数据库的连接
	public static Connection getConnection(){
		try{
			conn = DriverManager.getConnection(url,user,password);
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}

//	释放资源
	public static void release(){
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (statement != null) {
			try {

				statement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
