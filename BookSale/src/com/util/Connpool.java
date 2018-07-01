package com.util;

import java.sql.*;
public class Connpool {

	private String username  = "root";
	private String password = "scaactk";
	private String url = "jdbc:mysql://localhost:3306/books?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=false";
	private static String driverName = "com.mysql.cj.jdbc.Driver";
	// 连接
	static{
		try{
			// 驱动
			Class.forName(driverName);
			System.out.println("成功");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public Connection get(){
		Connection conn=null;
		try{
			// 获取conn
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("获取Conn成功");
		}catch(SQLException e){
		  e.printStackTrace();
		}
		return conn;
	}
	
}

