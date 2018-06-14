package com.tz.online.service.impl;

import com.tz.online.dao.IOrderDao;
import com.tz.online.entity.Order;
import com.tz.online.entity.PageBean;
import com.tz.online.entity.User;
import com.tz.online.service.IOrderService;
import com.tz.online.util.BeanFactory;

public class OrderServiceImpl implements IOrderService{

	private IOrderDao iorderDao = (IOrderDao) BeanFactory.createBeans("iorderDao") ;
	@Override
	public void save(Order o) {
		// TODO Auto-generated method stub
		iorderDao.save(o);
	}

	@Override
	public void delete(Order o) {
		// TODO Auto-generated method stub
		iorderDao.delete(o);
	}

	@Override
	public Order findById(Long id) {
		// TODO Auto-generated method stub
		return iorderDao.findById(id);
	}

	@Override
	public PageBean<Order> queryByPage(User user, int row, int size) {
		// TODO Auto-generated method stub
		return (PageBean<Order>) iorderDao.selectByPage(user, row, size);
	}

}
