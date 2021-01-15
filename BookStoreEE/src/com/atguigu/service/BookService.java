package com.atguigu.service;

import java.util.List;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;

public interface BookService {
	//���ͼ��
	public boolean add(Book book);
	//�޸�ͼ��
	public boolean update(Book book);
	//ɾ��ͼ��
	public boolean delete(Book book);
	//��ȡһ��ͼ��
	public Book getOne(Book book);
	//��ȡ����ͼ��
	public List<Book> getAll();
	//��ȡһҳͼ����Ϣ ���ط�ҳ����
	public Page<Book> getPage(String pageNo,String pageSize);
	//ǰ�˻�ȡһҳͼ����Ϣ  ����۸��ѯ
	public Page<Book> getPageByPrice(String pageNo, String pageSize,String minPrice,String maxPrice);

}
