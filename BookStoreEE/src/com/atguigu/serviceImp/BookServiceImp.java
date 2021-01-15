package com.atguigu.serviceImp;
import java.util.List;

import com.atguigu.Dao.BookDao;
import com.atguigu.DaoImp.BookDaoImp;
import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
import com.atguigu.service.BookService;
public class BookServiceImp implements BookService {
	private BookDao bookDao=new BookDaoImp();
	//���
	@Override
	public boolean add(Book book) {
		// TODO Auto-generated method stub
		return bookDao.addBook(book);
	}
   //����
	@Override
	public boolean update(Book book) {
		// TODO Auto-generated method stub
		System.out.println("���Ը���");
		System.out.println(bookDao.updateBook(book));
		return bookDao.updateBook(book);
		
	}
   //ɾ��
	@Override
	public boolean delete(Book book) {
		// TODO Auto-generated method stub
		return bookDao.delBook(book);
	}
    //��ȡһ��
	@Override
	public Book getOne(Book book) {
		// TODO Auto-generated method stub
		return bookDao.getBook(book);
	}
    //��ȡ����
	@Override
	public List<Book> getAll() {
		// TODO Auto-generated method stub
		return bookDao.getAllBook();
	}
	//��ȡ��ҳ����
	@Override
	public Page<Book> getPage(String pageNo, String pageSize) {
		// TODO Auto-generated method stub
		//1.���û�����������ȷ�װ����
		Page<Book> page=new Page<Book>();
		//���û����������ת�Ͳ���װ  ������Ĭ��ֵ
		int pn=1;
		int ps=page.getPageSize();
		try {
			pn = Integer.parseInt(pageNo);
			//�߽���� �����������Ƿ������Ա������   �������е�ʱ��ֱ�ӵ��û������
			//�������������������ж���
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
		
		//2.��ΪҪʹ��totalCountҲ���ǵ�ǰ�ܼ�¼�������Ի�Ҫ�����ݿ�
		//����һ��������ҳ���С �ٻ�ȡ�ܼ�¼��(������Ҫ�ȸ���ҳ���С���ܼ�¼������ܵ�ҳ��) 
		//�������ҳ�����(��ҳ����ȥ����ҳ����Ƚ� �ж������ҳ�� �Ƿ�����ҳ�������)
		page.setPageSize(ps);
		int totalCount = bookDao.getTotalCount();//��ȡ�ܼ�¼��
		page.setTotalCount(totalCount);
		page.setPageNo(pn);
		//���õ����ܼ�¼�� ���ý�ȥ
		//3.��ѯ���ݲ���װ
		List<Book> list = bookDao.getPageList(page.getIndex(), page.getPageSize());
		page.setPageData(list);
		return page;
	}
	//��ȡ��ҳ���� ǰ�˰��۸���ʾ
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
		//���û����������ת�Ͳ���װ  ������Ĭ��ֵ
		int pn=1;
		int ps=page.getPageSize();
		try {
			pn = Integer.parseInt(pageNo);
			//�߽���� �����������Ƿ������Ա������   �������е�ʱ��ֱ�ӵ��û������
			//�������������������ж���
			pn=pn>0?pn:1;
			ps = Integer.parseInt(pageSize);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		//��ҳ�뼰ҳ���С���ý���page����
		//���ռ۸������ȡ�ܼ�¼��
		int totalCount = bookDao.getTotalCountByPrice(min, max);//��ȡ�ܼ�¼��(���ռ۸������ȡ)
		page.setTotalCount(totalCount);
		page.setPageSize(ps);
		//���ҳ��Ӧ�����������
		page.setPageNo(pn);
		//��ѯ��Ӧ����
		List<Book> list = bookDao.getPageListByPrice(page.getIndex(), page.getPageSize(), min, max);
		//��װ��page����
		page.setPageData(list);
		return page;
	}


}
