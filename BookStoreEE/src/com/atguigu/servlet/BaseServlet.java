package com.atguigu.servlet;
import java.io.IOException;
import java.lang.reflect.Method;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * ���÷������ ����һ��������BaseServlet
 * */
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private UserService userService =new UserServiceImp();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�����û�����
		// login-->LoginServlet   Regist-->RegistServlet
		////��������������ڻ�δ��ȡ����֮ǰ(�������)
		request.setCharacterEncoding("utf-8");
		String method=request.getParameter("method");
		//System.out.println("��ǰ�û����õķ�����"+method);
		//getDeclaredMethod(������,�������б�)
		
		try {
			Method method2 = this.getClass().getDeclaredMethod(method, HttpServletRequest.class,HttpServletResponse.class);
		//�ѷ���Ȩ�����
			method2.setAccessible(true);
		//invoke(����,����)
		method2.invoke(this, request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
