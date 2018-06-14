package com.hibernate.dao;

import java.util.List;

import com.hibernate.entity.Worker;

public interface WorkerDao {

    /**
     * ����id����һ����Ӧ�Ĺ��˶���
     * @param id Ҫ���ҹ��˼�¼��ID
     * @return ��װ�õĹ��˶���ʵ��
     */
    Worker findWorkerById(int id);
    /**
     * �������еĹ��˼�¼
     * @return ��װ�õĹ����б����
     */
    List<Worker> findAllWorkers();
    /**
     * ���һ�����˶������ݿ���
     * @param worker ����ӵĹ��˶���(����id)
     */
    void addWorker(Worker worker);
    /**
     * ���һ���������ݵ����ݿ���
     * @param workers �����б����
     */
    void addWorkers(List<Worker> workers);
    /**
     * ����һ�����˶������һ�����ݿ��Ӧ��¼
     * @param worker ���˶���(��id)
     */
    void updateWorker(Worker worker);
    /**
     * ���ݹ��˶���ɾ��һ����Ӧ�ļ�¼
     * @param worker Ҫɾ���Ĺ��˶���
     */
    void deleteWorker(Worker worker);
}
