package com.tz.day10;

import org.junit.Test;

public class TestNotZeroException
{
	@Test
	public void test()
	{
		try
		{
			test1(5,0);
		} catch (NotZeroException e)
		{
			e.printStackTrace();
		}
	}
	
	public void test1(int m,int n) throws NotZeroException
	{
		if( n == 0)
		{
			throw new NotZeroException("除数不能为0");
		}
		System.out.println(m / n);
	}
	
}
