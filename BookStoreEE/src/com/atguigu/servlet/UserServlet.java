package com.atguigu.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atguigu.bean.User;
import com.atguigu.service.UserService;
import com.atguigu.serviceImp.UserServiceImp;
import com.atguigu.utils.WEB_Utils;
/*
 * 处理所有和用户相关的请求
 * 抽取出BaseServlet以后UserServlet里面只需要编写相应的处理逻辑(方法)即可
 * */
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService =new UserServiceImp();
	//方法名(request,response)
	//修改用户名密码方法
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
  //登录方法
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*String username=request.getParameter("username");
		String password=request.getParameter("password");*/
		//第一种封装方法
		User user2 = WEB_Utils.param2bean(request, new User());
		//第二种封装方法这里应该是相关jar包的版本问题 暂时先用第一种封装方法
		/*User user = WEB_Utils.param2bean2(request, new User());*/
		//用户登录,用户的详情
		User user = userService.login(user2);
		System.out.println(user);
		//将用户保存到session中
		HttpSession session = request.getSession();
		System.out.println("JSESSIONID:"+session.getId());
		session.setAttribute("user", user);
		if(user==null){
			//登录失败 返回登录页面即可 转发 (且在转发之前设置错误提示消息)
			request.setAttribute("msg", "登录失败");
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);;
		}
		else{
			//登录成功 返回成功页面 重定向 
			
			response.sendRedirect(request.getContextPath()+"/pages/user/login_success.jsp");
		}
	}
	//注册方法
	protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	/*	String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");*/
		User user = WEB_Utils.param2bean(request, new User());//使用第一种封装方法
		//将用户信息保存到数据库中
		boolean b = userService.regist(user);
		if(b){
			//注册成功 返回到注册成功页面  绝对路径重定向
			response.sendRedirect(request.getContextPath()+"/pages/user/regist_success.jsp");
		}
		else{
			//注册失败 再次返回到注册页面 重新注册 绝对路径转发 并设置注册失败消息
			request.setAttribute("msg", "注册失败");
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);;
		}
	}
	//登出方法
	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
      HttpSession session = request.getSession();
      //销毁session即可
      session.invalidate();
      //点完登出后返回首页
      response.sendRedirect(request.getContextPath()+"/index.jsp");
	}
}
