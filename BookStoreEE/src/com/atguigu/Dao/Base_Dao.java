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
 * dao���һ�������������(���Ѿ�ʵ�ֵ�)  ������������dao��̳�
 * 
 * */
public class Base_Dao<T> {
	
	private QueryRunner runner = new QueryRunner();
	//���type�Ǽٵ�  ������Ҫ��ȡʵ�ʵ�type
	private Class<T> type;
	//������
	public Base_Dao(){
		ParameterizedType Superclass = (ParameterizedType)this.getClass().getGenericSuperclass();
		//��ȡ���������,�����Ǵ�������
		//System.out.println("������ʵ��һ���в��������ͣ�-->"+Superclass.getClass());
	     //��ȡ���������� Ϊ�������� ����ֻȡ��һ������   Ȼ��ǿת
		//�����������������Ҫ��ȡ��type
		type  = (Class<T>) Superclass.getActualTypeArguments()[0];
	}
	/*
	 * ��ȡһ������
	 * 
	 * */
	public T getBean(String sql,Object ...params){
		//��ȡ����
		Connection connection = JDBC_Utils.getConnection();
		T query=null;
		try {
			//��ѯһ������
			query = runner.query(connection, sql, new BeanHandler<>(type), params);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}finally{
			//�ͷ�����
			JDBC_Utils.releaseConnection(connection);
			//System.out.println("queryΪ��"+query);
		}
		return query;
		
		
	}
	/*
	 * ��ȡ����ļ���
	 * */
	public List<T> getBeanList(String sql, Object ...params){//��̬����
		//��ȡ����
		Connection connection=JDBC_Utils.getConnection();
		List<T> query=null;
		   try {
	    //��ѯһ������
		query = runner.query(connection, sql, new BeanListHandler<>(type), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}finally{
			//�ͷ�����
			JDBC_Utils.releaseConnection(connection);
		}
		return query;
	}
	/*
	 * ִ����ɾ��
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
	 * ��ȡ����ֵ
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
