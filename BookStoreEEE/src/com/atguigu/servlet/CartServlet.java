package com.atguigu.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atguigu.bean.Book;
import com.atguigu.bean.Cart;
import com.atguigu.utils.WEB_Utils;

public class CartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	public void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("�����ǹ��ﳵ�ķ���");
	Book book = WEB_Utils.param2bean(request, new Book());
		//���ﳵ���������� Cart ��session��
	HttpSession session = request.getSession();
	System.out.println("JSESSIONID:"+session.getId());
	Cart cart = (Cart) session.getAttribute("cart");
	//��֪��Ϊɶ���cart��Զ�ǿ�
	if(cart==null){
		System.out.println("session�й��ﳵΪ�գ�--->"+cart);
		//��session�й��ﳵΪ��
		//��session�з��빺�ﳵ
		 cart = new Cart();
		session.setAttribute("cart", cart);
		session.setAttribute("title",book.getTitle());
		System.out.println("�Ѿ���cart���浽session����:"+cart);
		System.out.println("�Ѿ����������浽session����:"+book.getTitle());
		
	}
	cart.addBook2Cart(book);
	session.setAttribute("title",book.getTitle());
	String refer =request.getHeader("referer");
	response.sendRedirect(refer);

	}


}
