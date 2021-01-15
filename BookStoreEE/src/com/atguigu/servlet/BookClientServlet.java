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
    * ��ǰ���û�չʾͼ���ҳ����
    */
	public void page(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 //System.out.println("��ʾͼ���ҳ��Ϣ");
	    //�û����ͼ�������ʾ�������� ����ҳ��Ӧ�����û���������(Ӧ���Ƕ�̬��ʾ��) 
	    String pn = request.getParameter("pn");
	    Page<Book> page = bookService.getPage(pn, "4");
	    page.setUrl("Client/BookClientServlet?method=page");
		request.setAttribute("page", page);
		/*request.setAttribute("page", page2);*/
		//����ҳ��
		request.getRequestDispatcher("/pages/book/booklist.jsp")
		.forward(request, response);

	}
	   /**
	    * ��ǰ���û�չʾͼ���ҳ���� ������۸�
	    */
	public void pageByPrice(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ȡ�۸�����
		 String min = request.getParameter("min");
		 String max = request.getParameter("max");
		 String pn=request.getParameter("pn");
		 //��ѯ�۸����������ͼ��
		 Page<Book> page = bookService.getPageByPrice(pn, "4", min, max);
		 //����ҳ����ʾ
		 page.setUrl("Client/BookClientServlet?method=pageByPrice&min="+min+"&max="+max);
		 request.setAttribute("page", page);
		 request.getRequestDispatcher("/pages/book/booklist.jsp").forward(request, response);
	}




}
