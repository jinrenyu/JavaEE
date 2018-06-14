package com.hibernate.other;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.hibernate.entity.Worker;
import com.hibernate.template.HibernateTemplate;
import com.hibernate.template.interf.QueryExecutor;

public class TestGetAndLoad {

    public static void main(String[] args) {
        
        HibernateTemplate<Worker> template = new HibernateTemplate<>();
        Worker w1 = template.query(new QueryExecutor<Worker>() {
            
            @Override
            public Worker execute(Session session) throws HibernateException {
//                Worker worker1 = (Worker) session.get(Worker.class, 3);
//                Worker worker2 = (Worker) session.load(Worker.class, 3);
//                Worker worker1 = (Worker) session.get(Worker.class, 300);
//                System.out.println(worker1);
                Worker worker2 = (Worker) session.load(Worker.class, 400);
//                System.out.println(worker2);
//                System.out.println(worker2.getName());
//                System.out.println(worker1.getClass());
//                System.out.println(worker2.getClass());
//                System.out.println(worker);
                return worker2;
            }
        });

//        System.out.println(w1.getId());
//        System.out.println(w1.getName());
        System.out.println(w1);
        System.out.println(w1.getClass());
    }
}
