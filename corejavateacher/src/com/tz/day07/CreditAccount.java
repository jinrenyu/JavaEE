package com.tz.day07;

public class CreditAccount extends Account
{
    private double ceiling;
    
    

	public CreditAccount(long id, String password, String name, String personId, String email, double balance,
			double ceiling)
	{
		super(password, name, personId, email, balance);
		this.ceiling = ceiling;
	}

	public CreditAccount()
	{
		super();
	}


	public double getCeiling()
	{
		return ceiling;
	}

	public void setCeiling(double ceiling)
	{
		this.ceiling = ceiling;
	}
}
