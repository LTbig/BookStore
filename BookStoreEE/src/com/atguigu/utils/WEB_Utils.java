package com.atguigu.utils;
import java.lang.reflect.Field;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
/*
 * web的相关工具
 * */

public class WEB_Utils {
	/*
	 * 传入request对象将request中的数据封装成对象
	 * */
	//第1种封装方法
	public static<T> T param2bean(HttpServletRequest request,T t){
		//封装对象 并返回
		//1.获取所有声明的属性
		Field[] fields = t.getClass().getDeclaredFields();
		//2.每个属性都有name值，属性名
		for(Field field:fields){
			//获取属性名
			String name = field.getName();
			//在request中获取响应的属性值
			String value = request.getParameter(name);
			try {
				//setProperty(bean, name, value)
				//bean代表给哪个对象设置属性值
				//name代表要设置的属性名
				//value代表要设置的属性值
				BeanUtils.setProperty(t, name, value);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//封装对象setAttrName()
			//javaBean属性 private String name
			//getter setter方法才是javaBean的属性getAttr-attr;
			//例如getImgPath 属性名为 imgPath setImgPath 属性名为 imgPath
		}
		return t;
	}
	//第2种封装方法 进来就反射
	public static<T> T param2bean2(HttpServletRequest request,T t){
		/*Map map = request.getParameterMap();*/
		//这个方法有点问题 可能和jar包的版本有问题
		Map map = request.getParameterMap();
		 try {
			BeanUtils.populate(t, map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}
}
