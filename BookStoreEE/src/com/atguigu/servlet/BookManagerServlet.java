package com.atguigu.servlet;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
import com.atguigu.service.BookService;
import com.atguigu.serviceImp.BookServiceImp;
import com.atguigu.utils.WEB_Utils;

public class BookManagerServlet extends BaseServlet {

    private BookService bookService=new BookServiceImp();
    //��ʾͼ���ҳ��Ϣ ��˹���Ա
	public void page(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    //System.out.println("��ʾͼ���ҳ��Ϣ");
	    //�û����ͼ�������ʾ�������� ����ҳ��Ӧ�����û���������(Ӧ���Ƕ�̬��ʾ��) 
	    String pn = request.getParameter("pn");
	    Page<Book> page = bookService.getPage(pn, "4");
	    page.setUrl("Manager/BookManagerServlet?method=page");
		request.setAttribute("page", page);
		/*request.setAttribute("page", page2);*/
		//����ҳ��
		request.getRequestDispatcher("/pages/manager/book_manager.jsp")
		.forward(request, response);
	}
    //��ʾ���е�ͼ����Ϣ �����ʾ����ͼ���б���Ҳû���� �������÷�ҳpage������ʾ
	public void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//������ݲ���ʾ
		List<Book> list = bookService.getAll();
        //ͼ�����󽻸�ҳ����ʾ   book_manager.jsp
		request.setAttribute("list", list);
		//����ҳ��
		request.getRequestDispatcher("/pages/manager/book_manager.jsp")
		.forward(request, response);
	}
	//���һ��ͼ�� �������Ӧ����û������  �����߼����������update������
	public void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�ڻ�δ��ȡ����֮ǰ�������?(�����ǵ�һ�λ�ȡ������)
		//request.setCharacterEncoding("utf-8");
		//1.���ύ��ͼ����Ϣ��װΪbook���� (����name�Ͷ��������һһ��Ӧ)
		//System.out.println("���������ͼ��ķ���");
		Book book = WEB_Utils.param2bean(request, new Book());
		//System.out.println(book);
		//2.��һ��ͼ�鱣�浽���ݿ�
		boolean b = bookService.add(book);
		//3����ɹ�����ʾͼ���б�ҳ�� http://localhost:8080//BookStoreEE/Manager/BookManagerServlet?method=list
		//����
		response.sendRedirect(request.getContextPath()+"/Manager/BookManagerServlet?method=page");
	
	}
	//ɾ��һ����
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pn = request.getParameter("pn");
		System.out.println("��ǰҳ��"+pn);
		//��ҳ�µ���������ʽ   Referer��HttpЭ��������ͷ���,��ָ�Ҵ�������(���������һ������)
		String referstring = request.getHeader("Referer");
		//��װҪɾ����book(�����Ǹ���id����ɾ����  ��װ���������ֻ��id,��������Ĭ��Ϊnull)
		Book book = WEB_Utils.param2bean(request, new Book());
		//System.out.println(book);
		//����ɾ������ �����ص�ͼ���б�ҳ��
		bookService.delete(book);
		/*response.sendRedirect(request.getContextPath()+"/Manager/BookManagerServlet?method=page&pn="+pn);*/
		response.sendRedirect(referstring);
	
	}
	//���ĳ��ͼ�����Ϣ����ʾ��ҳ��book_edit.jsp
	public void getBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	 //���ĳ��ͼ��(������id���в�ѯ) Ȼ����з�װ
		String pn = request.getParameter("pn");
		System.out.println("��ǰҳ�룺"+pn);
	Book book = WEB_Utils.param2bean(request, new Book());
	System.out.println(book);
	//��ȡ�ñ������ϸ��Ϣ
	Book one = bookService.getOne(book);
	//�ص��༭ҳ�������ʾ 
	//���ñ������ϸ���뵽request����
	request.setAttribute("book", one);
	//����ת��ҳ��
	request.getRequestDispatcher("/pages/manager/book_edit.jsp")
	.forward(request, response);
	
	}
	//����ĳ��ͼ�����Ϣ(����Ҫ�޸ĵ�ĳ��ͼ����Ϣ��ʾ�� book_edit.jsp֮�� ������Ϣ�����޸�)
	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    //
		//System.out.println("������update�Լ�add������");
		//�����޸ĵĵ�ǰҳ��
		String pn = request.getParameter("pn");
		//��װ�޸ĺ�ͼ�����Ϣ
		Book book = WEB_Utils.param2bean(request, new Book());
		System.out.println(book);
		/*//�޸�ͼ��
		bookService.update(book);
		System.out.println(book);
		//�����б�ҳ��
		response.sendRedirect(request.getContextPath()+"/Manager/BookManagerServlet?method=list");*/
		/**
		 * �Ľ��ķ�����������Ӻ��޸Ĳ�����װ����book���� Id�в���,���Կ���ֱ��ͨ��
		 * id�����жϲ��������(id==0)�����޸�(id!=0)
		 */
		if(book.getId()==0){
			//���ͼ����Ϣ
			bookService.add(book);
		}
		else{
			//�޸�ͼ����Ϣ
			bookService.update(book);	
		}
		response.sendRedirect(request.getContextPath()+"/Manager/BookManagerServlet?method=page&pn="+pn);
	}
	

	
}
