package com.tz.online.service;

import com.tz.online.entity.Order;
import com.tz.online.entity.PageBean;
import com.tz.online.entity.User;

public interface IOrderService {
	
	//保存订单对象
	public void save(Order o);
	
	//删除订单
	public void delete(Order o);
	//安主键chaxun
	public Order findById(Long id);
	
	//根据用户查询订单
	
	public PageBean<Order> queryByPage(User user,int row,int size);
}
