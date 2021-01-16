package com.atguigu.bean;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/**
 * ���ﳵ ����ÿһ��������Ķ���  ����װ�˶�ÿһ�����ﳵ�ķ���
 * @author lt
 *
 */
public class Cart implements Serializable {
	/**
	 * �����ÿһ�������� ʹ��hashmap
	 */
	private Map<Integer,CartItem> items = new LinkedHashMap<>();
/*	//����Ʒ��
	private int totalCount;
	//����Ʒ���
	private double totalMoney;*/
	
	public Map<Integer, CartItem> getItems() {
		return items;
	}
	public int getTotalCount() {
		//��ȡ���ﳵ�е�������Ʒ
		List<CartItem> list = getAllItems();
		int count=0;
		for(CartItem cartItem : list){
			count +=cartItem.getCount();
		}
		return count;
	}

	public double getTotalMoney() {
		//��ȡ���ﳵ�е�������Ʒ
		List<CartItem> list = getAllItems();
		BigDecimal money= new BigDecimal(0.0+"");
		for(CartItem cartItem : list){
			//��ÿһ����ܽ�������
			//money +=cartItem.getTotalPrice();
		BigDecimal totalPrice = new BigDecimal(cartItem.getTotalPrice());
		money = money.add(totalPrice);
		} 
		return money.doubleValue();
	}

	//�������еĹ�����
	public List<CartItem> getAllItems(){
		//����map�е�����ֵ
		Collection<CartItem> values =items.values();
		return new  ArrayList<>(values);
	}
	/**
	 * ����������ﳵ����������
	 * @return
	 */
	//��ͼ����ӵ����ﳵ
	public void addBook2Cart(Book book){
	   //�ж��Ƿ��е�ǰͼ�� ������������1
		CartItem item = items.get(book.getId());
		if(item==null){
			//û�е�ǰ�Ĺ�����  ���ǵ�һ����� ����countΪ1
			CartItem cartItem =new CartItem();
			cartItem.setBook(book);
			cartItem.setCount(1);
			//����������빺�ﳵ
			items.put(book.getId(),cartItem);
		}else{
			//���������count+1
			item.setCount(item.getCount()+1);	
		}
	}	
	//�ӹ��ﳵ��ɾ��ĳһ��
	public void deleteItem(String bookid) {
		   int id = Integer.parseInt(bookid);
		   items.remove(id);	
	}
	//�޸�����  bookid:�޸ĵ���Ŀ  count:�޸ĵ�����
	public void updateCount(String bookid, int count){
		 int id = Integer.parseInt(bookid);
		 //����id�ҵ����еĹ�����
		 CartItem cartItem=items.get(id);
		 cartItem.setCount(count);	
	}
	//��չ��ﳵ
	public void clear(){
		items.clear();
	}
}
