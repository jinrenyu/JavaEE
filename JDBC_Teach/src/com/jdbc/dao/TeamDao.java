package com.jdbc.dao;

import java.util.List;

import com.jdbc.entity.BasketballTeam;

public interface TeamDao {

    /**
     * ��һ����������Ա�б�������Ӷ���������뵽���ݿ���
     * @param basketballTeam Ҫ������Ӳ������Ӷ���
     */
    void addTeam(BasketballTeam basketballTeam);
    
    /**
     * ����һ����Ӷ���ɾ�����Ӧ����Ӽ�¼
     * ����ö��������Ա������Զ�Ա������м���ɾ��
     * @param basketballTeam Ҫɾ������Ӷ���
     */
    void deleteTeam(BasketballTeam basketballTeam);

    /**
     * ��ѯ���������Ϣ,������Ա�б����
     * ������а�����Ա��Ϣ,����Ա��Ϣͬ��
     * Ҫ���װ����Ӧ��Ӷ�����
     * @return ��װ�õ�����б����
     */
    List<BasketballTeam> findAllTeam();

    /**
     * ʹ��һ��sql����ѯ���������Ϣ,������Ա�б����
     * ������а�����Ա��Ϣ,����Ա��Ϣͬ��
     * Ҫ���װ����Ӧ��Ӷ�����
     * @return ��װ�õ�����б����
     */
    List<BasketballTeam> findAllTeamByOneSql();
    
    /**
     * ��Ȥ��
     * ���������Ӷ���
     * @param basketballTeam ����б����
     */
    void addTeams(List<BasketballTeam> basketballTeam);
}
