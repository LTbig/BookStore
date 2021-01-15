package com.atguigu.Dao;

import java.util.List;

import com.atguigu.bean.Book;

public interface BookDao {
	//显示所有图书
	public List<Book> getAllBook();
	//添加一本图书
	public boolean addBook(Book book);
	//删除一本图书
	public boolean delBook(Book book);
	//修改一本图书 book是修改后的样子(提交一个需要修改图书的样子 然后封装传过来)
	public boolean updateBook(Book book);
	//获取一本图书(根据图书的Id查找图书)
	public Book getBook(Book book);
	//分页查找图书 
	public List<Book> getPageList(int index, int pageSize);
	//分页查找图书   其按条件为最小价格和最大价格之间查询
	public List<Book> getPageListByPrice(int index,int pageSize,double minPrice,double maxPrice );
	//获取所有图书的总记录数
	public int getTotalCount();
	//获取价格区间的图书的记录数
	public int getTotalCountByPrice(double minPrice,double maxPrice );

}
