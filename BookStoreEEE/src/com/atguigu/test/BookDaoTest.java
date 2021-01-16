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
	//��ʾ����ͼ��
	@Test
	public void test(){
		//List<Book> list = bd.getAllBook();
		System.out.println("��ʾ����ͼ��"+bd.getAllBook());
	}
	//���һ��ͼ��
	@Test
	public void test2(){
		//����һ��ͼ��
		Book book = new Book(null,"c++����2","����",50.5,0,300,null);
		boolean b = bd.addBook(book);
		System.out.println(b);
	
	}
	//ɾ��һ��ͼ��
		@Test
		public void test3(){
			Book book = new Book();
		    book.setId(6);
		    boolean b = bd.delBook(book);
			System.out.println(b);
		
		}
	//����һ��ͼ��
		@Test
		public void test4(){
		//����һ������Id�����޸ĵ�ͼ��
	    Book book = new Book(2,"����","��Ұ����",51.5,0,300,null);
        boolean b = bd.updateBook(book);
		System.out.println(b);
	}
	//��ȡһ��ͼ��
		@Test
		public void test5(){
		//����Id��ȡһ��ͼ��
	    Book book = new Book();
	    book.setId(3);
        Book b = bd.getBook(book);
		System.out.println(b);
	}
	//��˻�ȡ��ҳ����
    @Test
	public void test6(){
    	BookService bookService=new BookServiceImp();
    	Page<Book> page = bookService.getPage("4", "4");
    	System.out.println("ͼ���ҳ���ݣ�"+page.getPageData());
    	System.out.println("ҳ�ţ�"+page.getPageNo());
    	System.out.println("��ҳ��С��"+page.getPageSize());
    	System.out.println("�ܼ�¼����"+page.getTotalCount());
    	System.out.println("��ҳ����"+page.getTotalPage());
    }
	//ǰ�˻�ȡ��ҳ���� ���Ұ��۸���в�ѯ
    @Test
	public void test7(){
    	BookService bookService=new BookServiceImp();
    	//����ķ�ҳ�ǰ��ռ۸��ҳ��(�Ȳ������۸�ļ�¼  Ȼ���ظ��ݷ�ҳ�������з�ҳ)
    	Page<Book> page = bookService.getPageByPrice("1", "4", "30", "50");
     	System.out.println("ͼ���ҳ���ݣ�"+page.getPageData());
    	System.out.println("ҳ�ţ�"+page.getPageNo());
    	System.out.println("��ҳ��С��"+page.getPageSize());
    	System.out.println("�ܼ�¼����"+page.getTotalCount());
    	System.out.println("��ҳ����"+page.getTotalPage());
    	
    }
}
