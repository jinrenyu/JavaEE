package com.exam.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.exam.dao.RecordDao;
import com.exam.entity.Record;
import com.exam.template.HibernateTemplate;
import com.exam.template.interf.QueryExecutor;

public class RecordDaoImpl implements RecordDao {

    public List<Record> getAllRecords() {
        HibernateTemplate<List<Record>> template = new HibernateTemplate<List<Record>>();
        return template.query(new QueryExecutor<List<Record>>() {

            @SuppressWarnings("unchecked")
            public List<Record> execute(Session session) throws HibernateException {
                String hql = "from Record order by startDate desc";
                List<Record> record = session.createQuery(hql).list();
                return record;
            }
        });
    }

    @Override
    public List<Record> searchByCondition(String sCode, String sType, Date ssDate, 
            Date seDate, Date esDate, Date eeDate) {
        HibernateTemplate<List<Record>> template = new HibernateTemplate<List<Record>>();
        return template.query(new QueryExecutor<List<Record>>() {

            @SuppressWarnings("unchecked")
            @Override
            public List<Record> execute(Session session) throws HibernateException {
                Criteria criteria = session.createCriteria(Record.class, "re").createAlias("re.room", "ro");
                if (sCode != null && !"".equals(sCode)) {
                    criteria.add(Restrictions.like("ro.code", "%" + sCode + "%"));
                }
                if (sType != null && !"".equals(sType)) {
                    criteria.add(Restrictions.eq("ro.roomType", sType));
                }
                if (ssDate != null) {
                    criteria.add(Restrictions.gt("re.startDate", ssDate));
                }
                if (seDate != null) {
                    criteria.add(Restrictions.lt("re.startDate", seDate));
                }
                if (esDate != null) {
                    criteria.add(Restrictions.gt("re.endDate", esDate));
                }
                if (eeDate != null) {
                    criteria.add(Restrictions.lt("re.endDate", eeDate));
                }
                return criteria.addOrder(Order.desc("re.startDate")).list();
            }
        });
    }

    @Override
    public void addReacord(Session session, Record record) {
        session.save(record);
    }

    @Override
    public Record getRecordById(Integer id) {
        HibernateTemplate<Record> template = new HibernateTemplate<>();
        return template.query(new QueryExecutor<Record>() {
            
            @Override
            public Record execute(Session session) throws HibernateException {
                return (Record) session.get(Record.class, id);
            }
        });
    }

    @Override
    public void checkOut(Session session, Integer recordId, Date endDate, Double total) {
        String hql ="update Record set endDate = :endDate, total = :total where id = :id";
        session.createQuery(hql).setParameter("endDate", endDate).setParameter("total", total)
            .setParameter("id", recordId).executeUpdate();
    }

}
