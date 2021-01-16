package com.atguigu.DaoImp;
import java.util.List;
import com.atguigu.Dao.Base_Dao;
import com.atguigu.Dao.BookDao;
import com.atguigu.bean.Book;

public class BookDaoImp extends Base_Dao<Book> implements BookDao {

	@Override
	public List<Book> getAllBook() {
		// img_path ������*ֱ��ȡ��
		String sql ="select id,title,author,price,sales,stock,img_path as imgPath from bs_book";
		//�������е�ͼ��
		return  getBeanList(sql);
	}
	//���һ��ͼ��
	@Override
	public boolean addBook(Book book) {
		String sql="insert into bs_Book(title,author,price,sales,stock,img_path)"
				+ "value(?,?,?,?,?,?)";
		int update = this.update(sql,book.getTitle(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath());
		return update>0;
	}
  //ɾ��һ��ͼ��
	@Override
	public boolean delBook(Book book) {
	    String sql="delete from  bs_Book where id=?";
	    int update = this.update(sql, book.getId());
		return update>0;
	}
  //����һ��ͼ�� 
	@Override
	public boolean updateBook(Book book) {
		//����ʮ����� �ҵ�sql����ڲ����������ܱ���ͨ���ɹ����и���
		//�����������ڷ������Ϻ� ���sql���Ͳ��ܹ���ȷ��ִ��
		//Ȼ���Ұ�sql����е�where��ǰ����ʺſճ�һ���ո�� ������ȷִ����
		String sql="update bs_Book set title=?,author=?,price=?,sales=?,stock=?,img_path=? where id=? ";
		int update = this.update(sql,book.getTitle(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath(),book.getId());
		System.out.println(update);
		return update>0;
	}
 //��ȡһ��ͼ��
	@Override
	public Book getBook(Book book) {
		String sql ="select id,title,author,price,sales,stock,img_path as imgPath from bs_book "
				+ "where id=?";
		return getBean(sql,book.getId());
	
	}
  //��ҳ����ͼ��
	@Override
		public List<Book> getPageList(int index, int pageSize) {
			// TODO Auto-generated method stub
			String sql ="select id,title,author,price,sales,stock,img_path as imgPath from bs_book limit ?,?";
			return getBeanList(sql, index,pageSize);
		}
	//��ҳ����ͼ��  ǰ���䰴����Ϊ��С�۸�����۸�֮���ѯ
	@Override
	public List<Book> getPageListByPrice(int index, int pageSize,double minPrice,double maxPrice) {
		// TODO Auto-generated method stub
		String sql ="select id,title,author,price,sales,stock,img_path as imgPath from bs_book where price between ? and ? limit ?,?";
		return getBeanList(sql, minPrice, maxPrice, index, pageSize);
	}
	//��˻�ȡͼ���ܼ�¼��
	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		String sql="select count(*) from bs_book";
		Object object = getSingleValue(sql);
		//��ת���쳣ʱĬ��0��
		int parseInt=0;
		try {
			parseInt = Integer.parseInt(object.toString());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return parseInt;
	}
	//ǰ�˻�ȡ�۸������ͼ���¼��
	@Override
	public int getTotalCountByPrice(double minPrice, double maxPrice) {
		// TODO Auto-generated method stub
		String sql="select count(*) from bs_book where price between ? and ?";
		Object object = getSingleValue(sql,minPrice,maxPrice);
				//��ת���쳣ʱĬ��0��
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
