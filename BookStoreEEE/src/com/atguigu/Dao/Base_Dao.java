package com.atguigu.Dao;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.atguigu.utils.JDBC_Utils;
/*
 * dao层的一般基本操作方法(是已经实现的)  可以由其他的dao层继承
 * 
 * */
public class Base_Dao<T> {
	
	private QueryRunner runner = new QueryRunner();
	//这个type是假的  我们需要获取实际的type
	private Class<T> type;
	//构造器
	public Base_Dao(){
		ParameterizedType Superclass = (ParameterizedType)this.getClass().getGenericSuperclass();
		//获取父类的类型,父类是带参数的
		//System.out.println("这里其实是一个有参数的类型：-->"+Superclass.getClass());
	     //获取参数的类型 为数组类型 这里只取第一个数据   然后强转
		//而这才是我们真正需要获取的type
		type  = (Class<T>) Superclass.getActualTypeArguments()[0];
	}
	/*
	 * 获取一个对象
	 * 
	 * */
	public T getBean(String sql,Object ...params){
		//获取连接
		Connection connection = JDBC_Utils.getConnection();
		T query=null;
		try {
			//查询一个数据
			query = runner.query(connection, sql, new BeanHandler<>(type), params);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}finally{
			//释放连接
			JDBC_Utils.releaseConnection(connection);
			//System.out.println("query为："+query);
		}
		return query;
		
		
	}
	/*
	 * 获取对象的集合
	 * */
	public List<T> getBeanList(String sql, Object ...params){//动态参数
		//获取连接
		Connection connection=JDBC_Utils.getConnection();
		List<T> query=null;
		   try {
	    //查询一组数据
		query = runner.query(connection, sql, new BeanListHandler<>(type), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}finally{
			//释放连接
			JDBC_Utils.releaseConnection(connection);
		}
		return query;
	}
	/*
	 * 执行增删改
	 * */
	public int update(String sql,Object  ...params){
		//runner.u
		int count= 0;
		Connection connection = JDBC_Utils.getConnection();
		try {
		    count = runner.update(connection, sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}finally{
			JDBC_Utils.releaseConnection(connection);	
		}
		return count;
		}
	/**
	 * 获取单个值
	 * @return
	 */
	public Object getSingleValue(String sql,Object  ...params){
		//runner.u
		Object query=null;
		Connection connection = JDBC_Utils.getConnection();
		try {
				 query= runner.query(connection, sql, new ScalarHandler(), params);
		} catch (SQLException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
		}finally{
				JDBC_Utils.releaseConnection(connection);	
			}
		return query;
	}
}
