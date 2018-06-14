package com.tz.online.dao;

import java.util.List;

import com.tz.online.entity.Order;
import com.tz.online.entity.User;

public interface IOrderDao {

	//保存订单
	public void save(Order o);
	
	//按主键查询
	public Order findById(Long id);
	
	//删除
	
	public void delete(Order o);
	
	//分页查询订单
	public List<Order> selectByPage(User user,int now,int size);
	
	//获取指定用户的总订单数
	
	public int rowCount(User user);
}
