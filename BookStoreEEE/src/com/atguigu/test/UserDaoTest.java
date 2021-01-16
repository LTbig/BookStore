package com.atguigu.test;
import org.junit.Test;

import com.atguigu.Dao.UserDao;
import com.atguigu.DaoImp.UserDaoImp;
import com.atguigu.bean.User;

public class UserDaoTest {
	@Test//≤‚ ‘≤È—Ø
	public void test(){
		UserDao userDao =new UserDaoImp();
		User user = userDao.getUserByUsernameAndPassword(new User(null,"tomcat","123456",null));
		System.out.println(user);
	}
	@Test//≤‚ ‘◊¢≤·
	public void test2(){
		UserDao userDao =new UserDaoImp();
		Boolean Boean = userDao.RegistUser(new User(null,"tomcat7","123759",null));
		System.out.println(Boean);
	}

}
