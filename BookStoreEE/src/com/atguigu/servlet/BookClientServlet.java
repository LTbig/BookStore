package com.atguigu.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
import com.atguigu.service.BookService;
import com.atguigu.serviceImp.BookServiceImp;

public class BookClientServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	BookService bookService=new BookServiceImp();
   /**
    * 给前端用户展示图书分页数据
    */
	public void page(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 //System.out.println("显示图书分页信息");
	    //用户点击图书管理显示部分数据 而且页码应该是用户传进来的(应该是动态显示的) 
	    String pn = request.getParameter("pn");
	    Page<Book> page = bookService.getPage(pn, "4");
	    page.setUrl("Client/BookClientServlet?method=page");
		request.setAttribute("page", page);
		/*request.setAttribute("page", page2);*/
		//交给页面
		request.getRequestDispatcher("/pages/book/booklist.jsp")
		.forward(request, response);

	}
	   /**
	    * 给前端用户展示图书分页数据 按照其价格
	    */
	public void pageByPrice(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取价格区间
		 String min = request.getParameter("min");
		 String max = request.getParameter("max");
		 String pn=request.getParameter("pn");
		 //查询价格区间的所有图书
		 Page<Book> page = bookService.getPageByPrice(pn, "4", min, max);
		 //返回页面显示
		 page.setUrl("Client/BookClientServlet?method=pageByPrice&min="+min+"&max="+max);
		 request.setAttribute("page", page);
		 request.getRequestDispatcher("/pages/book/booklist.jsp").forward(request, response);
	}




}
