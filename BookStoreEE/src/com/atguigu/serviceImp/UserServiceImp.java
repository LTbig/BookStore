package com.atguigu.serviceImp;
import com.atguigu.Dao.UserDao;
import com.atguigu.DaoImp.UserDaoImp;
import com.atguigu.bean.User;
import com.atguigu.service.UserService;

public class UserServiceImp implements UserService {
   private UserDao userDao =new UserDaoImp();
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userDao.getUserByUsernameAndPassword(user);
		 
	}

	@Override
	public boolean regist(User user) {
		// TODO Auto-generated method stub
		return userDao.RegistUser(user);
	}

}
