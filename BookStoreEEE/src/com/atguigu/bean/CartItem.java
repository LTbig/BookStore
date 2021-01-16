package com.atguigu.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/*
 * 保存每一个购物项
 */
public class CartItem implements Serializable {
	//代表当前买的哪本图书
	private Book book;
	//代表购买的数量
	private int count;
	//代表总金额
	private double totalPrice;
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	//计算总金额
	public double getTotalPrice() {
		//将获取到的价格使用BigDecimal 进行包装
		BigDecimal price = new BigDecimal(getBook().getPrice()+"");
		BigDecimal count = new BigDecimal(getCount());
		BigDecimal multiply= price.multiply(count);
		//使用multiply.doubleValue()将数据转换为double类型
		return  multiply.doubleValue();
	}

	public CartItem(Book book, int count, double totalPrice) {
		super();
		this.book = book;
		this.count = count;
		this.totalPrice = totalPrice;
	}
	public CartItem() {
		super();
	}
	@Override
	public String toString() {
		return "CartItem [book=" + book + ", count=" + count + ", totalPrice="
				+ totalPrice + "]";
	}
	

}
