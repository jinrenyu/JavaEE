package com.jdbc.dao;

import com.jdbc.entity.Account;

public interface AccountDao {

    /**
     * 根据对应的账号密码返回账户对象, 如账号密码错误返回空对象
     * @param username 账号
     * @param password 密码
     * @return 账户对象
     */
    Account login(String username, String password);
    
    /**
     * 从转出账户转账特定的金额money给转入账户
     * @param fromAcc 资金转出账户
     * @param toAcc 资金转入账户
     * @param money 转账金额
     */
    void transfer(Account fromAcc, Account toAcc, Double money);
}
