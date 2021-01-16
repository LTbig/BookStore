package com.atguigu.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/*
 * ����ÿһ��������
 */
public class CartItem implements Serializable {
	//����ǰ����ı�ͼ��
	private Book book;
	//�����������
	private int count;
	//�����ܽ��
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
	//�����ܽ��
	public double getTotalPrice() {
		//����ȡ���ļ۸�ʹ��BigDecimal ���а�װ
		BigDecimal price = new BigDecimal(getBook().getPrice()+"");
		BigDecimal count = new BigDecimal(getCount());
		BigDecimal multiply= price.multiply(count);
		//ʹ��multiply.doubleValue()������ת��Ϊdouble����
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
