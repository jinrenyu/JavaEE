package com.tz.online.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.tz.online.dao.IBookDao;
import com.tz.online.entity.Book;
import com.tz.online.entity.Category;
import com.tz.online.util.HibernateTemplates;
import com.tz.online.util.ICallBack;

public class BookDaoImpl implements IBookDao {

	

	@Override
	public Book findById(Long id) {
		
		return (Book) HibernateTemplates.execute(new ICallBack() {
			
			@Override
			public Object execute(Session ses) throws HibernateException {
				
				return ses.get(Book.class, id);
			}
		});
	}

	@Override
	public long getRows(Category category,String bookName) {
		
		return (long) HibernateTemplates.execute(new ICallBack() {
			
			@Override
			public Object execute(Session ses) throws HibernateException {
				//创建criteria对象
				Criteria criteria = ses.createCriteria(Book.class,"b");
				if(null !=bookName && bookName.trim().length()>0){
					criteria.add(Restrictions.like(bookName, "%"+bookName+"%"));
				}
				if(null != category){
					criteria.add(Restrictions.eq("b.category", category));
				}
				return criteria.setProjection(Projections.count("id")).uniqueResult();
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> findByCondition(String bookName, Category category, long pageNow, long pageSize) {
		
		return (List<Book>) HibernateTemplates.execute(new ICallBack() {
			
			@Override
			public Object execute(Session ses) throws HibernateException {
				//创造criteria
				Criteria criteria = ses.createCriteria(Book.class,"b");
				if(null!=bookName && bookName.trim().length()>0){
					criteria.add(Restrictions.like("b.bookName", "%"+bookName+"%"));
				}
				if(null != category){
					criteria.add(Restrictions.eq("b.category", category));
				}
				return criteria.setFirstResult((int)((pageNow-1)*pageSize)).setMaxResults((int)pageSize).list();
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> fingByCategory(Category category) {
		
		return (List<Book>) HibernateTemplates.execute(new ICallBack() {
			
			@Override
			public Object execute(Session ses) throws HibernateException {
				//创造criteria
				Criteria criteria = ses.createCriteria(Book.class,"b");
				if(null != category){
					criteria.add(Restrictions.eq("b.category", category));
				}
				return criteria.list();
			}
		});
	}

}
