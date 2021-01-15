package com.atguigu.utils;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
/*
 * 获取和释放数据库链接
 * 
 * */
public class JDBC_Utils {
	//c3p0连接池获取 且保证书城项目使用的是一个数据库连接池
	private static DataSource ds = new ComboPooledDataSource("webDataSource");
	/*
	 * 获取数据库连接
	 * */
	public static Connection getConnection(){
		Connection connection=null;
		try {
			 connection= ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	/*
	 * 释放数据库连接
	 * 
	 * */
	public static void releaseConnection(Connection connection){
		try {
			if(connection!=null){
			connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
