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
    //显示图书分页信息 后端管理员
	public void page(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    //System.out.println("显示图书分页信息");
	    //用户点击图书管理显示部分数据 而且页码应该是用户传进来的(应该是动态显示的) 
	    String pn = request.getParameter("pn");
	    Page<Book> page = bookService.getPage(pn, "4");
	    page.setUrl("Manager/BookManagerServlet?method=page");
		request.setAttribute("page", page);
		/*request.setAttribute("page", page2);*/
		//交给页面
		request.getRequestDispatcher("/pages/manager/book_manager.jsp")
		.forward(request, response);
	}
    //显示所有的图书信息 这个显示所有图书列表方法也没用了 现在是用分页page进行显示
	public void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//查出数据并显示
		List<Book> list = bookService.getAll();
        //图书查出后交给页面显示   book_manager.jsp
		request.setAttribute("list", list);
		//交给页面
		request.getRequestDispatcher("/pages/manager/book_manager.jsp")
		.forward(request, response);
	}
	//添加一本图书 这个方法应该是没有用了  处理逻辑都在下面的update方法中
	public void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//在还未获取数据之前解决乱码?(这里是第一次获取数据吗)
		//request.setCharacterEncoding("utf-8");
		//1.将提交的图书信息封装为book对象 (表单的name和对象的属性一一对应)
		//System.out.println("这里是添加图书的方法");
		Book book = WEB_Utils.param2bean(request, new Book());
		//System.out.println(book);
		//2.将一本图书保存到数据库
		boolean b = bookService.add(book);
		//3保存成功，显示图书列表页面 http://localhost:8080//BookStoreEE/Manager/BookManagerServlet?method=list
		//解耦
		response.sendRedirect(request.getContextPath()+"/Manager/BookManagerServlet?method=page");
	
	}
	//删除一本书
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pn = request.getParameter("pn");
		System.out.println("当前页码"+pn);
		//分页下的其他请求方式   Referer是Http协议中请求头里的,是指我从哪里来(代表的是上一次请求)
		String referstring = request.getHeader("Referer");
		//封装要删除的book(这里是根据id进行删除的  封装对象的属性只有id,其余属性默认为null)
		Book book = WEB_Utils.param2bean(request, new Book());
		//System.out.println(book);
		//调用删除方法 并返回到图书列表页面
		bookService.delete(book);
		/*response.sendRedirect(request.getContextPath()+"/Manager/BookManagerServlet?method=page&pn="+pn);*/
		response.sendRedirect(referstring);
	
	}
	//查出某本图书的信息并显示到页面book_edit.jsp
	public void getBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	 //查出某本图书(按照其id进行查询) 然后进行封装
		String pn = request.getParameter("pn");
		System.out.println("当前页码："+pn);
	Book book = WEB_Utils.param2bean(request, new Book());
	System.out.println(book);
	//获取该本书的详细信息
	Book one = bookService.getOne(book);
	//回到编辑页面进行显示 
	//将该本书的详细存入到request域中
	request.setAttribute("book", one);
	//进行转发页面
	request.getRequestDispatcher("/pages/manager/book_edit.jsp")
	.forward(request, response);
	
	}
	//更新某本图书的信息(当需要修改的某本图书信息显示到 book_edit.jsp之后 对其信息进行修改)
	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    //
		//System.out.println("这里是update以及add方法哈");
		//这是修改的当前页号
		String pn = request.getParameter("pn");
		//封装修改后图书的信息
		Book book = WEB_Utils.param2bean(request, new Book());
		System.out.println(book);
		/*//修改图书
		bookService.update(book);
		System.out.println(book);
		//返回列表页面
		response.sendRedirect(request.getContextPath()+"/Manager/BookManagerServlet?method=list");*/
		/**
		 * 改进的方法：由于添加和修改操作封装出的book对象 Id有差异,所以可以直接通过
		 * id进行判断操作是添加(id==0)还是修改(id!=0)
		 */
		if(book.getId()==0){
			//添加图书信息
			bookService.add(book);
		}
		else{
			//修改图书信息
			bookService.update(book);	
		}
		response.sendRedirect(request.getContextPath()+"/Manager/BookManagerServlet?method=page&pn="+pn);
	}
	

	
}
