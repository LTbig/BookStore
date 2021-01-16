package com.atguigu.test;
import org.junit.Test;
import com.atguigu.bean.Book;
import com.atguigu.bean.Cart;

public class CartTest {
	Book book1 = new Book(1,"西游记1","",23.02,100,100,"");
	Book book2 = new Book(2,"西游记2","",24.05,100,100,"");
	Book book3 = new Book(3,"西游记3","",25,100,100,"");
	Book book4 = new Book(4,"西游记4","",26,100,100,"");
	Book book5 = new Book(5,"西游记5","",27,100,100,"");
	@Test
	public void test1(){
		Cart cart=new Cart();
		cart.addBook2Cart(book1);
		cart.addBook2Cart(book1);
		cart.addBook2Cart(book2);
		System.out.println("当前总计"+cart.getTotalCount()+"本书");
		System.out.println("当前总价"+cart.getTotalMoney());
		System.out.println("当前购物车中的项目"+cart.getAllItems());
		
/*		System.out.println("删除之后");
		cart.deleteItem(book1.getId().toString());
		System.out.println("当前总计"+cart.getTotalCount()+"本书");
		System.out.println("当前总价"+cart.getTotalMoney());
		System.out.println("当前购物车中的项目"+cart.getAllItems());*/
		
		System.out.println("修改之后");
		cart.updateCount(book2.getId().toString(), 3);
		System.out.println("当前总计"+cart.getTotalCount()+"本书");
		System.out.println("当前总价"+cart.getTotalMoney());
		System.out.println("当前购物车中的项目"+cart.getAllItems());
		
	}

}
