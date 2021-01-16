package com.atguigu.bean;

import java.io.Serializable;
import java.util.List;

//分页模型 使用泛型
public class Page<T> implements Serializable {
    //当前是第几页   用户参数传入
	private int pageNo;
	//总页数   计算得到
	private int totalPage;
	//总记录数  查询得到的 设置进入
	private int totalCount;
	//每页显示的条数,告诉数据库一次查四条记录
	private int pageSize=4;
	//告诉数据库从哪个索引开始查询 计算得到的
	private int index;
	//是否有下一页 判断得到的
	private boolean hasNext;
	//是否有上一页 判断得到的
	private boolean hasPrev;
	//封装查询出来的分页数据  查询出来设置进去的
	private List<T> pageData;
	//封装动态的url
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
		//这里直接判断的好处是底层调用bean也能成功  但有的时候程序员不会去看这个
		//当请求的页数大于总页数时返回最后一页
		pageNo=pageNo>getTotalPage()?getTotalPage():pageNo;
		//请求的页数小于1时返回第一页
		pageNo=pageNo>0?pageNo:1;
		this.pageNo = pageNo;
	}
	//获取总页数
	public int getTotalPage() {
		//计算实际的totalPage
		//10 4 3(向上取整)
		//总记录数除以每页条数
		int totalPage=getTotalCount()/getPageSize();
		//如果不能整除
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
	//计算得出索引值
	public int getIndex() {
		//每页显示4条
		/**页码号  开始索引 结束索引
		 * 1      0      3
		 * 2      4      7
		 * 3      8      11
		 * 即开始索引index=(pageNo-1)*pageSize
		 */
		int index=(getPageNo()-1)*getPageSize();
		if(index<0){
			index=0;
		}
		return index;
	}
	
/*	为了数据的安全 不能设置  只能获取
 * public void setIndex(int index) {
		this.index = index;
	}*/
	//判断是否有下一条
	public boolean isHasNext() {
		//当前页数小于总页数说明有下一页
		return getPageNo()<getTotalPage();
	}
	/*public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}*/
	//判断是否有上一条
	public boolean isHasPrev() {
		//当前页数大于1 说明有上一页
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
