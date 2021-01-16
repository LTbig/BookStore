package com.atguigu.utils;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
/*
 * ��ȡ���ͷ����ݿ�����
 * 
 * */
public class JDBC_Utils {
	//c3p0���ӳػ�ȡ �ұ�֤�����Ŀʹ�õ���һ�����ݿ����ӳ�
	private static DataSource ds = new ComboPooledDataSource("webDataSource");
	/*
	 * ��ȡ���ݿ�����
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
	 * �ͷ����ݿ�����
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
