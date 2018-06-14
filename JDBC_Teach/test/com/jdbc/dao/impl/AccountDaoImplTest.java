package com.jdbc.dao.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jdbc.dao.AccountDao;
import com.jdbc.entity.Account;

public class AccountDaoImplTest {

    private AccountDao accountDao;
    
    @Before
    public void setUp() throws Exception {
        accountDao = new AccountDaoImpl();
    }

    @After
    public void tearDown() throws Exception {
        accountDao = null;
    }

    @Test
    public void testLogin() {
        System.out.println(accountDao.login("Jack", "123456"));
    }

    @Test
    public void testTransfer() {
        Account fromAcc = accountDao.login("Jack", "123456");
        Account toAcc = accountDao.login("Rose", "654321");
        accountDao.transfer(fromAcc, toAcc, 10000.00);
    }

}
