package com.atguigu.test;
import org.junit.Test;
import com.atguigu.bean.Book;
import com.atguigu.bean.Cart;

public class CartTest {
	Book book1 = new Book(1,"���μ�1","",23.02,100,100,"");
	Book book2 = new Book(2,"���μ�2","",24.05,100,100,"");
	Book book3 = new Book(3,"���μ�3","",25,100,100,"");
	Book book4 = new Book(4,"���μ�4","",26,100,100,"");
	Book book5 = new Book(5,"���μ�5","",27,100,100,"");
	@Test
	public void test1(){
		Cart cart=new Cart();
		cart.addBook2Cart(book1);
		cart.addBook2Cart(book1);
		cart.addBook2Cart(book2);
		System.out.println("��ǰ�ܼ�"+cart.getTotalCount()+"����");
		System.out.println("��ǰ�ܼ�"+cart.getTotalMoney());
		System.out.println("��ǰ���ﳵ�е���Ŀ"+cart.getAllItems());
		
/*		System.out.println("ɾ��֮��");
		cart.deleteItem(book1.getId().toString());
		System.out.println("��ǰ�ܼ�"+cart.getTotalCount()+"����");
		System.out.println("��ǰ�ܼ�"+cart.getTotalMoney());
		System.out.println("��ǰ���ﳵ�е���Ŀ"+cart.getAllItems());*/
		
		System.out.println("�޸�֮��");
		cart.updateCount(book2.getId().toString(), 3);
		System.out.println("��ǰ�ܼ�"+cart.getTotalCount()+"����");
		System.out.println("��ǰ�ܼ�"+cart.getTotalMoney());
		System.out.println("��ǰ���ﳵ�е���Ŀ"+cart.getAllItems());
		
	}

}
