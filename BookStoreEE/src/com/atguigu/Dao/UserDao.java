package com.atguigu.Dao;

import com.atguigu.bean.User;

//�̳�base_dao�Ļ�����������
/*public class UserDao extends Base_Dao<User> {

}*/
public interface UserDao{
	//�����û��������ѯ��Ϣ
	public User getUserByUsernameAndPassword(User user); 
	//ע���û���Ϣ
	public boolean RegistUser(User user);
}
