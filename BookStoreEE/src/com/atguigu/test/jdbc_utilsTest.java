package com.atguigu.test;
import java.sql.Connection;
import org.junit.Test;

import com.atguigu.utils.JDBC_Utils;

/*
 * 测试数据库类
 * 
 * */
public class jdbc_utilsTest {
	@Test
  public void getConnection(){
	  Connection connection=JDBC_Utils.getConnection();
	  System.out.println("测试连接数据库:"+connection);
	  JDBC_Utils.releaseConnection(connection);
	  System.out.println("已关闭数据库连接:"+connection);
  }
}
