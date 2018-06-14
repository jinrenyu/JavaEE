package com.tz.day08;

import org.junit.Test;

import com.tz.day07.Account;
import com.tz.day07.Bank;

public class TestBank
{
	@Test
	public void test()
	{
		Bank bank = Bank.newInstance();
		bank.addAccount("123456", "123456", "张三", "123456789", "123456@123.com", 0);
		bank.addAccount( "123456", "123456", "张三", "123456789", "123456@123.com", 0);
		bank.addAccount( "123456", "123456", "张三", "123456789", "123456@123.com", 1);
		bank.addAccount( "123456", "123456", "张三", "123456789", "123456@123.com", 0);
		bank.addAccount( "123456", "123456", "张三", "123456789", "123456@123.com", 1);
	
		Account acc = bank.deposit(10003, 500);
		System.out.println(acc);
		System.out.println("-------------------");
		
		Account a = bank.setCeiling(10003, 5000);
		System.out.println(a);
		System.out.println("********************");
		
		bank.withdraw(10003, 1000);
		
		bank.show();
		
		Account ac = bank.login(10001, "123456");
		System.out.println(ac);
		System.out.println("--------------");
		
	}
}
