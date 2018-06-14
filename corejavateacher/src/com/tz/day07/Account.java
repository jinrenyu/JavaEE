package com.tz.day07;

public class Account
{
	private static long uid=10001;
	private long id;
	
	private String password;
	
	private String name;
	
	private String personId;
	
	private String email;
	
	private double balance;

	public Account()
	{
		super();
		id=uid++;
		
	}

	public Account(String password, String name, String personId, String email, double balance)
	{
		super();
		this.id = uid++;
		this.password = password;
		this.name = name;
		this.personId = personId;
		this.email = email;
		this.balance = balance;
	}



	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPersonId()
	{
		return personId;
	}

	public void setPersonId(String personId)
	{
		this.personId = personId;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public double getBalance()
	{
		return balance;
	}

	public void setBalance(double balance)
	{
		this.balance = balance;
	}

	@Override
	public String toString()
	{
		return "Account [id=" + id+ ", password=" + password + ", name=" + name + ", personId=" + personId + ", email="
				+ email + ", balance=" + balance + "]";
	}
	
	/*
	 * 取钱
	 */
	public void withdraw(double money)
	{
		if(balance >= money)
		{
			this.balance -= money;
		}else
		{
			System.out.println("你个穷鬼");
		}
	}
	
	/*
	 * 存钱
	 */
	public void deposit(double money)
	{
//		balance += money;
		setBalance(balance + money);
	}
}
