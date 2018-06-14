package com.tz.day07;


public class Bank
{

	private static Bank bank = 
			new Bank();
	private Bank(){accounts = new Account[4];}
	public static Bank newInstance()
	{
		return bank;
	}
	
	public final int MAX_ACCOUNTS = 100000;
	
	Account[] accounts;
	
	int length;
	
/*	public Bank()
	{
		accounts = new Account[4];
	}*/
	
	//添加账户
	public Account addAccount(String pwd,String pwd_true,
			String name,String personId,String email,int type)
	{
		//判断两个密码是否一致
		if(!pwd.equals(pwd_true))
		{
			return null;
		}
		//创建账户
		Account acc = null;
		//判断账户类型
		if(type == 0)
		{
			acc = new SavingAccount();
		}else if(type == 1)
		{
			acc = new CreditAccount();
		}else
		{
			System.out.println("该账户类型不存在");
			return null;
		}
		//将参数的值设置到acc对象的属性中
		acc.setName(name);
		acc.setPassword(pwd);
		acc.setPersonId(personId);
		acc.setEmail(email);
		//判断数组元素不为null的个数等于数组长度
		if(length == accounts.length)
		{
			//定义一个数组,长度为length的2倍
			Account[] accs = new Account[length * 2];
			if(length * 2 >= MAX_ACCOUNTS)
			{
				accs = new Account[MAX_ACCOUNTS];
			}
			//将accounts数组的元素添加到新数组中
			for (int i = 0; i < accounts.length; i++)
			{
				accs[i] = accounts[i];
			}
			//将新数组赋值给accounts
			accounts = accs;
		}
		//将acc对象添加到数组中
		accounts[length] = acc;
		//length的值自增长一次
		length++;
		return acc;
	}

	public Account login(long id,String pwd)
	{
		//定义一个Account对象,初始值为null
		Account acc = null;
		//遍历accounts数组
		for (int i = 0; i < accounts.length; i++)
		{
			//判断当前的对象的的id和密码是否相等
			if(accounts[i] != null && accounts[i].getId() == id && 
					accounts[i].getPassword().equals(pwd))
			{
				//把当前账户赋值给acc
				acc = accounts[i];
			}
		}
		
		return acc;
	}
	
	public Account deposit(long id,double money)
	{
		//定义一个Account对象,初始值为null
		Account acc = null;
		//遍历accounts数组
		for (int i = 0; i < accounts.length; i++)
		{
			//判断当前的对象的的id是否相等
			if(accounts[i] != null && accounts[i].getId() == id)
			{
				//把当前账户的余额设置为原余额+money
				accounts[i].setBalance(accounts[i].getBalance() + money);
				//设置之后将当前对象赋值给acc
				acc = accounts[i];
			}
		}
		return acc;
	}
	
	public Account withdraw(long id,double money)
	{
		//定义一个Account对象,初始值为null
		Account acc = null;
		//遍历accounts数组
		for (int i = 0; i < accounts.length; i++)
		{
			//判断当前的对象的的id是否相等
			if(accounts[i] != null && accounts[i].getId() == id)
			{
				//判断当前余额与money的大小
				if(money <= accounts[i].getBalance())
				{
					accounts[i].setBalance(acc.getBalance() - money);
				}else if(accounts[i] instanceof CreditAccount)
				{
					//将当前对象转换成CreditAccount类型
					CreditAccount cre = (CreditAccount)accounts[i];
					//判断余额+信用额度>=money
					if(cre.getBalance() + cre.getCeiling() >= money)
					{
						//设置信用额度
						cre.setCeiling(cre.getCeiling() + cre.getBalance() - money);
						//将当前账户的余额设置为0.0
						cre.setBalance(0.0);
						//将cre赋值给acc
						acc = cre;
					}else
					{
						System.out.println("你取不了如此多的钱");
					}
				}else
				{
					System.out.println("你个穷鬼");
				}
			}
		}
		return acc;
	}
	
	/*
	 * 设置透支额度
	 */
	public Account setCeiling(long id,double ceiling)
	{
		//定义一个Account对象,初始值为null
		Account acc = null;
		//遍历accounts数组
		for (int i = 0; i < accounts.length; i++)
		{
			//判断当前的对象的的id是否相等且类型是信用账户
			if(accounts[i] != null && accounts[i].getId() == id
					&& accounts[i] instanceof CreditAccount)
			{
				//将当前账户强制转换成CreditAccount类型
				CreditAccount cre = (CreditAccount)accounts[i];
				cre.setCeiling(ceiling);
				//将cre赋值给acc
				acc = cre;
			}
		}
		return acc;
	}
	
	
	/*
	 * 展示数组中的所有Account
	 */
	public void show()
	{
		for (int i = 0; i < length; i++)
		{
			System.out.println(accounts[i]);
		}
	}
	
}
