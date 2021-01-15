package com.atguigu.test;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import com.atguigu.bean.User;
public class Bean_utilsTest {
	@Test
	public void test1(){
		//setProperty(bean, name, value)
		//bean代表给哪个对象设置属性值
		//name代表要设置的属性名
		//value代表要设置的属性值
		User user = new  User();
		System.out.println("未设置值之前"+user);
		try {
			BeanUtils.setProperty(user, "username", "小东");
			System.out.println("设置值之后"+user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
