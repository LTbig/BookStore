package com.atguigu.DaoImp;
import com.atguigu.Dao.Base_Dao;
import com.atguigu.Dao.UserDao;
import com.atguigu.bean.User;
/*
 * �̳�Base_Dao���Ѿ�ʵ�ֵķ���  ʵ��UserDaoδʵ�ֵķ���
 * 
 * */
public class UserDaoImp extends Base_Dao<User> implements UserDao {

	@Override
	public User getUserByUsernameAndPassword(User user) {
		// TODO Auto-generated method stub
		String sql ="select * from bs_user where username=? and password=?";
		User bean =this.getBean(sql, user.getUsername(),user.getPassword());
		return bean;
	}

	@Override
	public boolean RegistUser(User user) {
		// TODO Auto-generated method stub
		String sql="insert into bs_user(username,password,email)value(?,?,?)";
		//update>0
		int update = this.update(sql, user.getUsername(),user.getPassword(),
				user.getEmail());
		//��������������Ѿ��ɹ����������ݵ����ݿ� ȴΪʲô��Ӱ�������Ϊ0
		//System.out.println("Ӱ������"+update);
		return update>0;
	}

}
