package com.atguigu.test;
import java.sql.Connection;
import org.junit.Test;

import com.atguigu.utils.JDBC_Utils;

/*
 * �������ݿ���
 * 
 * */
public class jdbc_utilsTest {
	@Test
  public void getConnection(){
	  Connection connection=JDBC_Utils.getConnection();
	  System.out.println("�����������ݿ�:"+connection);
	  JDBC_Utils.releaseConnection(connection);
	  System.out.println("�ѹر����ݿ�����:"+connection);
  }
}
