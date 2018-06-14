package com.tz.day07;

public class AccountService
{
	/*
	 * 存钱
	 */
	public void deposit(double money, Account acc)
	{
		acc.setBalance(acc.getBalance() + money);
	}
	
	/*
	 * 取钱
	 */
	public void withdraw(double money, Account acc)
	{
		if(acc.getBalance() >= money)
		{
			acc.setBalance(acc.getBalance() - money);
		}else
		{
			System.out.println("你个穷鬼");
		}
	}
}
