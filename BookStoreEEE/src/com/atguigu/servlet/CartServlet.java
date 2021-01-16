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
		System.out.println("这里是购物车的方法");
	Book book = WEB_Utils.param2bean(request, new Book());
		//购物车的整个内容 Cart 在session中
	HttpSession session = request.getSession();
	System.out.println("JSESSIONID:"+session.getId());
	Cart cart = (Cart) session.getAttribute("cart");
	//不知道为啥这个cart永远是空
	if(cart==null){
		System.out.println("session中购物车为空：--->"+cart);
		//若session中购物车为空
		//给session中放入购物车
		 cart = new Cart();
		session.setAttribute("cart", cart);
		session.setAttribute("title",book.getTitle());
		System.out.println("已经将cart保存到session中了:"+cart);
		System.out.println("已经将书名保存到session中了:"+book.getTitle());
		
	}
	cart.addBook2Cart(book);
	session.setAttribute("title",book.getTitle());
	String refer =request.getHeader("referer");
	response.sendRedirect(refer);

	}


}
