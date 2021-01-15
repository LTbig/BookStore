package com.atguigu.test;
import org.junit.Test;
import com.atguigu.Dao.BookDao;
import com.atguigu.DaoImp.BookDaoImp;
import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
import com.atguigu.service.BookService;
import com.atguigu.serviceImp.BookServiceImp;
public class BookDaoTest {
	BookDao bd=new BookDaoImp();
	//显示所有图书
	@Test
	public void test(){
		//List<Book> list = bd.getAllBook();
		System.out.println("显示所有图书"+bd.getAllBook());
	}
	//添加一本图书
	@Test
	public void test2(){
		//创建一个图书
		Book book = new Book(null,"c++入门2","刘唐",50.5,0,300,null);
		boolean b = bd.addBook(book);
		System.out.println(b);
	
	}
	//删除一本图书
		@Test
		public void test3(){
			Book book = new Book();
		    book.setId(6);
		    boolean b = bd.delBook(book);
			System.out.println(b);
		
		}
	//更新一本图书
		@Test
		public void test4(){
		//创建一本根据Id进行修改的图书
	    Book book = new Book(2,"恶意","东野圭吾",51.5,0,300,null);
        boolean b = bd.updateBook(book);
		System.out.println(b);
	}
	//获取一本图书
		@Test
		public void test5(){
		//根据Id获取一本图书
	    Book book = new Book();
	    book.setId(3);
        Book b = bd.getBook(book);
		System.out.println(b);
	}
	//后端获取分页数据
    @Test
	public void test6(){
    	BookService bookService=new BookServiceImp();
    	Page<Book> page = bookService.getPage("4", "4");
    	System.out.println("图书分页数据："+page.getPageData());
    	System.out.println("页号："+page.getPageNo());
    	System.out.println("分页大小："+page.getPageSize());
    	System.out.println("总记录数："+page.getTotalCount());
    	System.out.println("总页数："+page.getTotalPage());
    }
	//前端获取分页数据 并且按价格进行查询
    @Test
	public void test7(){
    	BookService bookService=new BookServiceImp();
    	//这里的分页是按照价格分页的(先查出满足价格的记录  然后载根据分页条件进行分页)
    	Page<Book> page = bookService.getPageByPrice("1", "4", "30", "50");
     	System.out.println("图书分页数据："+page.getPageData());
    	System.out.println("页号："+page.getPageNo());
    	System.out.println("分页大小："+page.getPageSize());
    	System.out.println("总记录数："+page.getTotalCount());
    	System.out.println("总页数："+page.getTotalPage());
    	
    }
}
