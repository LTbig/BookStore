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
 * �������к��û���ص�����
 * ��ȡ��BaseServlet�Ժ�UserServlet����ֻ��Ҫ��д��Ӧ�Ĵ����߼�(����)����
 * */
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService =new UserServiceImp();
	//������(request,response)
	//�޸��û������뷽��
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
  //��¼����
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*String username=request.getParameter("username");
		String password=request.getParameter("password");*/
		//��һ�ַ�װ����
		User user2 = WEB_Utils.param2bean(request, new User());
		//�ڶ��ַ�װ��������Ӧ�������jar���İ汾���� ��ʱ���õ�һ�ַ�װ����
		/*User user = WEB_Utils.param2bean2(request, new User());*/
		//�û���¼,�û�������
		User user = userService.login(user2);
		System.out.println(user);
		//���û����浽session��
		HttpSession session = request.getSession();
		System.out.println("JSESSIONID:"+session.getId());
		session.setAttribute("user", user);
		if(user==null){
			//��¼ʧ�� ���ص�¼ҳ�漴�� ת�� (����ת��֮ǰ���ô�����ʾ��Ϣ)
			request.setAttribute("msg", "��¼ʧ��");
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);;
		}
		else{
			//��¼�ɹ� ���سɹ�ҳ�� �ض��� 
			
			response.sendRedirect(request.getContextPath()+"/pages/user/login_success.jsp");
		}
	}
	//ע�᷽��
	protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	/*	String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");*/
		User user = WEB_Utils.param2bean(request, new User());//ʹ�õ�һ�ַ�װ����
		//���û���Ϣ���浽���ݿ���
		boolean b = userService.regist(user);
		if(b){
			//ע��ɹ� ���ص�ע��ɹ�ҳ��  ����·���ض���
			response.sendRedirect(request.getContextPath()+"/pages/user/regist_success.jsp");
		}
		else{
			//ע��ʧ�� �ٴη��ص�ע��ҳ�� ����ע�� ����·��ת�� ������ע��ʧ����Ϣ
			request.setAttribute("msg", "ע��ʧ��");
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);;
		}
	}
	//�ǳ�����
	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
      HttpSession session = request.getSession();
      //����session����
      session.invalidate();
      //����ǳ��󷵻���ҳ
      response.sendRedirect(request.getContextPath()+"/index.jsp");
	}
}
