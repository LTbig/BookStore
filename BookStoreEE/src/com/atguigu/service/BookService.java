package com.atguigu.service;

import java.util.List;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;

public interface BookService {
	//添加图书
	public boolean add(Book book);
	//修改图书
	public boolean update(Book book);
	//删除图书
	public boolean delete(Book book);
	//获取一本图书
	public Book getOne(Book book);
	//获取所有图书
	public List<Book> getAll();
	//获取一页图书信息 返回分页数据
	public Page<Book> getPage(String pageNo,String pageSize);
	//前端获取一页图书信息  按其价格查询
	public Page<Book> getPageByPrice(String pageNo, String pageSize,String minPrice,String maxPrice);

}
