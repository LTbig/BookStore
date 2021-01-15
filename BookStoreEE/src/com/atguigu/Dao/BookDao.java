package com.atguigu.Dao;

import java.util.List;

import com.atguigu.bean.Book;

public interface BookDao {
	//��ʾ����ͼ��
	public List<Book> getAllBook();
	//���һ��ͼ��
	public boolean addBook(Book book);
	//ɾ��һ��ͼ��
	public boolean delBook(Book book);
	//�޸�һ��ͼ�� book���޸ĺ������(�ύһ����Ҫ�޸�ͼ������� Ȼ���װ������)
	public boolean updateBook(Book book);
	//��ȡһ��ͼ��(����ͼ���Id����ͼ��)
	public Book getBook(Book book);
	//��ҳ����ͼ�� 
	public List<Book> getPageList(int index, int pageSize);
	//��ҳ����ͼ��   �䰴����Ϊ��С�۸�����۸�֮���ѯ
	public List<Book> getPageListByPrice(int index,int pageSize,double minPrice,double maxPrice );
	//��ȡ����ͼ����ܼ�¼��
	public int getTotalCount();
	//��ȡ�۸������ͼ��ļ�¼��
	public int getTotalCountByPrice(double minPrice,double maxPrice );

}
