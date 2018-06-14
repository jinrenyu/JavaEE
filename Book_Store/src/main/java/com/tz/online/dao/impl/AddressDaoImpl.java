package com.tz.online.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.tz.online.dao.IAddressDao;
import com.tz.online.entity.Address;
import com.tz.online.util.HibernateTemplates;
import com.tz.online.util.ICallBack;

public class AddressDaoImpl implements IAddressDao {

	@Override
	public void save(Address address) {
		HibernateTemplates.execute(new ICallBack() {
			
			@Override
			public Object execute(Session ses) throws HibernateException {
				ses.save(address);
				return null;
			}
		});

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Address> findByUserId(Long userId) {
		
		return (List<Address>) HibernateTemplates.execute(new ICallBack() {
			
			@Override
			public Object execute(Session ses) throws HibernateException {
				Criteria criteria = ses.createCriteria(Address.class,"a");
				if(null != userId){
					criteria.add(Restrictions.eq("a.user.userId", userId));
				}
				return criteria.list();
				
				/*String hql = "select a from Address a where a.user.userId = ?";
                return ses.createQuery(hql).setParameter(0, userId).list();*/
				
				
			}
		});
	}

	@Override
	public void delete(Address a) {
		HibernateTemplates.execute(new ICallBack() {
			
			@Override
			public Object execute(Session ses) throws HibernateException {
				
				return ses.createQuery("delete from Address where id =:id ").setParameter("id", a.getAddressId()).executeUpdate();
			}
		});

	}

	@Override
	public Address findById(Long id) {
		
		return (Address) HibernateTemplates.execute(new ICallBack() {
			
			@Override
			public Object execute(Session ses) throws HibernateException {
				
				return ses.get(Address.class, id);
			}
		});
	}

	@Override
	public void update(Address a) {
		HibernateTemplates.execute(new ICallBack() {
			
			@Override
			public Object execute(Session ses) throws HibernateException {
				ses.update(a);
				return null;
			}
		});

	}

}
