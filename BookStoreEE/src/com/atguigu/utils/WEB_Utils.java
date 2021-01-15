package com.atguigu.utils;
import java.lang.reflect.Field;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
/*
 * web����ع���
 * */

public class WEB_Utils {
	/*
	 * ����request����request�е����ݷ�װ�ɶ���
	 * */
	//��1�ַ�װ����
	public static<T> T param2bean(HttpServletRequest request,T t){
		//��װ���� ������
		//1.��ȡ��������������
		Field[] fields = t.getClass().getDeclaredFields();
		//2.ÿ�����Զ���nameֵ��������
		for(Field field:fields){
			//��ȡ������
			String name = field.getName();
			//��request�л�ȡ��Ӧ������ֵ
			String value = request.getParameter(name);
			try {
				//setProperty(bean, name, value)
				//bean������ĸ�������������ֵ
				//name����Ҫ���õ�������
				//value����Ҫ���õ�����ֵ
				BeanUtils.setProperty(t, name, value);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//��װ����setAttrName()
			//javaBean���� private String name
			//getter setter��������javaBean������getAttr-attr;
			//����getImgPath ������Ϊ imgPath setImgPath ������Ϊ imgPath
		}
		return t;
	}
	//��2�ַ�װ���� �����ͷ���
	public static<T> T param2bean2(HttpServletRequest request,T t){
		/*Map map = request.getParameterMap();*/
		//��������е����� ���ܺ�jar���İ汾������
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
