package com.tz.online.service.impl;

import java.util.HashMap;
import java.util.Map;
import com.tz.online.dao.IBookDao;
import com.tz.online.entity.Book;
import com.tz.online.entity.OrderItem;
import com.tz.online.service.IShoppingCart;
import com.tz.online.util.BeanFactory;

public class MemoryCart implements IShoppingCart {

	private double total;//总费用
	private int count ; //商品总数量
	IBookDao bookDao = (IBookDao) BeanFactory.createBeans("bookDao");
	
	private Map<Long, OrderItem> items = new HashMap<>();

	public MemoryCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public void setTotal(double total) {
		this.total = total;
	}


	public void setCount(int count) {
		this.count = count;
	}

	public void setItems(Map<Long, OrderItem> items) {
		this.items = items;
	}

	@Override
	public void addCart(OrderItem item) {
		//long l = items.size();
		
		items.put(item.getBook().getBookId(), item);
		
	}

	@Override
	public void cleanCrat() {
		
		items=null;
		total=0;
		count=0;

	}

	@Override
	public void modityCount(Long bookId, int count) {
		Book book = bookDao.findById(bookId);
		for(Map.Entry<Long, OrderItem> entry : items.entrySet() ){
			if(entry.getValue().getBook().equals(book)){
				entry.getValue().setCount(count);
			}
		}
			
		

	}

	@Override
	public void delete(Long bookId) {
		//Book book = bookDao.findById(bookId);
		for(Map.Entry<Long, OrderItem> entry : items.entrySet()){
			if(entry.getValue().getBook().getBookId().equals(bookId)){
				items.remove(entry.getValue().getBook().getBookId());
			}
		}
			
		

	}

	@Override
	public double getTotal() {
		 total = 0;
		for(Map.Entry<Long, OrderItem> entry : items.entrySet()){
			total+=entry.getValue().getAllPrice();
		}
		return total;
	}

	@Override
	public int getCount() {
		 count = 0;
		for(Map.Entry<Long, OrderItem> entry : items.entrySet()){
			count+=entry.getValue().getCount();
		}
		return count;
	}

	@Override
	public Map<Long, OrderItem> getItems() {
		Map<Long , OrderItem> map = new HashMap<>();
		for(Map.Entry<Long, OrderItem> entry : items.entrySet()){
			map.put(entry.getKey(), entry.getValue());
		}
		return map;
	}

	@Override
	public OrderItem find(Long bookId) {
		Book book = bookDao.findById(bookId);
		OrderItem orderItem = new OrderItem();
		for(Map.Entry<Long, OrderItem> entry : items.entrySet()){
			if(entry.getValue().getBook().equals(book)){
				orderItem=entry.getValue();
			}
		}
		
		return orderItem;
	}

}
