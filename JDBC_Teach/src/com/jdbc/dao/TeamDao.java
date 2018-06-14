package com.jdbc.dao;

import java.util.List;

import com.jdbc.entity.BasketballTeam;

public interface TeamDao {

    /**
     * 把一个包含了球员列表对象的球队对象解析插入到数据库中
     * @param basketballTeam 要进行添加插入的球队对象
     */
    void addTeam(BasketballTeam basketballTeam);
    
    /**
     * 根据一个球队对象删除其对应的球队记录
     * 如果该对象包含球员对象则对队员对象进行级联删除
     * @param basketballTeam 要删除的球队对象
     */
    void deleteTeam(BasketballTeam basketballTeam);

    /**
     * 查询所有球队信息,返回球员列表对象
     * 若球队中包含球员信息,则球员信息同样
     * 要求封装到对应球队对象中
     * @return 封装好的球队列表对象
     */
    List<BasketballTeam> findAllTeam();

    /**
     * 使用一条sql语句查询所有球队信息,返回球员列表对象
     * 若球队中包含球员信息,则球员信息同样
     * 要求封装到对应球队对象中
     * @return 封装好的球队列表对象
     */
    List<BasketballTeam> findAllTeamByOneSql();
    
    /**
     * 兴趣题
     * 批量添加球队对象
     * @param basketballTeam 球队列表对象
     */
    void addTeams(List<BasketballTeam> basketballTeam);
}
