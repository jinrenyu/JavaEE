package com.tz.online.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.tz.online.dao.IOrderDao;
import com.tz.online.entity.Order;
import com.tz.online.entity.User;
import com.tz.online.util.HibernateTemplates;
import com.tz.online.util.ICallBack;

public class OrderDaoImpl implements IOrderDao{

	@Override
	public void save(Order o) {
		HibernateTemplates.execute(new ICallBack() {
			
			@Override
			public Object execute(Session ses) throws HibernateException {
				ses.save(o);
				return null;
			}
		});
		
	}

	@Override
	public Order findById(Long id) {
		// TODO Auto-generated method stub
		return (Order) HibernateTemplates.execute(new ICallBack() {
			
			@Override
			public Object execute(Session ses) throws HibernateException {
				// TODO Auto-generated method stub
				return ses.get(Order.class, id);
			}
		});
	}

	@Override
	public void delete(Order o) {
		// TODO Auto-generated method stub
		HibernateTemplates.execute(new ICallBack() {
			
			@Override
			public Object execute(Session ses) throws HibernateException {
				ses.delete(o);
				return null;
			}
		});
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> selectByPage(User user, int now, int size) {
		return (List<Order>) HibernateTemplates.execute(new ICallBack() {
			
			@Override
			public Object execute(Session ses) throws HibernateException {
				// TODO Auto-generated method stub
				Criteria cri = ses.createCriteria(Order.class,"o");
				if(null!=user){
					cri.add(Restrictions.eq("o", user));
				}
				return cri.setFirstResult((now-1)*size).setMaxResults(size).list();
			}
		});
	 
	}

	@Override
	public int rowCount(User user) {
		// TODO Auto-generated method stub
		return (int) HibernateTemplates.execute(new ICallBack() {
			
			@Override
			public Object execute(Session ses) throws HibernateException {
				Criteria cri = ses.createCriteria(User.class,"u");
				if(null!=user){
					cri.add(Restrictions.eq("u", user));
				}
				return cri.setProjection(Projections.count("id")).uniqueResult();
			}
		});
	}

}
