package com.atguigu.serviceImp;
import java.util.List;

import com.atguigu.Dao.BookDao;
import com.atguigu.DaoImp.BookDaoImp;
import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
import com.atguigu.service.BookService;
public class BookServiceImp implements BookService {
	private BookDao bookDao=new BookDaoImp();
	//添加
	@Override
	public boolean add(Book book) {
		// TODO Auto-generated method stub
		return bookDao.addBook(book);
	}
   //更新
	@Override
	public boolean update(Book book) {
		// TODO Auto-generated method stub
		System.out.println("可以更新");
		System.out.println(bookDao.updateBook(book));
		return bookDao.updateBook(book);
		
	}
   //删除
	@Override
	public boolean delete(Book book) {
		// TODO Auto-generated method stub
		return bookDao.delBook(book);
	}
    //获取一本
	@Override
	public Book getOne(Book book) {
		// TODO Auto-generated method stub
		return bookDao.getBook(book);
	}
    //获取所有
	@Override
	public List<Book> getAll() {
		// TODO Auto-generated method stub
		return bookDao.getAllBook();
	}
	//获取分页数据
	@Override
	public Page<Book> getPage(String pageNo, String pageSize) {
		// TODO Auto-generated method stub
		//1.将用户插入的数据先封装部分
		Page<Book> page=new Page<Book>();
		//将用户传入的数据转型并封装  并设置默认值
		int pn=1;
		int ps=page.getPageSize();
		try {
			pn = Integer.parseInt(pageNo);
			//边界测试 在这里设置是方便程序员看代码   但是在有的时候直接调用会出问题
			//所以我在两处都进行判断了
			pn=pn>0?pn:1;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
			try {
				ps = Integer.parseInt(pageSize);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		
		//2.因为要使用totalCount也即是当前总记录数，所以还要查数据库
		//这里一般先设置页面大小 再获取总记录数(这里需要先根据页面大小和总记录数算出总的页数) 
		//最后设置页面号数(让页号数去和总页数相比较 判断请求的页号 是否大过了页面的总数)
		page.setPageSize(ps);
		int totalCount = bookDao.getTotalCount();//获取总记录数
		page.setTotalCount(totalCount);
		page.setPageNo(pn);
		//将得到的总记录数 设置进去
		//3.查询数据并封装
		List<Book> list = bookDao.getPageList(page.getIndex(), page.getPageSize());
		page.setPageData(list);
		return page;
	}
	//获取分页数据 前端按价格显示
	@Override
	public Page<Book> getPageByPrice(String pageNo, String pageSize,String minPrice,String maxPrice) {
        double min=0.0;
        double max=Double.MAX_VALUE;
		try {
			 min = Double.parseDouble(minPrice);
			 max = Double.parseDouble(maxPrice);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		Page<Book> page=new Page<Book>();
		//将用户传入的数据转型并封装  并设置默认值
		int pn=1;
		int ps=page.getPageSize();
		try {
			pn = Integer.parseInt(pageNo);
			//边界测试 在这里设置是方便程序员看代码   但是在有的时候直接调用会出问题
			//所以我在两处都进行判断了
			pn=pn>0?pn:1;
			ps = Integer.parseInt(pageSize);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		//将页码及页面大小设置进入page对象
		//按照价格区间获取总记录数
		int totalCount = bookDao.getTotalCountByPrice(min, max);//获取总记录数(按照价格区间获取)
		page.setTotalCount(totalCount);
		page.setPageSize(ps);
		//这个页号应该是最后设置
		page.setPageNo(pn);
		//查询相应数据
		List<Book> list = bookDao.getPageListByPrice(page.getIndex(), page.getPageSize(), min, max);
		//封装进page对象
		page.setPageData(list);
		return page;
	}


}
