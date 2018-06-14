package com.hibernate.other;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.hibernate.entity.Doctor;
import com.hibernate.template.HibernateTemplate;
import com.hibernate.template.interf.UpdateExecutor;

/**
 * ����������ʾHibernate��һ������(Session����)������
 * @author Chris
 *
 * 2017��3��7������9:52:03
 */
public class TestFirstCache {

    public static void main(String[] args) {
        HibernateTemplate<Doctor> template = new HibernateTemplate<>();
        // ֻ�������ڴ��������ݿ��в�ѯ������ؼ�¼�Լ����ڻỰ�����еĶ���ʵ����״̬��Ϊ'˲̬'
//        Doctor transientDoctor = new Doctor("Tom", 123.23, new Date(), Gender.MALE);
        template.update(new UpdateExecutor() {
            
            @Override
            public void execute(Session session) throws HibernateException {
                //doctorʵ��Ϊһ��'�־�̬����', ���ݿ�/�ڴ�/�Ự�����ж����ҵ��Ķ���
                Doctor doctor = (Doctor) session.get(Doctor.class, 3);
//                doctor.setName("Chris");
                Doctor doctor2 = (Doctor) session.get(Doctor.class, 3);
                System.out.println(doctor == doctor2);
                 //��doctorʵ���ӻ����������ȥ
//                session.evict(doctor);
                 //���������ȫ���Ķ���
//                session.clear();
                 //��ָ���������¼��뵽������, ���뻺���ʱ����Զ�����SQL���(���������ݿ�)
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
        
        // detachedDoctor����ʵ��Ϊһ������̬��ʵ��, ָ���ڴ�/���ݿ����ҵ���Ӧ�ļ�¼,���ǻỰ������û��
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
