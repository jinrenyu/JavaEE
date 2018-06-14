package com.jdbc.dao;

import com.jdbc.entity.Account;

public interface AccountDao {

    /**
     * ���ݶ�Ӧ���˺����뷵���˻�����, ���˺�������󷵻ؿն���
     * @param username �˺�
     * @param password ����
     * @return �˻�����
     */
    Account login(String username, String password);
    
    /**
     * ��ת���˻�ת���ض��Ľ��money��ת���˻�
     * @param fromAcc �ʽ�ת���˻�
     * @param toAcc �ʽ�ת���˻�
     * @param money ת�˽��
     */
    void transfer(Account fromAcc, Account toAcc, Double money);
}
