package com.atguigu.bean;

import java.io.Serializable;
import java.util.List;

//��ҳģ�� ʹ�÷���
public class Page<T> implements Serializable {
    //��ǰ�ǵڼ�ҳ   �û���������
	private int pageNo;
	//��ҳ��   ����õ�
	private int totalPage;
	//�ܼ�¼��  ��ѯ�õ��� ���ý���
	private int totalCount;
	//ÿҳ��ʾ������,�������ݿ�һ�β�������¼
	private int pageSize=4;
	//�������ݿ���ĸ�������ʼ��ѯ ����õ���
	private int index;
	//�Ƿ�����һҳ �жϵõ���
	private boolean hasNext;
	//�Ƿ�����һҳ �жϵõ���
	private boolean hasPrev;
	//��װ��ѯ�����ķ�ҳ����  ��ѯ�������ý�ȥ��
	private List<T> pageData;
	//��װ��̬��url
	private String url;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		//����ֱ���жϵĺô��ǵײ����beanҲ�ܳɹ�  ���е�ʱ�����Ա����ȥ�����
		//�������ҳ��������ҳ��ʱ�������һҳ
		pageNo=pageNo>getTotalPage()?getTotalPage():pageNo;
		//�����ҳ��С��1ʱ���ص�һҳ
		pageNo=pageNo>0?pageNo:1;
		this.pageNo = pageNo;
	}
	//��ȡ��ҳ��
	public int getTotalPage() {
		//����ʵ�ʵ�totalPage
		//10 4 3(����ȡ��)
		//�ܼ�¼������ÿҳ����
		int totalPage=getTotalCount()/getPageSize();
		//�����������
		if(!(getTotalCount()%getPageSize()==0)){
			totalPage=totalPage+1;
		}
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	//����ó�����ֵ
	public int getIndex() {
		//ÿҳ��ʾ4��
		/**ҳ���  ��ʼ���� ��������
		 * 1      0      3
		 * 2      4      7
		 * 3      8      11
		 * ����ʼ����index=(pageNo-1)*pageSize
		 */
		int index=(getPageNo()-1)*getPageSize();
		if(index<0){
			index=0;
		}
		return index;
	}
	
/*	Ϊ�����ݵİ�ȫ ��������  ֻ�ܻ�ȡ
 * public void setIndex(int index) {
		this.index = index;
	}*/
	//�ж��Ƿ�����һ��
	public boolean isHasNext() {
		//��ǰҳ��С����ҳ��˵������һҳ
		return getPageNo()<getTotalPage();
	}
	/*public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}*/
	//�ж��Ƿ�����һ��
	public boolean isHasPrev() {
		//��ǰҳ������1 ˵������һҳ
		return getPageNo()>1;
	}
	/*public void setHasPrev(boolean hasPrev) {
		this.hasPrev = hasPrev;
	}*/
	public List<T> getPageData() {
		return pageData;
	}
	public void setPageData(List<T> pageData) {
		this.pageData = pageData;
	}
	public Page(int pageNo, int totalPage, int totalCount, int pageSize,
			int index, boolean hasNext, boolean hasPrev, List<T> pageData) {
		super();
		this.pageNo = pageNo;
		this.totalPage = totalPage;
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.index = index;
		this.hasNext = hasNext;
		this.hasPrev = hasPrev;
		this.pageData = pageData;
	}
	public Page() {
		super();
	}
	@Override
	public String toString() {
		return "Page [pageNo=" + pageNo + ", totalPage=" + totalPage
				+ ", totalCount=" + totalCount + ", pageSize=" + pageSize
				+ ", index=" + index + ", hasNext=" + hasNext + ", hasPrev="
				+ hasPrev + ", pageData=" + pageData + "]";
	}
	
	
}
