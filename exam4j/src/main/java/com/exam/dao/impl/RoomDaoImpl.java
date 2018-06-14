package com.exam.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.exam.dao.RoomDao;
import com.exam.entity.Room;
import com.exam.entity.enumeration.Status;
import com.exam.template.HibernateTemplate;
import com.exam.template.interf.QueryExecutor;
import com.exam.vo.Option;

public class RoomDaoImpl implements RoomDao {

    @Override
    public List<Option> getRoomOption(String code, String value) {
        HibernateTemplate<List<Option>> template = new HibernateTemplate<>();
        return template.query(new QueryExecutor<List<Option>>() {
            
            @SuppressWarnings("unchecked")
            @Override
            public List<Option> execute(Session session) throws HibernateException {
                String hql = "select distinct new com.exam.vo.Option(" 
                        + code + ", " + value + ") from Room";
                return session.createQuery(hql).list();
            }
        });
    }

    @Override
    public List<Option> getRoomOption(String code, String value, Status[] status) {
        HibernateTemplate<List<Option>> template = new HibernateTemplate<>();
        return template.query(new QueryExecutor<List<Option>>() {
            
            @SuppressWarnings("unchecked")
            @Override
            public List<Option> execute(Session session) throws HibernateException {
                String hql = "select distinct new com.exam.vo.Option(" 
                        + code + ", " + value + ") from Room where status in (:status)";
                return session.createQuery(hql).setParameterList("status", status).list();
            }
        });
    }

    @Override
    public Room getRoomByCode(String code) {
        HibernateTemplate<Room> template = new HibernateTemplate<>();
        return template.query(new QueryExecutor<Room>() {
            
            @Override
            public Room execute(Session session) throws HibernateException {
                String hql = "from Room where code = :code";
                return (Room) session.createQuery(hql).setParameter("code", code).uniqueResult();
            }
        });
    }

    @Override
    public void updateRoomStatus(Session session, Integer id, Status status) {
        session.createQuery("update Room set status = :status where id = :id")
            .setParameter("status", status).setParameter("id", id).executeUpdate();
    }

    @Override
    public Room getRoomById(Session session, Integer id) {
        return (Room) session.get(Room.class, id);
    }
    

}
