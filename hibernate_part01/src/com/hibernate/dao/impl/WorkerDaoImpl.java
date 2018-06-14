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
                // 第一个参数需要封装成的类的class对象, 第二个参数是主键
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
//        // 第一步, 加载配置文件(Configuration就对应了一个配置文件)
//        // 如果configure()方法不使用任何参数,代表加载src目录下名为hibernate.cfg.xml这个配置文件
//        // 以项目根路径为参考路径
////        File file = new File("src/com/hibernate/dao/my_hibernate.xml");
//        // 如果是字符串的配置方式, 以src为参考路径的根路径
//        Configuration cfg = new Configuration().configure();
//        // 第二步, 根据配置文件创建对应的工厂类(SessionFactory类似于jdbc中的DriverManager)
//        // hibernate3.x.x的写法,已经过时了(不推荐使用)
////        SessionFactory sf = cfg.buildSessionFactory();
//
//        // hibernate4.x.x推荐的写法
//        ServiceRegistry sr = new StandardServiceRegistryBuilder()
//                .applySettings(cfg.getProperties()).build();
//        SessionFactory sf = cfg.buildSessionFactory(sr);
//        Session ses = null;
//        Transaction tx = null;
//        try {
//            // 第三步, 根据工厂类生成出对应的连接对象(会话)
//            // Session = Connection + Cache
//            ses = sf.openSession();
//            // 第四步, 根据会话创建事务控制对象(不同于JDBC,hibernate默认关闭事务的自动提交)
//            tx = ses.beginTransaction();
//            // 第五步, 在事务中进行具体的业务操作
//            ses.save(worker);
//            // 第六步, 手动提交事务
//            tx.commit();
//            // HibernateException是框架中其他所有异常类的父类,继承RuntimeException
//            // 需要时需要手动进行try catch处理
//        } catch(HibernateException hex) {
//            // 第八步, 发生异常进行回滚
//            if (tx != null) {
//                tx.rollback();
//            }
//            hex.printStackTrace();
//        } finally {
//            try {
//                if (ses != null) {
//                    // 第七步, 关闭会话
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
//            // 第三步, 根据工厂类生成出对应的连接对象(会话)
//            // Session = Connection + Cache
//            ses = HibernateUtil.getSession();
//            // 第四步, 根据会话创建事务控制对象(不同于JDBC,hibernate默认关闭事务的自动提交)
//            tx = ses.beginTransaction();
//            // 第五步, 在事务中进行具体的业务操作
//            ses.save(worker);
//            // 第六步, 手动提交事务
//            tx.commit();
//            // HibernateException是框架中其他所有异常类的父类,继承RuntimeException
//            // 需要时需要手动进行try catch处理
//        } catch(HibernateException hex) {
//            // 第八步, 发生异常进行回滚
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
                // 防止不可预知的提交状况
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
