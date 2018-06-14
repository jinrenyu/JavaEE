package com.tz.online.service;

import java.util.Map;

import com.tz.online.entity.OrderItem;

public interface IShoppingCart {

	//添加到购物车
	public void addCart(OrderItem item);
	//清空购物车
	public void cleanCrat();
	//修改数量
	public void modityCount(Long bookId,int count);
	//删除某个条目
	public void delete(Long bookId);
	//获取总价
	public double getTotal();
	//获取商品数量
	public int getCount();
	//获取购物车数据
	public Map<Long,OrderItem> getItems();
	//获取购物车的商品详情
	public OrderItem find(Long bookId);
	
	
}
