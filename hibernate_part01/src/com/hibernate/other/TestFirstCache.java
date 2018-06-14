package com.hibernate.other;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.hibernate.entity.Doctor;
import com.hibernate.template.HibernateTemplate;
import com.hibernate.template.interf.UpdateExecutor;

/**
 * 本类用来演示Hibernate中一级缓存(Session缓存)的例子
 * @author Chris
 *
 * 2017年3月7日上午9:52:03
 */
public class TestFirstCache {

    public static void main(String[] args) {
        HibernateTemplate<Doctor> template = new HibernateTemplate<>();
        // 只存在于内存中在数据库中查询不到相关记录以及不在会话缓存中的对象实例的状态称为'瞬态'
//        Doctor transientDoctor = new Doctor("Tom", 123.23, new Date(), Gender.MALE);
        template.update(new UpdateExecutor() {
            
            @Override
            public void execute(Session session) throws HibernateException {
                //doctor实例为一个'持久态对象', 数据库/内存/会话缓存中都能找到的对象
                Doctor doctor = (Doctor) session.get(Doctor.class, 3);
//                doctor.setName("Chris");
                Doctor doctor2 = (Doctor) session.get(Doctor.class, 3);
                System.out.println(doctor == doctor2);
                 //把doctor实例从缓存中清除出去
//                session.evict(doctor);
                 //清除缓存中全部的对象
//                session.clear();
                 //把指定对象重新加入到缓存中, 加入缓存的时候会自动运行SQL语句(即访问数据库)
//                session.merge(doctor2);
//                System.out.println("---------------------------------------");
//                session.get(Doctor.class, 3);
//                session.get(Doctor.class, 7);
//                System.out.println("---------------------------------------");
            }
        });
        
//        template.update(new UpdateExecutor() {
//            
//            @Override
//            public void execute(Session session) throws HibernateException {
//                session.get(Doctor.class, 3);
//            }
//        });
        
        // detachedDoctor对象实例为一个游离态的实例, 指的内存/数据库能找到对应的记录,但是会话缓存中没有
//        Doctor detachedDoctor = template.query(new QueryExecutor<Doctor>() {
//            
//            @Override
//            public Doctor execute(Session session) throws HibernateException {
//                return (Doctor) session.get(Doctor.class, 3);
//            }
//        });
//        detachedDoctor.setName("Allen");
//        
//        DoctorDao doctorDao = new DoctorDaoImpl();
//        doctorDao.addDoctor(transientDoctor);
//        doctorDao.addDoctor(detachedDoctor);
    }

}
