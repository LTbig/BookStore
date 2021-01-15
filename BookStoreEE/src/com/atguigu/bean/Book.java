package com.atguigu.bean;

public class Book {
	//id
	private Integer id;
	//书名
	private String title;
	//作者
	private String author;
	//书价
	private double price;
	//销量
	private Integer sales;
	//库存
	private Integer stock;
	//图片的封面路径，可以指定默认路径(相对于项目的相对路径)
	private String imgPath="static/img/default.jpg";
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Integer getSales() {
		return sales;
	}
	public void setSales(Integer sales) {
		this.sales = sales;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
		
	}
	public Book(Integer id, String title, String author, double price,
			Integer sales, Integer stock, String imgPath) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.sales = sales;
		this.stock = stock;
		//传入值null 则按默认值保存
		if(imgPath!=null)
			this.imgPath = imgPath;
			
	}
	public Book() {
		super();
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author
				+ ", price=" + price + ", sales=" + sales + ", stock=" + stock
				+ ", imgPath=" + imgPath + "]";
	}
	

}
