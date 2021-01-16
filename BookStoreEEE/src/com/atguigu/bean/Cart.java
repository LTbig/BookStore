package com.atguigu.bean;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/**
 * 购物车 保存每一个购物项的东西  还封装了对每一个购物车的方法
 * @author lt
 *
 */
public class Cart implements Serializable {
	/**
	 * 保存的每一个购物项 使用hashmap
	 */
	private Map<Integer,CartItem> items = new LinkedHashMap<>();
/*	//总商品数
	private int totalCount;
	//总商品金额
	private double totalMoney;*/
	
	public Map<Integer, CartItem> getItems() {
		return items;
	}
	public int getTotalCount() {
		//获取购物车中的所有商品
		List<CartItem> list = getAllItems();
		int count=0;
		for(CartItem cartItem : list){
			count +=cartItem.getCount();
		}
		return count;
	}

	public double getTotalMoney() {
		//获取购物车中的所有商品
		List<CartItem> list = getAllItems();
		BigDecimal money= new BigDecimal(0.0+"");
		for(CartItem cartItem : list){
			//将每一项的总金额加起来
			//money +=cartItem.getTotalPrice();
		BigDecimal totalPrice = new BigDecimal(cartItem.getTotalPrice());
		money = money.add(totalPrice);
		} 
		return money.doubleValue();
	}

	//返回所有的购物项
	public List<CartItem> getAllItems(){
		//返回map中的所有值
		Collection<CartItem> values =items.values();
		return new  ArrayList<>(values);
	}
	/**
	 * 定义操作购物车的其他方法
	 * @return
	 */
	//把图书添加到购物车
	public void addBook2Cart(Book book){
	   //判断是否有当前图书 ，有则数量加1
		CartItem item = items.get(book.getId());
		if(item==null){
			//没有当前的购物项  则是第一次添加 设置count为1
			CartItem cartItem =new CartItem();
			cartItem.setBook(book);
			cartItem.setCount(1);
			//将购物项加入购物车
			items.put(book.getId(),cartItem);
		}else{
			//将购物项的count+1
			item.setCount(item.getCount()+1);	
		}
	}	
	//从购物车中删除某一项
	public void deleteItem(String bookid) {
		   int id = Integer.parseInt(bookid);
		   items.remove(id);	
	}
	//修改数量  bookid:修改的条目  count:修改的数量
	public void updateCount(String bookid, int count){
		 int id = Integer.parseInt(bookid);
		 //根据id找到其中的购物项
		 CartItem cartItem=items.get(id);
		 cartItem.setCount(count);	
	}
	//清空购物车
	public void clear(){
		items.clear();
	}
}
