package com.atguigu.servlet;
import java.io.IOException;
import java.lang.reflect.Method;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 利用反射机制 构建一个基本的BaseServlet
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
		//处理用户请求
		// login-->LoginServlet   Regist-->RegistServlet
		////这里才是真正的在还未获取数据之前(解决乱码)
		request.setCharacterEncoding("utf-8");
		String method=request.getParameter("method");
		//System.out.println("当前用户调用的方法："+method);
		//getDeclaredMethod(方法名,参数表列表)
		
		try {
			Method method2 = this.getClass().getDeclaredMethod(method, HttpServletRequest.class,HttpServletResponse.class);
		//把方法权限设大
			method2.setAccessible(true);
		//invoke(对象,参数)
		method2.invoke(this, request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
