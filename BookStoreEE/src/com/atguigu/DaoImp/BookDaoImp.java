package com.atguigu.DaoImp;
import java.util.List;
import com.atguigu.Dao.Base_Dao;
import com.atguigu.Dao.BookDao;
import com.atguigu.bean.Book;

public class BookDaoImp extends Base_Dao<Book> implements BookDao {

	@Override
	public List<Book> getAllBook() {
		// img_path 不能用*直接取出
		String sql ="select id,title,author,price,sales,stock,img_path as imgPath from bs_book";
		//返回所有的图书
		return  getBeanList(sql);
	}
	//添加一本图书
	@Override
	public boolean addBook(Book book) {
		String sql="insert into bs_Book(title,author,price,sales,stock,img_path)"
				+ "value(?,?,?,?,?,?)";
		int update = this.update(sql,book.getTitle(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath());
		return update>0;
	}
  //删除一本图书
	@Override
	public boolean delBook(Book book) {
	    String sql="delete from  bs_Book where id=?";
	    int update = this.update(sql, book.getId());
		return update>0;
	}
  //更新一本图书 
	@Override
	public boolean updateBook(Book book) {
		//这里十分奇怪 我的sql语句在测试类里面能编译通过成功进行更新
		//而当程序跑在服务器上后 这个sql语句就不能够正确的执行
		//然后当我把sql语句中的where和前面的问号空出一个空格后 则能正确执行了
		String sql="update bs_Book set title=?,author=?,price=?,sales=?,stock=?,img_path=? where id=? ";
		int update = this.update(sql,book.getTitle(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath(),book.getId());
		System.out.println(update);
		return update>0;
	}
 //获取一本图书
	@Override
	public Book getBook(Book book) {
		String sql ="select id,title,author,price,sales,stock,img_path as imgPath from bs_book "
				+ "where id=?";
		return getBean(sql,book.getId());
	
	}
  //分页查找图书
	@Override
		public List<Book> getPageList(int index, int pageSize) {
			// TODO Auto-generated method stub
			String sql ="select id,title,author,price,sales,stock,img_path as imgPath from bs_book limit ?,?";
			return getBeanList(sql, index,pageSize);
		}
	//分页查找图书  前端其按条件为最小价格和最大价格之间查询
	@Override
	public List<Book> getPageListByPrice(int index, int pageSize,double minPrice,double maxPrice) {
		// TODO Auto-generated method stub
		String sql ="select id,title,author,price,sales,stock,img_path as imgPath from bs_book where price between ? and ? limit ?,?";
		return getBeanList(sql, minPrice, maxPrice, index, pageSize);
	}
	//后端获取图书总记录数
	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		String sql="select count(*) from bs_book";
		Object object = getSingleValue(sql);
		//当转型异常时默认0条
		int parseInt=0;
		try {
			parseInt = Integer.parseInt(object.toString());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return parseInt;
	}
	//前端获取价格区间的图书记录数
	@Override
	public int getTotalCountByPrice(double minPrice, double maxPrice) {
		// TODO Auto-generated method stub
		String sql="select count(*) from bs_book where price between ? and ?";
		Object object = getSingleValue(sql,minPrice,maxPrice);
				//当转型异常时默认0条
		int parseInt=0;
		try {
			parseInt = Integer.parseInt(object.toString());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return parseInt;
      }
}
