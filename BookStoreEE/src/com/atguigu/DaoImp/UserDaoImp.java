package com.atguigu.DaoImp;
import com.atguigu.Dao.Base_Dao;
import com.atguigu.Dao.UserDao;
import com.atguigu.bean.User;
/*
 * 继承Base_Dao的已经实现的方法  实现UserDao未实现的方法
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
		//很奇怪这里明明已经成功插入了数据到数据库 却为什么受影响的行数为0
		//System.out.println("影响行数"+update);
		return update>0;
	}

}
