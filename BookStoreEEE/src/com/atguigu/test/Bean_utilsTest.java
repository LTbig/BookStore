package com.atguigu.test;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import com.atguigu.bean.User;
public class Bean_utilsTest {
	@Test
	public void test1(){
		//setProperty(bean, name, value)
		//bean������ĸ�������������ֵ
		//name����Ҫ���õ�������
		//value����Ҫ���õ�����ֵ
		User user = new  User();
		System.out.println("δ����ֵ֮ǰ"+user);
		try {
			BeanUtils.setProperty(user, "username", "С��");
			System.out.println("����ֵ֮��"+user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
