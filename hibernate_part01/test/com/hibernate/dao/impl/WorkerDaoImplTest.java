package com.hibernate.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hibernate.dao.WorkerDao;
import com.hibernate.entity.Worker;

public class WorkerDaoImplTest {
    
    private WorkerDao workerDao;

    @Before
    public void setUp() throws Exception {
        workerDao = new WorkerDaoImpl();
    }

    @After
    public void tearDown() throws Exception {
        workerDao = null;
    }

    @Test
    public void testFindWorkerById() {
        // 返回对象中如果有Date的成员其类型是java.sql.Date
        System.out.println(workerDao.findWorkerById(8));
    }

    @Test
    public void testFindAllWorkers() {
        List<Worker> workers = workerDao.findAllWorkers();
        for (Worker worker : workers) {
            System.out.println(worker);
        }
    }

    @Test
    public void testAddWorker() {
        workerDao.addWorker(new Worker("Ray", 23, new BigDecimal(100.00), new Date()));
    }

    @Test
    public void testAddWorkers() {
        List<Worker> workers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            workers.add(new Worker("James" + i, 43, new BigDecimal(321.32), new Date()));
        }
        workerDao.addWorkers(workers);
    }

    @Test
    public void testUpdateWorker() {
        Worker worker = new Worker();
        worker.setId(5);
        worker.setName("Rose");
        workerDao.updateWorker(worker);
    }

    @Test
    public void testDeleteWorker() {
        Worker worker = new Worker();
        worker.setId(3);
        workerDao.deleteWorker(worker);
    }

}
