package com.hibernate.dao;

import java.util.List;

import com.hibernate.entity.Worker;

public interface WorkerDao {

    /**
     * 根据id查找一个对应的工人对象
     * @param id 要查找工人记录的ID
     * @return 封装好的工人对象实例
     */
    Worker findWorkerById(int id);
    /**
     * 查找所有的工人记录
     * @return 封装好的工人列表对象
     */
    List<Worker> findAllWorkers();
    /**
     * 添加一个工人对象到数据库中
     * @param worker 被添加的工人对象(不含id)
     */
    void addWorker(Worker worker);
    /**
     * 添加一批工人数据到数据库中
     * @param workers 工人列表对象
     */
    void addWorkers(List<Worker> workers);
    /**
     * 根据一个工人对象更新一条数据库对应记录
     * @param worker 工人对象(含id)
     */
    void updateWorker(Worker worker);
    /**
     * 根据工人对象删除一条对应的记录
     * @param worker 要删除的工人对象
     */
    void deleteWorker(Worker worker);
}
