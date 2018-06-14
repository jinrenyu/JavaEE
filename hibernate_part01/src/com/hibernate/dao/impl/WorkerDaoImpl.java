package com.hibernate.dao.impl;

import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.hibernate.dao.WorkerDao;
import com.hibernate.entity.Worker;
import com.hibernate.template.HibernateTemplate;
import com.hibernate.template.interf.QueryExecutor;
import com.hibernate.template.interf.UpdateExecutor;

public class WorkerDaoImpl implements WorkerDao {

    @Override
    public Worker findWorkerById(int id) {
        HibernateTemplate<Worker> template = new HibernateTemplate<>();
        return template.query(new QueryExecutor<Worker>() {
            
            @Override
            public Worker execute(Session session) throws HibernateException {
                // ��һ��������Ҫ��װ�ɵ����class����, �ڶ�������������
                return (Worker) session.get(Worker.class, id);
            }
        });
    }

    @Override
    public List<Worker> findAllWorkers() {
        HibernateTemplate<List<Worker>> template = new HibernateTemplate<>();
        return template.query(new QueryExecutor<List<Worker>>() {
            
            @SuppressWarnings("unchecked")
            @Override
            public List<Worker> execute(Session session) throws HibernateException {
                return session.createQuery("from Worker").list();
            }
        });
    }

//    @Override
//    public void addWorker(Worker worker) {
//        // ��һ��, ���������ļ�(Configuration�Ͷ�Ӧ��һ�������ļ�)
//        // ���configure()������ʹ���κβ���,�������srcĿ¼����Ϊhibernate.cfg.xml��������ļ�
//        // ����Ŀ��·��Ϊ�ο�·��
////        File file = new File("src/com/hibernate/dao/my_hibernate.xml");
//        // ������ַ��������÷�ʽ, ��srcΪ�ο�·���ĸ�·��
//        Configuration cfg = new Configuration().configure();
//        // �ڶ���, ���������ļ�������Ӧ�Ĺ�����(SessionFactory������jdbc�е�DriverManager)
//        // hibernate3.x.x��д��,�Ѿ���ʱ��(���Ƽ�ʹ��)
////        SessionFactory sf = cfg.buildSessionFactory();
//
//        // hibernate4.x.x�Ƽ���д��
//        ServiceRegistry sr = new StandardServiceRegistryBuilder()
//                .applySettings(cfg.getProperties()).build();
//        SessionFactory sf = cfg.buildSessionFactory(sr);
//        Session ses = null;
//        Transaction tx = null;
//        try {
//            // ������, ���ݹ��������ɳ���Ӧ�����Ӷ���(�Ự)
//            // Session = Connection + Cache
//            ses = sf.openSession();
//            // ���Ĳ�, ���ݻỰ����������ƶ���(��ͬ��JDBC,hibernateĬ�Ϲر�������Զ��ύ)
//            tx = ses.beginTransaction();
//            // ���岽, �������н��о����ҵ�����
//            ses.save(worker);
//            // ������, �ֶ��ύ����
//            tx.commit();
//            // HibernateException�ǿ�������������쳣��ĸ���,�̳�RuntimeException
//            // ��Ҫʱ��Ҫ�ֶ�����try catch����
//        } catch(HibernateException hex) {
//            // �ڰ˲�, �����쳣���лع�
//            if (tx != null) {
//                tx.rollback();
//            }
//            hex.printStackTrace();
//        } finally {
//            try {
//                if (ses != null) {
//                    // ���߲�, �رջỰ
//                    ses.close();
//                }
//            } catch(HibernateException hex) {
//                hex.printStackTrace();
//            }
//        }
//    }
    
//    @Override
//    public void addWorker(Worker worker) {
//        Session ses = null;
//        Transaction tx = null;
//        try {
//            // ������, ���ݹ��������ɳ���Ӧ�����Ӷ���(�Ự)
//            // Session = Connection + Cache
//            ses = HibernateUtil.getSession();
//            // ���Ĳ�, ���ݻỰ����������ƶ���(��ͬ��JDBC,hibernateĬ�Ϲر�������Զ��ύ)
//            tx = ses.beginTransaction();
//            // ���岽, �������н��о����ҵ�����
//            ses.save(worker);
//            // ������, �ֶ��ύ����
//            tx.commit();
//            // HibernateException�ǿ�������������쳣��ĸ���,�̳�RuntimeException
//            // ��Ҫʱ��Ҫ�ֶ�����try catch����
//        } catch(HibernateException hex) {
//            // �ڰ˲�, �����쳣���лع�
//            if (tx != null) {
//                tx.rollback();
//            }
//            hex.printStackTrace();
//        } finally {
//            HibernateUtil.close(ses);
//        }
//    }
    
    @Override
    public void addWorker(Worker worker) {
        HibernateTemplate<Worker> template = new HibernateTemplate<Worker>();
        template.update(new UpdateExecutor() {
            
            @Override
            public void execute(Session session) throws HibernateException {
                session.save(worker);
            }
        });
    }

    @Override
    public void addWorkers(List<Worker> workers) {
        HibernateTemplate<List<Worker>> template = new HibernateTemplate<>();
        template.update(new UpdateExecutor() {
            
            @Override
            public void execute(Session session) throws HibernateException {
                int count = 0;
                for (Worker worker : workers) {
                    session.save(worker);
                    if (++count % 100 == 0) {
                        session.flush();
                        session.clear();
                    }
                }
            }
        });
    }

    @Override
    public void updateWorker(Worker worker) {
        HibernateTemplate<Worker> template = new HibernateTemplate<Worker>();
        template.update(new UpdateExecutor() {
            
            @Override
            public void execute(Session session) throws HibernateException {
                Worker tempWorker = (Worker) session.get(Worker.class, worker.getId());
                if (worker.getName() != null) {
                    tempWorker.setName(worker.getName());
                }
                if (worker.getSalary() != null) {
                    tempWorker.setSalary(worker.getSalary());
                }
                if (worker.getAge() != null) {
                    tempWorker.setAge(worker.getAge());
                }
                if (worker.getBirth() != null) {
                    tempWorker.setBirth(worker.getBirth());
                }
                // ��ֹ����Ԥ֪���ύ״��
                session.update(tempWorker);
            }
        });
    }

    @Override
    public void deleteWorker(Worker worker) {
        HibernateTemplate<Worker> template = new HibernateTemplate<Worker>();
        template.update(new UpdateExecutor() {
            
            @Override
            public void execute(Session session) throws HibernateException {
                Worker tempWorker = (Worker) session.get(Worker.class, worker.getId());
                session.delete(tempWorker);
            }
        });

    }

}
