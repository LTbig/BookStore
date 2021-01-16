package com.atguigu.Dao;

import com.atguigu.bean.User;

//继承base_dao的基本操作方法
/*public class UserDao extends Base_Dao<User> {

}*/
public interface UserDao{
	//根据用户名密码查询信息
	public User getUserByUsernameAndPassword(User user); 
	//注册用户信息
	public boolean RegistUser(User user);
}
